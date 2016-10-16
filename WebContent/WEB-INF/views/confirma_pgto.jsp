<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="static/css/home.css">
	<link rel="stylesheet" type="text/css" href="static/css/perfil.css">
	<link rel="stylesheet" type="text/css" href="static/css/confirmacao.css">
	<link rel="stylesheet" type="text/css" href="styles/grid.css" />
	<link href="https://fonts.googleapis.com/css?family=Work+Sans:200,400,700" rel="stylesheet">
	<title>Icamy</title>
</head>
<body>
	<div id="container">
		<nav class="header">
			<div class="nav-container">
				<div class="logo-nav">
					<a href="<c:url value="/"/>"><img src="static/img/logo-white.svg" alt="logo"/></a>
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
		<section class="section-container">
			<div class="feedback-compra">
				<h1 class="text-success">Compra confirmada com sucesso no PagSeguro!</h1>
				<hr/>
				<h3>Dados da sua compra:</h3>
				<p>Data: <c:out value="${dadosPgto.data}" /></p>
				<p>Código: <c:out value="${dadosPgto.cdPgto}" /></p>
				<p>Referência: <c:out value="${dadosPgto.referencia}" /></p>
				<p>Valor: <c:out value="${dadosPgto.valor}" /></p>
				<p>Cód. Oferta: <c:out value="${dadosPgto.cdOferta}" /></p>
				<p>Prestador: <c:out value="${dadosPgto.prestador}" /></p>
				<p>Serviço: <c:out value="${dadosPgto.servico}" /></p>
				<p>Cliente: <c:out value="${dadosPgto.clienteNome}" /></p>
				<p>E-mail: <c:out value="${dadosPgto.clienteEmail}" /></p>
				
				<a href="<c:url value="/"/>"><button>Voltar para a home Icamy</button></a>
			</div>
		</section>
	</div>
</body>
</html>