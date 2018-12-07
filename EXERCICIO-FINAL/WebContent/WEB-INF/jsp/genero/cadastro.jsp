<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Cap 02, 04, 05-->

<tags:template titulo="Cadastro de Gênero">

	<h1>Cadastro de Gênero</h1>

	<c:if test="${not empty msg }">
		<div class="alert alert-sucess">${msg}</div>
	</c:if>

	<c:url value="/genero/cadastrar" var="acao" />
	<form:form action="${acao}" method="post" commandName="genero">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control" />
			<form:errors path="nome" cssStyle="color:red;" />
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary" />
	</form:form>
</tags:template>