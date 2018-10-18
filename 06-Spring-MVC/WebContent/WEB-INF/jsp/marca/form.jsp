<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Cadastro de marca">
	<h1>Cadastro de marca</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-sucess">${msg }</div>
	</c:if>
	
	<c:url value="/marca/cadastrar" var="acao"/>
	<form:form action="${acao}" method="post" commandName="marca">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
			<!-- erro ao colocar nome nulo -->
			<form:errors path="nome"  cssClass="text-danger"/>
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form:form>
	
</tags:template>