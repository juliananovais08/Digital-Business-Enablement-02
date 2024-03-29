<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template titulo="Edição de Jogo">

	<h1>Edição de Jogo</h1>

	<c:if test="${not empty msg }">
		<div class="alert alert-sucess">${msg}</div>
	</c:if>

	<c:url value="/jogo/editar" var="acao" />
	<form:form action="${acao}" method="post" commandName="jogo">
	<form:hidden path="codigo"/>
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control" />
			<form:errors path="nome" cssStyle="color:red;" />
		</div>
		<div class="form-group">
			<form:label path="dataLancamento">Data de Lançamento</form:label>
			<form:input path="dataLancamento" cssClass="form-control" />
			<form:errors path="dataLancamento" cssStyle="color:red;" />
		</div>
		<div class="form-group">
			<form:label path="disponivel">Disponível</form:label>
			<form:checkbox path="disponivel" cssClass="form-inline" />
		</div>
		<div>
			<form:label path="genero">Gênero</form:label>
			<form:select path="genero.codigo" cssClass="form-control">
				<option>Selecione</option>
				<form:options items="${generos}" itemLabel="nome" itemValue="codigo"/>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="plataforma">Plataforma</form:label>
			<form:select path="plataforma" cssClass="form-control">
				<option>Selecione</option>
				<form:options items="${plataformas}" itemLabel="label"/>
			</form:select>
		</div>
		<input type="submit" value="Editar" class="btn btn-primary" />
		<a href="<c:url value="/jogo/listar" />" class="btn btn-primary">Cancelar</a>
	</form:form>
</tags:template>