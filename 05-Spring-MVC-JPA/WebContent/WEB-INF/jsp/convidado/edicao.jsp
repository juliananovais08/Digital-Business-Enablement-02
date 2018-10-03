<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:template titulo="Edição de Convidado">
	<h1>Editar Convidado</h1>
	
	<c:url value="/convidado/editar" var="acao"/>
	<form:form action="${acao }" method="post" commandName="convidado">
		<form:hidden path="codigo"/>
		<form:hidden path="confirmado"/>
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="email">E-mail</form:label>
			<form:input path="email" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="dataAniversario">Data Aniversário</form:label>
			<form:input path="dataAniversario" cssClass="form-control"/>
		</div>
		<input type="submit" value="Editar" class="btn btn-primary">
	</form:form>
	
</tags:template>