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
	<h1>Oferta(s) do prestador <c:out value="${prestador.nome}"></c:out></h1>
	
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
					
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>