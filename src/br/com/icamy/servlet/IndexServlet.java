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
import br.com.icamy.beans.Servico;
import br.com.icamy.bo.CategoriaServicoBO;
import br.com.icamy.bo.PrestadorBO;

/*
 * Servlet mapeada para tratar as requisi��es direcionadas � url <endere�o-do-projeto>/BemVindo
 */
@WebServlet("/BemVindo")
public class IndexServlet extends HttpServlet {
	
	
	/*
	 * Ao acessar a home do site, o visitante � redirecionado para o arquivo index.jsp, sem aplica��o de qualquer l�gica.
	 * Ao aplicar qualquer filtro para a busca de profissionais, a requisi��o do usu�rio � tratada pela servlet IndexServlet,
	 * que verifica os par�metros setados no request que cont�m o filtro, aciona as classes BO adequadas, trata os dados, 
	 * seta os atributos no response e os encaminha ao arquivo index-results.jsp
	 * 
	 * Caso o usu�rio tente acessar a pasta de exibi��o dos resultados filtrados sem que a requisi��o contenha par�metros
	 * de filtro setados no request, ele tamb�m ser� redirecionado para a url mapeada para esta servlet
	 */

	
	
	
	// L�gica aplicada �s requisi��es do tipo GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filtro = request.getParameter("filtro"); // verifica o tipo de filtro chamado na requisi��o (string)
		String nmBairro = request.getParameter("bairro"); // acessa o par�metro "bairro" da requisi��o (string)
		int cdCategoria = 0; // inicializa o c�digo da categoria de servi�o com o valor zero
		int cdServico = 0; // inicializa o c�digo do servi�o com o valor zero
		try { // testa se a requisi��o cont�m algum par�metro identificando o c�digo num�rico da categoria
			cdCategoria = Integer.parseInt(request.getParameter("categoria"));
		} catch (NumberFormatException e) {
			cdCategoria = 0;
		}
		try { // testa se a requisi��o cont�m algum par�metro identificando o c�digo num�rico do servi�o
			cdServico = Integer.parseInt(request.getParameter("servico"));
		} catch (NumberFormatException e) {
			cdServico = 0;
		}
		
		if (filtro != null && !filtro.equals("")) { // verifica se o filtro foi informado na requisi��o
			/*
			 * se houver filtro setado como "categoria", recupera a lista de servi�os daquela categoria e 
			 * de prestadores que atuam naquela categoria, setando o resultado como atributos do response
			 */
			if (filtro.equals("Categorias") && cdCategoria > 0) {
				try { 
					CategoriaServico categoria = new CategoriaServicoBO().get(cdCategoria); // categoria
					request.setAttribute("categoria", categoria);
					List<Servico> lstServicos = categoria.getServico(); // lista de servi�os
					request.setAttribute("servicos", lstServicos);
					List<Prestador> lstPrestadores = new PrestadorBO().getByCategoria(cdCategoria); // lista de prestadores
					request.setAttribute("prestadores", lstPrestadores);
				} catch (Exception e) {
					e.getMessage();
				}
				// redirecionar os atributos setados pare serem exibidos pelo arquivo index-results:
				request.getRequestDispatcher("/index-results.jsp").forward(request, response);
			/*
			 * Se houver somente filtro de servi�o (caso 1), recupera a lista de prestadores que prestam o servi�o setado
			 * Se houver somente filtro de bairro (caso 2), recupera a lista de prestadores que atendem no bairro setado
			 * Se ambos os filtros estiverem setados (caso 3), recupera a lista de prestadores que prestam 
			 * o servi�o escolhido no bairro indicado
			 */
			} else if (filtro.equals("ServicosBairros") && cdCategoria > 0) {
				List<Prestador> lstPrestadores = null;
				try {
					CategoriaServico categoria = new CategoriaServicoBO().get(cdCategoria);
					request.setAttribute("categoria", categoria);
					List<Servico> lstServicos = categoria.getServico();
					request.setAttribute("servicos", lstServicos);
					if (cdServico>0) {
						if (nmBairro != null && !nmBairro.equals("")) { // caso 3
							lstPrestadores = new PrestadorBO().getByServicoBairro(cdServico, nmBairro);
						} else { // caso 1
							lstPrestadores = new PrestadorBO().getByServico(cdServico);
						}
					} else {
						if (nmBairro != "") { // caso 2
							lstPrestadores = new PrestadorBO().getByBairro(nmBairro);
						}
					}
					request.setAttribute("prestadores", lstPrestadores);
				} catch (Exception e) {
					e.getMessage();
				}
				// redirecionar os atributos setados pare serem exibidos pelo arquivo index-results:
				request.getRequestDispatcher("/index-results.jsp").forward(request, response);
			} else {
				//redirecionar para a index
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else { // caso n�o haja nenhum filtro setado...
			// ...redireciona para o arquivo index.jsp
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	// n�o houve implementa��o para as requisi��es do tipo POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
