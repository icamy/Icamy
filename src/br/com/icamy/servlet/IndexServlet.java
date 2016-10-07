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
import br.com.icamy.bo.PrestadorBO;
import br.com.icamy.bo.ServicoBO;

@WebServlet("/BemVindo")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaServicoBO categoriaBO = null;
		
		if (request.getParameter("action") != null) {
			switch (request.getParameter("action")) {
				// Listar os serviços e os prestadores de serviços da categoria dada
				case "getServicosPrestadores": {
					try {
						request.setAttribute("prestadores", new PrestadorBO().getPrestadoresDeServicosDe
								(Integer.parseInt(request.getParameter("categoria"))));
						
						request.setAttribute("servicos", new ServicoBO().getServicosDoTipo
								(Integer.parseInt(request.getParameter("categoria"))));
					} catch (Exception e) {}
					
					break;
				}
			}
		} else {
			// Listar as categorias
				try {
					categoriaBO = new CategoriaServicoBO();
					List<CategoriaServico> categorias = categoriaBO.getAll();

					request.setAttribute("categorias", categorias);

				} catch(Exception e) {}
		}
		
		// Retornar para a página inicial com os parâmetros setados
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
