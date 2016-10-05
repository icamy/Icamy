package br.com.icamy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.icamy.beans.Oferta;
import br.com.icamy.beans.Prestador;
import br.com.icamy.beans.Servico;
import br.com.icamy.bo.OfertaBO;
import br.com.icamy.bo.PrestadorBO;
import br.com.icamy.bo.ServicoBO;

@WebServlet("/Oferta")
public class OfertaServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Abriu a servlet");

		String op = request.getParameter("op");
		int cdOferta = Integer.parseInt(request.getParameter("oferta"));
		
		try {
			
			Prestador p = new PrestadorBO().get(5);
			request.setAttribute("prestador", p);
			
			if (op == null) {
				List<Oferta> lstOfertas = new OfertaBO().getByPrestador(p.getCodigo());
				request.setAttribute("lista", true);
				request.setAttribute("ofertas", lstOfertas);
				request.getRequestDispatcher("/oferta_list.jsp").forward(request, response);
			} else if (op.equals("inserir") && cdOferta > 0) {
				List<Servico> lstServicos = new ServicoBO().getAll();
				request.setAttribute("servicos", lstServicos);
				request.getRequestDispatcher("/oferta_update.jsp").forward(request, response);
			} else if (op.equals("atualizar")) {
				List<Servico> lstServicos = new ServicoBO().getAll();
				Oferta oferta = new OfertaBO().get(cdOferta);
				request.setAttribute("servicos", lstServicos);
				request.setAttribute("oferta", oferta);
				request.getRequestDispatcher("/oferta_update.jsp").forward(request, response);
			} else if (op.equals("excluir")) {
				out.println("vai excluir");
			} else {
				out.println("vai listar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		if (!request.getParameterMap().containsKey("oferta") || request.getParameter("oferta").isEmpty()) {
//			try {
//				Prestador p = new PrestadorBO().get(5);
//				List<Oferta> lstOfertas = new OfertaBO().getByPrestador(p.getCodigo());
//				request.setAttribute("lista", true);
//				request.setAttribute("prestador", p);
//				request.setAttribute("ofertas", lstOfertas);
//			} catch (RegistroNaoEncontradoException e) {
//				out.println("Nenhum registro foi encontrado.\n" + e.getMessage());
//			} catch (Exception e) {
//				out.println("Ocorreu um erro ao processar a requisição.\n" + e.getMessage());
//				e.printStackTrace(out);
//			}
//			request.getRequestDispatcher("/oferta_list.jsp").forward(request, response);
//		} else {
//			try {
//				OfertaBO ofertaBO = new OfertaBO();
//				Oferta oferta = ofertaBO.get(Integer.parseInt(request.getParameter("oferta")));
//
//				out.println("<h1>Oferta: " + oferta.getTitulo() + "</h1>");
//				out.println("<p>Tipo: " + oferta.getServico().getNome() + "</p>");
//				out.println("<p>Categoria: " + oferta.getServico().getCategoriaServico().getNome() + "</p>");
//				out.println("<p>Prestador: " + oferta.getPrestador().getNome() + "</p>");
//				out.println("<p>Valor: " + oferta.getValor() + "</p>");
//				out.println("");
//			} catch (RegistroNaoEncontradoException e) {
//				out.println("Nenhum registro foi encontrado.\n" + e.getMessage());
//			} catch (Exception e) {
//				out.println("Ocorreu um erro ao processar a requisição.\n" + e.getMessage());
//				e.printStackTrace(out);
//			}
//		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
	}
}
