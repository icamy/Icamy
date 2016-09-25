<%@ page import="br.com.icamy.dao.*" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8"/>
<link rel="stylesheet" type="text/css" href="styles/estilo.css">
<head>
	<title>Icamy</title>
</head>
<body>

	<div id="container">


		<div class="hero">
			<nav class="header">
				<!--Logo-->
				<div class="logo"><img src="img/logo.png" width="200" height="100"></div>
				<!--Fim_Logo-->
				<!--Cabeçalho-->
				<ul>
					<li>Sobre</li>
					<li>Contato</li>
					<li>Busca</li>
					<li>Login</li>
				</ul>
				<!--Fim_Cabeçalho-->
			</nav>

			<div class="container-conteudo-hero">
				<div class="conteudo-hero">
					<h1 class="titulo-hero">Mariana fez limpeza de pele</h1>
					<p>
						Adorei a limpeza de pele, meu rosto parece mais claro.
						Achei ótima a ideia de poder contratar um profissional e ele vir até mim.
						Agora eu sei como cuidar da minha beleza sem me preocupar!
					</p>
					<button>Encontre o profissional ideal</button>
				</div>
			</div>
		</div>



		<!-- container busca -->
		<div class="search">

			<!-- container formulario -->
			<div class="search-bar">

				<!-- formulário -->
				<form class="" action="" method="get">
					<!-- caixa de seleção de categorias -->
					<select name="cars">
						<option value="volvo">Volvo</option>
						<option value="saab">Saab</option>
						<option value="fiat">Fiat</option>
						<option value="audi">Audi</option>
					</select>
					<!-- fim caixa de sele��o de categorias -->
					<input type="text" />
					<input type="submit" name="name" value="enviar">
				</form>
				<!-- fim formulário -->
			</div>

			<div class="search-results">
				<div class="results">
					<%-- Resultado modelo --%>
					<div class="result">
						<img src="">
						<h2>Nome do Fornecedor</h2>
						<p>Descriçao do Fornecedor</p>
						<div class="categoria">
							<span>Categoria1</span>
						</div>
						<div class="address">
							<img src="img/ic_position.png">
							<p>Endereço</p>
						</div>
						<div>
							<span>ícone-rating</span>
							<p>8.7/10</p>
						</div>
					</div>
				</div>
				<div class="button-ver-mais">
					<button>Ver mais</button>
				</div>
			</div>
		</div>
		<!-- fim container busca -->
		<!--Inicio Footer-->
		<div class="footer">
			<div class="footer-container">
				<h2>Mapa do Site</h2>
				<ul>
					<li>Busca</li>
					<li>Sobre</li>
					<li>Login Cliente</li>
					<li>Login Profissional</li>
				</ul>
			</div>
			<div class="footer-container">
				<h2>Institucional</h2>
				<li>Como funciona</li>
				<li>Contato</li>
				<li>Trabalhe conosco</li>
				<li>Termos de uso</li>
			</div>
			<div class="footer-logo"></div>
			<div class="footer-social-media">
				<ul>
					<li><img src="img/glyphicons-social-31-facebook.png"></li>
					<li><img src="img/glyphicons-social-32-twitter.png"></li>
					<li><img src="img/glyphicons-social-33-instagram.png"></li>
					<li><img src="img/glyphicons-social-23-youtube.png"></li>
				</ul>
			</div>
		</div>
		<!-- Fim Footer -->
	</div>
	<!-- Fim -->

</body>
</html>
