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
	<link rel="stylesheet" type="text/css" href="styles/grid.css" />
	<link href="https://fonts.googleapis.com/css?family=Work+Sans:200,400,700" rel="stylesheet">
	<title>Icamy</title>
</head>
<body>
	<h1>Compra confirmada com sucesso no PagSeguro!</h1>
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
	
	<a href="BemVindo"><button>Voltar para a home Icamy</button></a>
</body>
</html>