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
import br.com.icamy.bo.OfertaBO;
import br.com.icamy.bo.PrestadorBO;

@WebServlet("/Perfil")
public class PerfilServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Prestador prestador = null;
		List<Oferta> lstOfertas = null;
		int cdPrestador = 0;
		try {
			cdPrestador = Integer.parseInt(request.getParameter("prestador"));
		} catch (NumberFormatException e) {
			cdPrestador = 0;
		}
		if (cdPrestador > 0) {
			try {
				prestador = new PrestadorBO().get(cdPrestador);
				request.setAttribute("prestador", prestador);
				lstOfertas = new OfertaBO().getByPrestador(cdPrestador);
				request.setAttribute("ofertas", lstOfertas);
			} catch (Exception e) {
				e.getMessage();
			}
			request.getRequestDispatcher("/perfil.jsp").forward(request, response);
		} else {
			response.sendRedirect("BemVindo");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
