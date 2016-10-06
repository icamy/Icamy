package br.com.icamy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.beans.Prestador;
import br.com.icamy.bo.CategoriaServicoBO;
import br.com.icamy.bo.PrestadorBO;

@WebServlet("/BemVindo")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaServicoBO categoriaBO = null;
		
		switch (request.getParameter("action")) {
		
			// Listar os serviços e os prestadores de serviços da categoria dada
			case "getServicosPrestadores": {
				try {
					List<Prestador> prestadores = new PrestadorBO().getPrestadoresDeServicosDe
							(Integer.parseInt(request.getParameter("categoria")));
					request.setAttribute("prestadores", prestadores);
				} catch (Exception e) {}
				
				break;
			}
			
			// Listar as categorias
			default: { 
				try {
					categoriaBO = new CategoriaServicoBO();
					List<CategoriaServico> categorias = categoriaBO.getAll();

					request.setAttribute("categorias", categorias);
				} catch(Exception e) {}

				break;
			}
		}
		
		// Retornar para a página inicial com os parâmetros setados
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
