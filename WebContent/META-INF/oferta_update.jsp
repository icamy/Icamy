<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OFERTAS DO PRESTADOR</title>
</head>
<body>
	<h1>Nova oferta(s) do prestador <c:out value="${prestador.nome}"></c:out></h1>	
	<form action="" method="post">
		
		<label for="servico">Serviço</label>
		<select name="servico">
			<c:forEach var="s" items="${servicos}">
				<option value="<c:out value="${s.codigo}" />">
					<c:out value="${s.nome}"/>
				</option>
			</c:forEach>
		</select>
		<br/>
		<label for="titulo">Título:</label>
		<input type="text" name="titulo" value="<c:out value="${oferta.titulo}" />" />
		<br/>
		<label for="descricao">Descrição:</label>
		<input type="text" name="descricao" value="<c:out value="${oferta.descricao}" />" />
		<br/>
		<label for="valor">Valor:</label>
		<input type="text" name="valor" />
		<br/>
		<label for="execucao_em_minutos">Execução (em minutos):</label>
		<input type="text" name="execucao_em_minutos" />
		<br/>
		<label for="validade_em_dias">Validade (em dias):</label>
		<input type="text" name="validade_em_dias" />
	
	</form>
	
	<table style="width:100%">
		<thead>
			<tr>
				<th>Código</th>
				<th>Título</th>
				<th>Descrição</th>
				<th>Valor</th>
				<th>Editar</th>
				<th>Excluir</th>			
			<tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${lista}">
					<c:forEach var="o" items="${ofertas}">
						<tr>
							<td><c:out value="${o.codigo}"></c:out></td>
							<td><c:out value="${o.titulo}"></c:out></td>
							<td><c:out value="${o.descricao}"></c:out></td>
							<td><c:out value="${o.valor}"></c:out></td>
							<td>
								<a href="http://localhost:8080/Icamy/Oferta?op=editar&prestador=<c:out value="${prestador.codigo}"/>&oferta=<c:out value="${o.codigo}"/>">
									Editar
								</a>
							</td>
							<td>
								<a href="http://localhost:8080/Icamy/Oferta?op=excluir&prestador=<c:out value="${prestador.codigo}"/>&oferta=<c:out value="${o.codigo}"/>">
									Excluir
								</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td><c:out value="${oferta.codigo}"></c:out></td>
						<td><c:out value="${oferta.titulo}"></c:out></td>
						<td><c:out value="${oferta.descricao}"></c:out></td>
						<td><c:out value="${oferta.valor}"></c:out></td>
						<td>
							<a href="Oferta?op=editar&prestador=<c:out value="${prestador.codigo}"/>&oferta=<c:out value="${oferta.codigo}"/>">
								Editar
							</a>
						</td>
						<td>
							<a href="Oferta?op=excluir&prestador=<c:out value="${prestador.codigo}"/>&oferta=<c:out value="${oferta.codigo}"/>">
								Excluir
							</a>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		<tr>
			<td colspan="3"></td>
			<td colspan="3">
				<a href="Oferta?op=inserir">Inserir novo registro</a>
			</td>
		</tr>
		</tbody>
	</table>
</body>
</html>