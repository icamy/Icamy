<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt">

<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="static/css/home.css">
	<link rel="stylesheet" type="text/css" href="styles/grid.css" />
	<link href="https://fonts.googleapis.com/css?family=Work+Sans:200,400,700" rel="stylesheet">
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
						<span onclick="openModal()">Encontre o profissional ideal</span>
					</div>
				</div>
			</div>
		</section>
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

		<!--Inicio Modal-->
			<div class="modal-container-home">
				<div class="modal-content-home">
						<div class="modal-close-btn-home" onclick="closeModal()"><span></span></div>
						<div class="modal-content-inner-home">
							<a href="BemVindo?filtro=Categorias&categoria=1"><div class="modal-btn-cta-home"><span><img src="static/img/unha.svg" alt=""></span><h2>Unhas</h2></div></a>
							<a href="BemVindo?filtro=Categorias&categoria=2"><div class="modal-btn-cta-home"><span><img src="static/img/cabelo.svg" alt=""></span><h2>Cabelos</h2></div></a>
							<a href="BemVindo?filtro=Categorias&categoria=3"><div class="modal-btn-cta-home"><span><img src="static/img/sombrancelha.svg" alt=""></span><h2>Sobrancelhas</h2></div></a>
							<a href="BemVindo?filtro=Categorias&categoria=4"><div class="modal-btn-cta-home"><span><img src="static/img/massagem.svg" alt=""></span><h2>Massagem</h2></div></a>
							<a href="BemVindo?filtro=Categorias&categoria=5"><div class="modal-btn-cta-home"><span><img src="static/img/depilacao.png" alt=""></span><h2>Depilação</h2></div></a>
							<a href="BemVindo?filtro=Categorias&categoria=6"><div class="modal-btn-cta-home"><span><img src="static/img/maquiagem.png" alt=""></span><h2>Maquiagem</h2></div></a>
						</div>
				</div>
			</div>
		<!-- Fim Modal -->


	</div>
	<!-- Fim -->
	<script src="static/js/scripts.js"></script>
</body>
</html>
