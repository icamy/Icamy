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
	private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CategoriaServicoBO categoriaBO = null;
		
		if (request.getParameter("action") != null) {
			switch (request.getParameter("action")) {
				// Listar os serviços e os prestadores de serviços da categoria dada
				case "getServicosPrestadores": {
					try {
						int cdCategoria = Integer.parseInt(request.getParameter("categoria"));
						CategoriaServico categoria = new CategoriaServicoBO().get(cdCategoria);
						request.setAttribute("catetorias", categoria);
						List<Prestador> lstPrestadores = new PrestadorBO().getPrestadoresDeServicosDe(cdCategoria);
						request.setAttribute("prestadores", lstPrestadores);
						List<Servico> lstServicos = new ServicoBO().getServicosDoTipo(cdCategoria);
						request.setAttribute("servicos", lstServicos);
					} catch (Exception e) {}
					break;
				}
				case "getPrestadoresBairros": {
					try {
						int cdCategoria = Integer.parseInt(request.getParameter("categoria"));
						CategoriaServico categoria = new CategoriaServicoBO().get(cdCategoria);
						request.setAttribute("catetorias", categoria);
						List<Prestador> lstPrestadores = new PrestadorBO().getPrestadoresDeServicosDe(cdCategoria);
						request.setAttribute("prestadores", lstPrestadores);
						List<Servico> lstServicos = new ServicoBO().getServicosDoTipo(cdCategoria);
						request.setAttribute("servicos", lstServicos);
					} catch (Exception e) {}
					break;
				}
			}
		} else {
			// Listar as categorias
//				try {
//					categoriaBO = new CategoriaServicoBO();
//					List<CategoriaServico> categorias = categoriaBO.getAll();
//
//					request.setAttribute("categorias", categorias);
//
//				} catch(Exception e) {}
			try {
	    		List<CategoriaServico> lstCategorias = new CategoriaServicoBO().getAll();
	    		List<Servico> lstServicos = new ServicoBO().getAll();
	    		List<Prestador> lstPrestadores = new PrestadorBO().getAll();
	    		request.setAttribute("categorias", lstCategorias);
	    		request.setAttribute("servicos", lstServicos);
	    		request.setAttribute("prestadores", lstPrestadores);
	    	} catch (Exception e) {
	    		e.getMessage();
	    		out.println("Caiu no catch");
	    	}
		}
		
		// Retornar para a página inicial com os parÃ¢metros setados
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
