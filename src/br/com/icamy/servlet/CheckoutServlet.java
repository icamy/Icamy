package br.com.icamy.servlet;

import java.io.IOException;
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

/*
 * Servlet mapeada para tratar o retorno do usu�rio ao site ap�s realizar o pagamento no ambiente do PagSeguro
 */
@WebServlet("/Checkout")
public class CheckoutServlet extends HttpServlet {
	   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPgto = request.getParameter("id_pagseguro"); // l� o ID do pagamento retornado pelo PagSeguro na pr�pria url
		IntegraPagSeguro ips = new IntegraPagSeguro(idPgto); // instancia um novo objeto do tipo IntegraPagSeguro
		Map<String, String> dadosPgto = null;
		String xml = ips.getXML(); // chama o m�todo getXML(), que recupera do servidor do PagSeguro uma string com os dados do pgto
		try {
			dadosPgto = ips.parseXML(xml); // faz parse dos dados da String para a nota��o XML
			
			// os dados contidos no XML s�o recuperados atrav�s do m�todo .get() e gravados no BD
			Oferta oferta = new Oferta();
			oferta.setCodigo(Integer.parseInt(dadosPgto.get("cdOferta")));
			Contratacao contratacao = new Contratacao();
			contratacao.setOferta(oferta);
			contratacao.setCliente(new ClienteBO().getRandom());
			contratacao.setValor(Double.parseDouble(dadosPgto.get("valor")));
			ContratacaoBO contratacaoBO = new ContratacaoBO();
			contratacaoBO.put(contratacao); // gravando dados da contrata��o

			int cdContratacao = new ContratacaoBO().getUltimoCodigo();
			contratacao.setCodigo(cdContratacao);
			
			ModalidadePgto modalidade = new ModalidadePgto();
			modalidade.setCodigo(3);
			Pagamento pagamento = new Pagamento();
			pagamento.setContratacao(contratacao);
			pagamento.setModalidadePgto(modalidade);
			pagamento.setValor(Double.parseDouble(dadosPgto.get("valor")));
			pagamento.setCodigoIdentificador(dadosPgto.get("cdPgto"));
			new PagamentoBO().put(pagamento); // gravando dados do pagamento
			
			dadosPgto.put("clienteNome", contratacao.getCliente().getNome());
			dadosPgto.put("clienteEmail", contratacao.getCliente().getEmail());
			request.setAttribute("dadosPgto", dadosPgto);
		} catch (Exception e) {
			e.getMessage();
		}
		// redireciona para a p�gina confirma_pgto.jsp, que exiibe os dados do pagamento realizado
		request.getRequestDispatcher("/confirma_pgto.jsp").forward(request, response);
	}

    // n�o houve implementa��o para as requisi��es do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
