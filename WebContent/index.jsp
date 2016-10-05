<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
<c:if test="${categorias == null}" >
	<c:redirect url="/BemVindo"/>
</c:if>

<!DOCTYPE html>
<html lang="pt">
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="static/css/home.css">
<link href="https://fonts.googleapis.com/css?family=Work+Sans:200,400,700" rel="stylesheet">
<head>
	<title>Icamy</title>
</head>
<body>


	<div id="container">
		<section class="hero">
			<div class="section-container">
				<nav class="header">
					<!-- logo -->
					<div class="logo-nav">
						<a href="/Icamy/"><img src="static/img/logo-white.svg" alt="logo"/></a>
					</div>
					<!-- fim_Logo -->
					<!-- menu -->
					<input style="display: none" type="checkbox" id="menu" />
					<div class="mobile-nav">
						<a href="#">Sobre</a>
						<a href="#">Contato</a>
						<a href="#">Busca</a>
						<a href="#">Login</a>
					</div>
					<ul>
						<li><a href="#">Sobre</a></li>
						<li><a href="#">Contato</a></li>
						<li><a href="#">Busca</a></li>
						<li><a href="#">Login</a></li>
					</ul>
					<label class="menu-btn" for="menu"><div class="toggle"><span class="btn-component"></span></div></label>
					<!-- fim menu -->
				</nav>
	
				<div class="container-conteudo-hero">
					<div class="conteudo-hero">
						<h1 class="titulo-hero">Mariana fez limpeza de pele</h1>
						<p>
							Adorei a limpeza de pele, meu rosto parece mais claro.
							Achei ótima a ideia de poder contratar um profissional e ele vir até mim.
							Agora eu sei como cuidar da minha beleza sem me preocupar!
						</p>
						<span>Encontre o profissional ideal</span>
					</div>
				</div>
			</div>
		</section>
		
		<!-- container busca -->
		<section class="search">
			<div class="section-container">
				<!-- container formulario -->
				<div class="search-bar">
					<!-- formulário -->
					<form action="" method="get">
						<!-- caixa de seleção de categorias -->
						<select class="search-select" name="cars">
							<option value="categoria" selected="selected">Categoria</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select>
						<!-- fim caixa de seleção de categorias -->
						<input class="search-input" type="text" placeholder="Onde deseja ser atendido(a)?" />
						<input class="search-submit" type="submit" name="submit" value="" />
					</form>
					<!-- fim formulario -->
				</div>
	
				<div class="search-results">
					<div class="results">
						<%-- Resultado modelo --%>
						
						<%-- Resultado original --%>
							<div style="display: block; padding: 30px">
								<table>
									<tr>
										<td>Codigo</td>
										<td>Nome</td>
									</tr>
									<c:forEach items="${categorias }" var="cat">
										<tr>
											<td><c:out value="${cat.codigo}"/></td>
											<td><c:out value="${cat.nome}"/></td>		
										</tr>
									</c:forEach>
								</table>
							</div>
						<div style = "display: none;" class="result-original">
						
						<div class="result">
							<div class="result-img">
								<img src="static/img/kravitz.jpg" width="200">
							</div>
							<div class="result-body">
								<h2>Nome do Fornecedor</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
								<div class="categorias">
									<span class="categoria">Categoria1</span>
									<span class="categoria">Categoria2</span>
									<span class="categoria">Categoria3</span>
								</div>
								<div class="detalhes">
									<img src="static/img/location.svg" width="15px">
									<span>Endereço</span>
								</div>
								<div class="detalhes">
									<img src="static/img/rating.svg" width="15px">
									<span>8.7/10</span>
								</div>
							</div>
						</div>
						</div>
					</div>
					<hr />
					<div class="btn-ver-mais">
						<span>Ver mais</span>
					</div>
				</div>
			</div>
		</section>
		<!-- fim container busca -->
		<!--Inicio Footer-->
		<section class="footer">
			<div class="section-container">
				<div class="footer-container1">
					<h2>Mapa do Site</h2>
					<ul>
						<li>Busca</li>
						<li>Sobre</li>
						<li>Login Cliente</li>
						<li>Login Profissional</li>
					</ul>
				</div>
				<hr/>
				<div class="footer-container1">
					<h2>Institucional</h2>
					<ul>
						<li>Como funciona</li>
						<li>Contato</li>
						<li>Trabalhe conosco</li>
						<li>Termos de uso</li>
					</ul>
				</div>
				<hr/>
				<div class="footer-container2">
					<div class="footer-logo"><img src="static/img/logo-white.svg" width="200"></div>
					<div class="footer-social-media">
						<span><img src="static/img/facebook.svg"></span>
						<span><img src="static/img/twitter.svg"></span>
						<span><img src="static/img/instagram.svg"></span>
						<span><img src="static/img/youtube.svg"></span>
					</div>
				</div>
			</div>
		</section>
		<!-- Fim Footer -->
	</div>
	<!-- Fim -->
	<script src="static/js/scripts.js"></script>
</body>
</html>
