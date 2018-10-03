<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:template titulo="Cadastro de Convidado">
	<h1>Cadastro de Convidado</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">
			${msg }
		</div>
	</c:if>
	
	<c:url value="/convidado/cadastrar" var="a"/>
	<form method="post" action="${a}">
		<div class="form-group">
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" class="form-control" id="id-nome">
		</div>	
		<div class="form-group">
			<label for="id-email">E-mail</label>
			<input type="text" name="email" class="form-control" id="id-email">
		</div>
		<div class="form-group">
			<label for="id-data">Data</label>
			<input type="text" name="dataAniversario" class="form-control" id="id-data">
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form>
	
</tags:template>