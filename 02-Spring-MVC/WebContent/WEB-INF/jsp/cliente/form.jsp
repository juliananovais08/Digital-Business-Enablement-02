<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<body>

	<form method="post" action="cadastrar">
		<div>
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="id-nome">
		</div>
		<div>
			<label for="id-idade">Idade</label>
			<input type="text" name="idade" id="id-idade">
		</div>
		<div>
			<input type="checkbox" name="cnh" id="id-cnh">
			<label for="id-cnh">CNH</label>
		</div>
		<div>
			<label for="id-genero">Gênero</label>
			<select id="id-genero" name="genero">
				<option>Feminino</option>
				<option>Masculino</option>
				<option>Outros</option>
			</select>			
		</div>
		<input type="submit" value="Enviar">
	</form>

</body>
</html>