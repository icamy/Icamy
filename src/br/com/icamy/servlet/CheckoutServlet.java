package br.com.icamy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.icamy.beans.Contratacao;
import br.com.icamy.beans.ModalidadePgto;
import br.com.icamy.beans.Oferta;
import br.com.icamy.beans.Pagamento;
import br.com.icamy.bo.ClienteBO;
import br.com.icamy.bo.ContratacaoBO;
import br.com.icamy.bo.PagamentoBO;
import br.com.icamy.pgto.IntegraPagSeguro;

@WebServlet("/Checkout")
public class CheckoutServlet extends HttpServlet {
	   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		String idPgto = "5FFC7F6F-2D92-42B3-B0D0-202AFA626B3C";
		String idPgto = request.getParameter("id_pagseguro");
		IntegraPagSeguro ips = new IntegraPagSeguro(idPgto);
		Map<String, String> dadosPgto = null;
		String xml = ips.getXML();
		try {
			dadosPgto = ips.parseXML(xml);
			
			Oferta oferta = new Oferta();
			out.println("instanciando oferta");
			oferta.setCodigo(Integer.parseInt(dadosPgto.get("cdOferta")));
			Contratacao contratacao = new Contratacao();
			contratacao.setOferta(oferta);
			contratacao.setCliente(new ClienteBO().getRandom());
			out.println("chamou ClienteBO()");
			contratacao.setValor(Double.parseDouble(dadosPgto.get("valor")));
			ContratacaoBO contratacaoBO = new ContratacaoBO();
			contratacaoBO.put(contratacao);
			out.println("chamou ContratacaoBO().put()");
			int cdContratacao = new ContratacaoBO().getUltimoCodigo();
			contratacao.setCodigo(cdContratacao);
			out.println("chamou ContratacaoBO().getUltimoCodigo()");
			
			ModalidadePgto modalidade = new ModalidadePgto();
			out.println("instanciando modalidade");
			modalidade.setCodigo(3);
			Pagamento pagamento = new Pagamento();
			out.println("instanciando pagamento");
			pagamento.setContratacao(contratacao);
			pagamento.setModalidadePgto(modalidade);
			pagamento.setValor(Double.parseDouble(dadosPgto.get("valor")));
			pagamento.setCodigoIdentificador(dadosPgto.get("cdPgto"));
			
			out.println("vai chamar PagamentoBO().put()");
			new PagamentoBO().put(pagamento);
//			new PagamentoDAO().insert(pagamento);
			out.println("chamou PagamentoBO()");
			
			dadosPgto.put("clienteNome", contratacao.getCliente().getNome());
			out.println("setou clienteNome");
			dadosPgto.put("clienteEmail", contratacao.getCliente().getEmail());
			out.println("setou clienteEmail");
			request.setAttribute("dadosPgto", dadosPgto);
		} catch (Exception e) {
			e.getMessage();
			out.println("caiu no catch");
		}
		request.getRequestDispatcher("/confirma_pgto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
