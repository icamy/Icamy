package br.com.icamy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.beans.Prestador;
import br.com.icamy.beans.Servico;
import br.com.icamy.bo.CategoriaServicoBO;
import br.com.icamy.bo.PrestadorBO;
import br.com.icamy.bo.ServicoBO;
import br.com.icamy.dao.PrestadorDAO;

@WebServlet("/BemVindo")
public class IndexServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String filtro = request.getParameter("filtro");
		String nmBairro = request.getParameter("bairro");
		int cdCategoria = 0;
		int cdServico = 0;
		try {
			cdCategoria = Integer.parseInt(request.getParameter("categoria"));
		} catch (NumberFormatException e) {
			cdCategoria = 0;
		}
		try {
			cdServico = Integer.parseInt(request.getParameter("servico"));
		} catch (NumberFormatException e) {
			cdServico = 0;
		}
		
		if (filtro != null && !filtro.equals("")) {
			if (filtro.equals("Categorias") && cdCategoria > 0) {
				try {
					CategoriaServico categoria = new CategoriaServicoBO().get(cdCategoria);
					request.setAttribute("categoria", categoria);
					List<Servico> lstServicos = categoria.getServico();
					request.setAttribute("servicos", lstServicos);
					List<Prestador> lstPrestadores = new PrestadorBO().getByCategoria(cdCategoria);
					request.setAttribute("prestadores", lstPrestadores);
				} catch (Exception e) {
					e.getMessage();
				}
				//redirecionar para a index-results
				request.getRequestDispatcher("/index-results.jsp").forward(request, response);
			} else if (filtro.equals("ServicosBairros") && cdCategoria > 0) {
				List<Prestador> lstPrestadores = null;
				try {
					CategoriaServico categoria = new CategoriaServicoBO().get(cdCategoria);
					request.setAttribute("categoria", categoria);
					List<Servico> lstServicos = categoria.getServico();
					request.setAttribute("servicos", lstServicos);
					if (cdServico>0) {
						if (nmBairro != null && !nmBairro.equals("")) {
							lstPrestadores = new PrestadorBO().getByServicoBairro(cdServico, nmBairro);
						} else {
							lstPrestadores = new PrestadorBO().getByServico(cdServico);
						}
					} else {
						if (nmBairro != "") {
							lstPrestadores = new PrestadorBO().getByBairro(nmBairro);
						}
					}
					request.setAttribute("prestadores", lstPrestadores);
				} catch (Exception e) {
					e.getMessage();
				}
				//redirecionar para a index-results
				request.getRequestDispatcher("/index-results.jsp").forward(request, response);
			} else {
				//redirecionar para a index
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else {
			//redirecionar para a index
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
