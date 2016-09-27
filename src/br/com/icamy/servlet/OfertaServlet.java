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
import br.com.icamy.bo.OfertaBO;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;

@WebServlet("/Oferta")
public class OfertaServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		if (!request.getParameterMap().containsKey("codigo") || request.getParameter("codigo").isEmpty()) {
			try {
				OfertaBO ofertaBO = new OfertaBO();
				List<Oferta> ofertas = ofertaBO.getAll();

				for (Oferta oferta : ofertas) {
					out.println("<h1>Oferta: " + oferta.getTitulo() + "</h1>");
					out.println("<p>Tipo: " + oferta.getServico().getNome() + "</p>");
					out.println("<p>Categoria: " + oferta.getServico().getCategoria().getNome() + "</p>");
					out.println("<p>Prestador: " + oferta.getPrestador().getNome() + "</p>");
					out.println("<p>Valor: " + oferta.getValor() + "</p>");
					out.println("<p>Prazo: " + oferta.getPrazo() + "</p>");
					out.println("<p>Descrição: " + oferta.getTexto() + "</p>");
					out.println("");
				}
			} catch (RegistroNaoEncontradoException e) {
				out.println("Nenhum registro foi encontrado.\n" + e.getMessage());
			} catch (Exception e) {
				out.println("Ocorreu um erro ao processar a requisição.\n" + e.getMessage());
				e.printStackTrace(out);
			}
		} else {
			try {
				OfertaBO ofertaBO = new OfertaBO();
				Oferta oferta = ofertaBO.get(Integer.parseInt(request.getParameter("codigo")));

				out.println("<h1>Oferta: " + oferta.getTitulo() + "</h1>");
				out.println("<p>Tipo: " + oferta.getServico().getNome() + "</p>");
				out.println("<p>Categoria: " + oferta.getServico().getCategoria().getNome() + "</p>");
				out.println("<p>Prestador: " + oferta.getPrestador().getNome() + "</p>");
				out.println("<p>Valor: " + oferta.getValor() + "</p>");
				out.println("<p>Prazo: " + oferta.getPrazo() + "</p>");
				out.println("<p>Descrição: " + oferta.getTexto() + "</p>");
				out.println("");
			} catch (RegistroNaoEncontradoException e) {
				out.println("Nenhum registro foi encontrado.\n" + e.getMessage());
			} catch (Exception e) {
				out.println("Ocorreu um erro ao processar a requisição.\n" + e.getMessage());
				e.printStackTrace(out);
			}
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
	}
}
