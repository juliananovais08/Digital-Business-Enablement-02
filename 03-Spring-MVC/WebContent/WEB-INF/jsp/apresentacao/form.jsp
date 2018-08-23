<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:template titulo="Cadastro de Apresentações">
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>
	
	<form action="cadastrar" method="post">
		<div class="form-group">
			<label for="id-grupo">Grupo</label>
			<input type="text" name="grupo" id="id-grupo" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-duracao">Duração</label>
			<input type="text" name="duracao" id="id-duracao" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-desc">Descrição</label>
			<textarea rows="5" cols="50" 
				name="descricao" id="id-desc" class="form-control"></textarea>
		</div>
		<div class="form-group">
			<input type="checkbox" name="apresentado" id="id-apresentado">
			<label for="id-apresentado">Apresentado</label>
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form>
</tags:template>