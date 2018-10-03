<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:template titulo="Lista de Convidados">
	
	<h1>Lista de Convidados</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">
			${msg }
		</div>
	</c:if>
	
	<table class="table">
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Confirmado</th>	
			<th>Data Aniversário</th>
			<th></th>		
		</tr>
		<c:forEach items="${convidados }" var="c">
			<tr>
				<td>${c.codigo }</td>
				<td>${c.nome }</td>
				<td>${c.email }</td>
				<td>${c.confirmado?"Sim":"Não" }</td>
				<td>
					<fmt:formatDate value="${c.dataAniversario.time}"
						pattern="dd/MM/yyyy"/>
				</td>
				<td>
					<button ${c.confirmado?"disabled":"" } onclick="codigoConvidado.value = ${c.codigo}" type="button" class="btn btn-outline-success btn-sm" data-toggle="modal" data-target="#exampleModal">
						Confirmar
					</button>
					<button ${!c.confirmado?"disabled":"" } onclick="codigoConvidadoExcluir.value = ${c.codigo}" type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal" data-target="#exampleModal1">
						Excluir
					</button>
					<a href="<c:url value="/convidado/editar/${c.codigo }"/>" class="btn btn-outline-primary btn-sm">Editar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
<!-- Modal de Excluir -->
<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Deseja realmente excluir o convidado?
      </div>
      <div class="modal-footer">
      	<form action="<c:url value="/convidado/excluir"/>" method="post">
      		<input type="hidden" id="codigoConvidadoExcluir" name="id">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
	        <button type="submit" class="btn btn-danger">Sim</button>
      	</form>
      </div>
    </div>
  </div>
</div>

<!-- Modal de Confirmar-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Deseja realmente confirmar a presença?
      </div>
      <div class="modal-footer">
      	<form action="<c:url value="/convidado/confirmar"/>" method="post">
      		<input type="hidden" id="codigoConvidado" name="id">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
	        <button type="submit" class="btn btn-success">Sim</button>
      	</form>
      </div>
    </div>
  </div>
</div>
	
</tags:template>