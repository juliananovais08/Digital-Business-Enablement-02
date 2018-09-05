<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template titulo="Lista de Produtos">

	<h1>Lista de Produtos</h1>

	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>

	<table>
		<tr class="table">
			<th>Id</th>
			<th>Nome</th>
			<th>Preço</th>
			<th>Perecível</th>
		</tr>
		<c:forEach items="${produtos}" var="produto">
			<tr class="table">
				<td>${produto.codigo }</td>
				<td>${produto.nome }</td>
				<td>${produto.preco }</td>
				<td>${produto.perecivel?"Sim":"Não" }</td>
				<td><a class = "btn btn-primary"
					href="<c:url value="/produto/editar/${produto.codigo }"/>">Editar</a>
				</td>
				<td>
					<button onclick="codigoProduto.value = ${produto.codigo }" class="btn btn-secondary" data-toggle="modal"
						data-target="#exampleModal">Remover</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Remover produto</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Deseja remover produto? Tem certeza?</div>
				<div class="modal-footer">
				<form action="<c:url value="/produto/remover"/>" method="post">
					<input type="hidden" id="codigoProduto" name="codigo">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form>
				</div>
			</div>
		</div>
	</div>
</tags:template>