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
	<title>Icamy | Login</title>
</head>
<body>
	<div id="container">
		<!-- Topo da página -->
		<c:import url="/static/templates/topo.jsp" />
		
		<!-- Conteúdo -->
		<section class="main-content">
			<div class="section-container">
				<article class="form-area">
					<header class="form-header">
						<h2>Login</h2>
					</header>
					<form action="Autenticar" method="POST">
					<label>Email</label>
					<input type="text" class="full-field" name="ds_email" placeholder="seu@email.com" />
					<label>Senha</label>
					<input type="password" class="full-field" name="ds_senha" placeholder="suasenha" />
					<input type="submit" value="Enviar" class="btn" />
					</form>
				</article>
			</div>
		</section>
		
		<!-- Rodapé da página -->
		<c:import url="/static/templates/rodape.jsp" />
	</div>
</body>
</html>