	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Cadastro de Carro">
	<h1>Cadastro de carro</h1>

	<c:if test="${not empty msg }">
		<div class="alert alert-sucess">${msg }</div>
	</c:if>

	<c:url value="/carro/cadastrar" var="acao" />
	<form:form action="${acao}" method="post" commandName="carro">
		<div class="form-group">
			<form:label path="modelo">Modelo</form:label>
			<form:input path="modelo" cssClass="form-control" />
			<!-- erro -->
			<form:errors path="modelo" cssClass="text-danger"/>
		</div>
		<div class="form-group">
			<form:label path="dataFabricacao">Data de Fabricação</form:label>
			<form:input path="dataFabricacao" cssClass="form-control" />
			<form:errors path="dataFabricacao" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="marca">Marca</form:label>
			<form:select path="marca.codigo" cssClass="form-control">
			<form:option value="0">Selecione</form:option>
				<form:options item="${marcas }" itemLabel="nome" itemValue="codigo"/>   <!-- marcas - olhar controller objeto que representa lista de marcas -->
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="combustivel">Combustível</form:label>
			<form:select path="combustivel" cssClass="form-control">
			<form:options value="${combustiveis }" itemLabel="Label"/>
			</form:select>
		</div>
		<div class="form-group">
		<form:checkbox path="completo"/>
			<form:label path="completo">Completo</form:label>
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form:form>

</tags:template>