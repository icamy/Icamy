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
 * Servlet mapeada para tratar as requisições direcionadas à url <endereço-do-projeto>/BemVindo
 */
@WebServlet("/BemVindo")
public class IndexServlet extends HttpServlet {
	
	
	/*
	 * Ao acessar a home do site, o visitante é redirecionado para o arquivo index.jsp, sem aplicação de qualquer lógica.
	 * Ao aplicar qualquer filtro para a busca de profissionais, a requisição do usuário é tratada pela servlet IndexServlet,
	 * que verifica os parâmetros setados no request que contém o filtro, aciona as classes BO adequadas, trata os dados, 
	 * seta os atributos no response e os encaminha ao arquivo index-results.jsp
	 * 
	 * Caso o usuário tente acessar a pasta de exibição dos resultados filtrados sem que a requisição contenha parâmetros
	 * de filtro setados no request, ele também será redirecionado para a url mapeada para esta servlet
	 */

	
	
	
	// Lógica aplicada às requisições do tipo GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filtro = request.getParameter("filtro"); // verifica o tipo de filtro chamado na requisição (string)
		String nmBairro = request.getParameter("bairro"); // acessa o parâmetro "bairro" da requisição (string)
		int cdCategoria = 0; // inicializa o código da categoria de serviço com o valor zero
		int cdServico = 0; // inicializa o código do serviço com o valor zero
		try { // testa se a requisição contém algum parâmetro identificando o código numérico da categoria
			cdCategoria = Integer.parseInt(request.getParameter("categoria"));
		} catch (NumberFormatException e) {
			cdCategoria = 0;
		}
		try { // testa se a requisição contém algum parâmetro identificando o código numérico do serviço
			cdServico = Integer.parseInt(request.getParameter("servico"));
		} catch (NumberFormatException e) {
			cdServico = 0;
		}
		
		if (filtro != null && !filtro.equals("")) { // verifica se o filtro foi informado na requisição
			/*
			 * se houver filtro setado como "categoria", recupera a lista de serviços daquela categoria e 
			 * de prestadores que atuam naquela categoria, setando o resultado como atributos do response
			 */
			if (filtro.equals("Categorias") && cdCategoria > 0) {
				try { 
					CategoriaServico categoria = new CategoriaServicoBO().get(cdCategoria); // categoria
					request.setAttribute("categoria", categoria);
					List<Servico> lstServicos = categoria.getServico(); // lista de serviços
					request.setAttribute("servicos", lstServicos);
					List<Prestador> lstPrestadores = new PrestadorBO().getByCategoria(cdCategoria); // lista de prestadores
					request.setAttribute("prestadores", lstPrestadores);
				} catch (Exception e) {
					e.getMessage();
				}
				// redirecionar os atributos setados pare serem exibidos pelo arquivo index-results:
				request.getRequestDispatcher("/index-results.jsp").forward(request, response);
			/*
			 * Se houver somente filtro de serviço (caso 1), recupera a lista de prestadores que prestam o serviço setado
			 * Se houver somente filtro de bairro (caso 2), recupera a lista de prestadores que atendem no bairro setado
			 * Se ambos os filtros estiverem setados (caso 3), recupera a lista de prestadores que prestam 
			 * o serviço escolhido no bairro indicado
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
		} else { // caso não haja nenhum filtro setado...
			// ...redireciona para o arquivo index.jsp
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	// não houve implementação para as requisições do tipo POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
