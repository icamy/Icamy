<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*, br.com.icamy.beans.*" %>
<%
Usuario usuario = null;

if (session.getAttribute("perfil").equals("prestador"))
	usuario = (Prestador) session.getAttribute("usuario");
else if (session.getAttribute("perfil").equals("cliente"))
	usuario = (Cliente) session.getAttribute("usuario");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuário logado: <%=usuario.getNome()%></title>
</head>
<body>
	<p><b>Usuário logado</b>: <%=usuario.getNome() %></p>
</body>
</html>