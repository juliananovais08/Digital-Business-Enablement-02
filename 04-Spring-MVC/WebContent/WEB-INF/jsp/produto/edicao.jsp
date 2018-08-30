<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<tags:template titulo="Editar produto">

	<h1>Edição de Produto</h1>	

	
	<c:url var="link" value="/produto/editar"></c:url>	
	<form:form action="${link }" method="post" commandName="produto">
		<form:hidden path="codigo"/>
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
		</div> 
		<div class="form-group">
			<form:label path="preco">Preço</form:label>
			<form:input path="preco" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:checkbox path="perecivel"/>
			<form:label path="perecivel">Perecível</form:label>
		</div>
		<div class="form-group">
			<input type="submit" value="Editar" class="btn btn-primary"/>
		</div>
	</form:form>
</tags:template>