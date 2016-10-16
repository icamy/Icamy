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
		<!-- Topo da página -->
		<c:import url="/static/templates/topo.jsp" />
	
		<!-- Rodapé da página -->
		<c:import url="/static/templates/rodape.jsp" />

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
