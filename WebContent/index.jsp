<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Hello world!</title>
  <link rel="stylesheet" href="styles/basic.css" />
</head>
<body>
	<form method="get" action="http://localhost:8080/Icamy/Servico">
		<fieldset>
			<legend>Pegar servico</legend>
			<label for="codigoServico">Código </label>
			<input id="codigoServico" type="number" name="codigo" placeholder="Digite o código do servico (deixe em branco para listar todos)" /><br />
			<input type="submit" value="Buscar" />
		</fieldset>
	</form>
</body>
</html>