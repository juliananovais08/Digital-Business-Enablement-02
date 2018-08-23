<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Contato</h1>
	<form action="enviar" method="post">
		<div>
			<label for="nome">Nome</label>
			<input type="text" name="nome" id="nome">
		</div>
		<div>
			<label for="msg">Mensagem</label>
			<textarea rows="5" cols="50" name="mensagem" id="msg"></textarea>			
		</div>
		<input type="submit" value="Enviar">
	</form>
	
</body>
</html>