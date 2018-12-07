<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tags:template titulo="Lista de Jogos">

	<h1>Lista de Jogos</h1>

	<c:if test="${not empty msg }">
		<div class="alert alert-sucess">${msg}</div>
	</c:if>
	
	<form class="form-inline" action="<c:url value="/jogo/buscarPorNome"/>">
		<input type="text" name="nome" placeholder="Digite o nome" class="form=control">
		<button type="submit" class="btn btn-outline-sucess">Pesquisar</button>
	</form>
	<br>
		<c:url value="/jogo/buscarPorGenero" var="acao"/>
		<form:form class="form-inline" action="${acao}" commandName="genero" method="get">
			<form:select path="codigo" cssClass="form-control">
				<form:option value="0">Selecione</form:option>
				<form:options items="${generos}" itemLabel="nome" itemValue="codigo"/>
			</form:select>
			<button type="submit" class="btn btn-outline-sucess">Pesquisar por Gênero</button>
		</form:form>
	<br>	
	<table class="table">
		<tr>
			<th>Nome</th>
			<th>Data de lançamento</th>
			<th>Disponível</th>
			<th>Gênero</th>
			<th>Plataforma</th>
		</tr>
		<c:forEach items="${jogos }" var="j">
			<tr>
				<td>${j.nome}</td>
				<td><fmt:formatDate value="${j.dataLancamento.time}" pattern="dd/MM/yyyy"/></td>
				<td>${j.disponivel?"Sim":"Não"}</td>
				<td>${j.genero.nome}</td>
				<td>${j.plataforma.label}</td>
				<td>
					<c:if test="${!j.disponivel }">
						<button onclick="codigoDis.value = ${j.codigo}" type="button" class="btn btn-outline-success btn-sm" data-toggle="modal" data-target="#modalDisponibilizar">
						  Disponibilizar
						</button>			
					</c:if>
				</td>
				<td>
					<a href="<c:url value="/jogo/editar/${j.codigo }"/>" class="btn btn-outline-primary btn-sm">Editar</a>
					<button onclick="codigoRemover.value = ${j.codigo}" type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal" data-target="#modalRemover">
						  Remover
				    </button>
				</td>
			</tr>
		</c:forEach>
	</table>

	<!-- Modal Disponibilizar -->
	<div class="modal fade" id="modalDisponibilizar" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Deseja realmente disponibilizar o
					jogo?</div>
				<div class="modal-footer">
					<form action="<c:url value="/jogo/disponibilizar"/>" method="post">
						<input type="hidden" name="codigo" id="codigoDis"><br>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Não</button>
						<button type="submit" class="btn btn-success">Sim</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal Excluir -->
	<div class="modal fade" id="modalRemover" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Deseja realmente apagar o jogo?</div>
				<div class="modal-footer">
					<form action="<c:url value="/jogo/remover"/>" method="post">
						<input type="hidden" name="codigo" id="codigoRemover"><br>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Não</button>
						<button type="submit" class="btn btn-danger ">Sim</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</tags:template>
