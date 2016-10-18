package br.com.icamy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.icamy.beans.Cliente;
import br.com.icamy.beans.Prestador;
import br.com.icamy.bo.ClienteBO;
import br.com.icamy.bo.PrestadorBO;
import br.com.icamy.exceptions.UsuarioInvalidoException;

@WebServlet("/Autenticar")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession() != null) {
			PrintWriter out = response.getWriter();
			Cliente usuarioCliente = null;
			Prestador usuarioPrestador = null;
			
			// Dados do usuário a ser autenticado
			Map<String, String> usuario = new HashMap<String, String>();
			usuario.put("email", request.getParameter("ds_email"));
			usuario.put("senha", request.getParameter("ds_senha"));
			out.println(usuario);
			
			out.println("Autenticando usuário...");
			
			// Tenta autenticar como usuário do tipo Cliente
			try {
				usuarioCliente = new ClienteBO().login(usuario);

				request.getSession().setAttribute("usuario", usuarioCliente);
				request.getSession().setAttribute("perfil", "cliente");

				request.getRequestDispatcher("/logado.jsp").forward(request, response);
			} catch (UsuarioInvalidoException e) {
				try {
					usuarioPrestador = new PrestadorBO().login(usuario);

					request.getSession().setAttribute("usuario", usuarioPrestador);
					request.getSession().setAttribute("perfil", "prestador");

					request.getRequestDispatcher("/logado.jsp").forward(request, response);
				} catch(UsuarioInvalidoException err) {
					out.println(err.getMessage());
					err.printStackTrace(out);
				} catch(Exception err) {
					out.println("Deu zebra como prestador");
				}
  			} catch (Exception e) {
				out.println("Deu zebra como cliente");
 			}
		}
	}

}
