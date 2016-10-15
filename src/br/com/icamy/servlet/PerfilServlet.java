package br.com.icamy.servlet;

import java.io.IOException;
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

/*
 * Servlet mapeada para tratar as requisições direcionadas à url <endereço-do-projeto>/Perfil
 */
@WebServlet("/Perfil")
public class PerfilServlet extends HttpServlet {

	
	/*
	 * Ao acessar a página de perfil do prestador, o usuário deve ser redirecionado para o arquivo perfil.jsp,
	 * que exibe os dados do profissional, os bairros em que atende, seu portfólio e a lista de serviços que ele oferta
	 */
	
	
	// Lógica aplicada às requisições do tipo GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Prestador prestador = null;
		List<Oferta> lstOfertas = null;
		int cdPrestador = 0; // inicializa o código do prestador com o valor zero
		try { // testa se a requisição contém algum parâmetro identificando o código numérico do prestador
			cdPrestador = Integer.parseInt(request.getParameter("prestador"));
		} catch (NumberFormatException e) {
			cdPrestador = 0;
		}
		if (cdPrestador > 0) { // se houver filtro setado para o código do prestador, recupera os dados associados ao código
			try {
				prestador = new PrestadorBO().get(cdPrestador); // prestador
				request.setAttribute("prestador", prestador);
				lstOfertas = new OfertaBO().getByPrestador(cdPrestador); // ofertas
				request.setAttribute("ofertas", lstOfertas);
			} catch (Exception e) {
				e.getMessage();
			}
			// redirecionar os atributos setados para serem exibidos pelo arquivo perfil.jsp:
			request.getRequestDispatcher("WEB-INF/views/perfil.jsp").forward(request, response);
		} else { // se não houver parâmetro que identifique o código numérico do prestador, redireciona para a servlet IndexServlet
			response.sendRedirect("BemVindo");
		}
	}

	// não houve implementação para as requisições do tipo POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
