<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template titulo="Lista de Produtos">

	<h1>Lista de Produtos</h1>

		<table>
			<tr class="table">
				<th>Id</th>
				<th>Nome</th>
				<th>Preço</th>
				<th>Perecível</th>
			</tr>
			<c:forEach items="${produtos}" var="produto">
				<tr class="table">
					<th>${produto.codigo }</th>
					<th>${produto.nome }</th>
					<th>${produto.preco }</th>
					<th>${produto.perecivel }</th>
				</tr>
			</c:forEach>
		</table>
</tags:template>