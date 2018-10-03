<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template titulo="Cadastro de Carro">

	<h1>Cadastro de Carro</h1>

	<c:if test="${not empty msg}">
		<div class="alert alert-sucess">${msg}</div>
	</c:if>

	<c:url value="/carro/cadastrar" var="a">
		<form method="post" action="${a}">
			<div class="form-group">
				<label for="id-nome">Nome</label> 
				<input type="text" name="nome" class="form=control" id="id-nome">
			</div>
			<input type="submit" value="cadastrar" class="btn btn-primary">
		</form>
	</c:url>
</tags:template>