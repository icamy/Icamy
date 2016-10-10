<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="static/css/perfil.css">
	<link href="https://fonts.googleapis.com/css?family=Work+Sans:200,400,700" rel="stylesheet">
	<title>Icamy</title>
</head>
<body>
	<!--Inicio-->
	
	
	<div class="container">
		<nav class="header">
			<div class="nav-container">
				<div class="logo-nav">
					<a href="/Icamy/"><img src="static/img/logo-white.svg" alt="logo"/></a>
				</div>
				<input style="display: none" type="checkbox" id="menu" />
<!-- 				<span class="cart-icon"><img src="static/img/cart.svg"/><span class="cart-counter">0</span></span> -->
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
			</div>
		</nav>


		<!-- início perfil -->
		<!-- container busca -->
		<section class="search">
			<div class="section-container">	
				<div class="search-results">
					<div class="results">
						<div class="result">
							<div class="result-img">
								<img src="static/img/profile/<c:out value="${prestador.urlFoto}" />" width="200">
							</div>
							<div class="result-body">
								<h1><c:out value="${prestador.nome}" /></h1>
								<p><c:out value="${prestador.apresentacao}" /></p>
								<div class="categorias">
									<c:forEach items="${prestador.categoria}" var="categoriaPrestador">
										<span class="categoria"><c:out value="${categoriaPrestador.nome}" /></span>
									</c:forEach>
								</div>
								<div class="detalhes">
									<img src="static/img/location.svg" width="15px">
									<c:forEach items="${prestador.bairro}" var="bairroPrestador">
										<span>&nbsp;<c:out value="${bairroPrestador.nome}" />&nbsp;|</span>
									</c:forEach>
								</div>
								<div class="detalhes">
									<img src="static/img/rating.svg" width="15px">
									<span>8.7/10</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- fim container busca -->


			<!--Inicio Portifólio-->			
			<div class="section-container">
				<div class="portifolio">
					<h2>Portfólio</h2>
					<hr>
					<div class="portifolio-itens">
						<div class="portifolio-item folio-1"></div>						
						<div class="portifolio-item folio-2"></div>						
						<div class="portifolio-item folio-3"></div>						
					</div>
				</div>
			</div>			
			<!--fim portifólio-->

			<!-- in�cio serviço -->
			
			<div class="section-container">			
				<div class="servicos">
					<div class="servicos-header">
						<h2 class="servicos-header-title">Serviços</h2>
						<h2 class="servicos-header-filter">Filtrar:</h2>
						<select class="servicos-header-filter">
							<c:forEach items="${servicos}" var="servico">
								<option value="<c:out value="${servico.codigo}" />">
									<c:out value="${servico.nome}" />
								</option>
							</c:forEach>
						</select>
					</div>
					<hr/>
					<div class="servicos-body">
						<c:forEach items="${ofertas}" var="oferta">
							<div class="servico">
								<span class="servico-icone"><img src="static/img/<c:out value="${oferta.icone}" />.png" /></span>
								<div class="servico-body">
									<h2><c:out value="${oferta.titulo}" /></h2>
									<span><img src="static/img/calendar.svg" width="15px" />Até 1 semana</span>
									<span class="servicos-icone-rating"><img src="static/img/rating.svg" width="15px" /> 9.2/10</span>
									<span><img src="static/img/dollar.svg" width="15px" /><strong>
										<fmt:setLocale value="pt_BR"/>
										<fmt:formatNumber value="${oferta.valor}" type="currency"/>
									</strong></span>
								</div>
								<div class="servico-btns">
									<span class="cta modal"><img class="cta-img" src="static/img/cart.svg" /></span>
									<span class="cta"><img class="cta-img" src="static/img/eye.svg" /></span>
								</div>
							</div>
						</c:forEach>
						
					<!--
						<div class="servico">
							<span class="servico-icone"><img src="static/img/cabelo.png" /></span>
							<div class="servico-body">
								<h2>Corte de Cabelo</h2>
								<span><img src="static/img/calendar.svg" width="15px" /> At� 1 semana</span>
								<span class="servicos-icone-rating"><img src="static/img/rating.svg" width="15px" /> 9.2/10</span>
								<span><img src="static/img/dollar.svg" width="15px" /><strong>R$70,00</strong></span>
							</div>
							<div class="servico-btns">
								<span class="cta modal"><img class="cta-img" src="static/img/cart.svg" /></span>
								<span class="cta"><img class="cta-img" src="static/img/eye.svg" /></span>
							</div>
						</div>
						<div class="servico">
							<span class="servico-icone"><img src="static/img/depilacao.gif" /></span>
							<div class="servico-body">
								<h2>Corte de Cabelo</h2>
								<span><img src="static/img/calendar.svg" width="15px" /> At� 1 semana</span>
								<span><img src="static/img/rating.svg" width="15px" /> 9.2/10</span>
								<span><img src="static/img/dollar.svg" width="15px" /><strong>R$70,00</strong></span>
							</div>
							<div class="servico-btns">
								<span class="cta modal"><img class="cta-img" src="static/img/cart.svg" /></span>
								<span class="cta"><img class="cta-img" src="static/img/eye.svg" /></span>
							</div>
						</div>
						<div class="servico">
							<span class="servico-icone"><img src="static/img/maquiagem.gif" /></span>
							<div class="servico-body">
								<h2>Corte de Cabelo</h2>
								<span><img src="static/img/calendar.svg" width="15px" /> At� 1 semana</span>
								<span class="servicos-icone-rating"><img src="static/img/rating.svg" width="15px" /> 9.2/10</span>
								<span><img src="static/img/dollar.svg" width="15px" /><strong>R$70,00</strong></span>
							</div>
							<div class="servico-btns">
								<span class="cta modal"><img class="cta-img" src="static/img/cart.svg" /></span>
								<span class="cta"><img class="cta-img" src="static/img/eye.svg" /></span>
							</div>
						</div>
						<div class="servico">
							<span class="servico-icone"><img src="static/img/massagem.png" /></span>
							<div class="servico-body">
								<h2>Corte de Cabelo</h2>
								<span><img src="static/img/calendar.svg" width="15px" /> At� 1 semana</span>
								<span class="servicos-icone-rating"><img src="static/img/rating.svg" width="15px" /> 9.2/10</span>
								<span><img src="static/img/dollar.svg" width="15px" /><strong>R$70,00</strong></span>
							</div>
							<div class="servico-btns">
								<span class="cta modal"><img class="cta-img" src="static/img/cart.svg" /></span>
								<span class="cta"><img class="cta-img" src="static/img/eye.svg" /></span>
							</div>
						</div>
					-->
					</div>
				</div>
			</div>	
			<!--fim servico-->

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
				<hr />
				<div class="footer-container1">
					<h2>Institucional</h2>
					<ul>
						<li>Como funciona</li>
						<li>Contato</li>
						<li>Trabalhe conosco</li>
						<li>Termos de uso</li>
					</ul>
				</div>
				<hr />
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
		
		<!-- Inicio Modal -->
		
	<div class="modal-container">
		<div class="modal-content">
			<div class="modal-close-btn"><span></span></div>
		</div>
	</div>	
		
		<!-- Fim Modal -->
		
	</div>
	<!-- Fim -->
	<script src="static/js/scripts - perfil.js"></script>
</body>
</html>