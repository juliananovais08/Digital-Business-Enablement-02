<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pessoa</title>
</head>
<body>

	<h1>Cadastro de Pessoa</h1>
	<form action="cadastrar" method="post">
		<div>
			<label for="idNome">Nome</label>
			<input type="text" name="nome" id="idNome">
		</div>
		<div>
			<label for="idIdade">Idade</label>
			<input type="text" name="idade" id="idIdade">
		</div>
		<div>
			<input type="checkbox" name="aposentado" id="idAposentado">
			<label for="idAposentado">Aposentado</label>
		</div>
		<input type="submit" value="Cadastrar">
	</form>

</body>
</html>
