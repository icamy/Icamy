<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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