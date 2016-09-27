<!DOCTYPE html>
<html lang="pt">
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/home.css">
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
						<img src="styles/img/logo-white.svg" alt="logo"/>
					</div>
					<!-- fim_Logo -->
					<!-- menu -->
					<ul>
						<li><a href="#">Sobre</a></li>
						<li><a href="#">Contato</a></li>
						<li><a href="#">Busca</a></li>
						<li><a href="#">Login</a></li>
					</ul>
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
					<form class="" action="" method="get">
						<!-- caixa de seleção de categorias -->
						<select class="search-select" name="cars">
							<option value="volvo" selected="selected">Categoria</option>
							<option value="saab">1</option>
							<option value="fiat">2</option>
							<option value="audi">3</option>
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
						<div class="result">
							<div class="result-img">
								<img src="styles/img/kravitz.jpg" width="200">
							</div>
							<div class="result-body">
								<h2>Nome do Fornecedor</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
								<div class="categorias">
									<span class="categoria">Categoria1</span>
									<span class="categoria">Categoria2</span>
									<span class="categoria">Categoria3</span>
								</div>
								<span class="detalhes">
									<img src="styles/img/ic_position.png" width="13px">
									<span>Endereço</span>
								</span>
								<span class="detalhes">
									<span>í­cone-rating</span>
									<span>8.7/10</span>
								</span>
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
				<div class="footer-container2">
					<h2>Institucional</h2>
					<ul>
						<li>Como funciona</li>
						<li>Contato</li>
						<li>Trabalhe conosco</li>
						<li>Termos de uso</li>
					</ul>
				</div>
				<div class="footer-container3">
					<span class="footer-logo"><img src="styles/img/logo-white.svg" width="200"></span>
					<div class="footer-social-media">
						<span><img src="styles/img/facebook.svg"></span>
						<span><img src="styles/img/twitter.svg"></span>
						<span><img src="styles/img/instagram.svg"></span>
						<span><img src="styles/img/youtube.svg"></span>
					</div>
				</div>
			</div>
		</section>
		<!-- Fim Footer -->
	</div>
	<!-- Fim -->

</body>
</html>
