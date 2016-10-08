package br.com.icamy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.icamy.beans.Servico;
import br.com.icamy.bo.ServicoBO;

@WebServlet("/Servico")
public class ServicoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Servicos:");

		try {
			ServicoBO servicoBO = new ServicoBO();

			if (!request.getParameter("codigo").isEmpty() && request.getParameter("codigo") != null) {
				Servico servico = servicoBO.get(Integer.parseInt(request.getParameter("codigo")));
				request.setAttribute("servico", servico);
				//request.getRequestDispatcher("/servico.jsp").forward(request, response);
				
				out.println("Nome: " + servico.getNome());
				out.println("Categoria: " + servico.getCategoriaServico().getNome());
				out.println("Descrição: " + servico.getStatus());
				out.println("Status: " + servico.getStatus());
			} else {
				List<Servico> servicos = servicoBO.getAll();
				
				for(Servico servico : servicos) {
					out.println("Nome: " + servico.getNome());
					out.println("Categoria: " + servico.getCategoriaServico().getNome());
					out.println("Descrição: " + servico.getStatus());
					out.println("Status: " + servico.getStatus());
					out.println("");
				}
			}
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
