package br.com.icamy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.bo.CategoriaServicoBO;

@WebServlet("/BemVindo")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaServicoBO categoriaBO = null;
		
		if (request.getParameter("action") == null) {
			try {
				categoriaBO = new CategoriaServicoBO();
				List<CategoriaServico> categorias = categoriaBO.getAll();
				
				request.setAttribute("categorias", categorias);
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch(Exception e) {}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
