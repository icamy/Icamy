package br.com.icamy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.icamy.beans.Prestador;
import br.com.icamy.bo.PrestadorBO;
import br.com.icamy.dao.BairroDAO;

@WebServlet("/Teste")
public class DelTesteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
    		List<Prestador> lstPrestadores = new PrestadorBO().getAll();
			request.setAttribute("prestadores", lstPrestadores);
    		request.getRequestDispatcher("/teste.jsp").forward(request, response);
    	} catch (Exception e) {
    		e.getMessage();
    		out.println("Caiu no catch");
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
