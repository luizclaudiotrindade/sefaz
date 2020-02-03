<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="areaUsuario.jsp" />
	
	<div style="text-align: center; color: red;">${mensagem}</div>
	<div class="col-md-9">
		<div class="profile-content">
		<hr>
	<h3>Alterar Usuário</h3>
	<hr>
			<form action="update" method="post">
				<input class="form-control" type="hidden" name="id"
					value="${usuario.id}">
				<div class="form-group">
					<label for="inputCodigo">Nome</label> <input class="form-control"
						type="text" id="inputCodigo" class="form-control" name="nome"
						style="width: 396px;" maxlength="35" required="required"
						value="${usuario.nome}" />
				</div>
				<div class="form-group">
					<label for="inputCodigo">Email</label> <input class="form-control"
						type="text" id="inputCodigo" class="form-control" name="email"
						style="width: 396px;" maxlength="45" required="required"
						value="${usuario.email}" />
				</div>
				<div class="form-group">
					<label for="inputCodigo">Senha</label> <input class="form-control"
						type="text" id="inputCodigo" class="form-control" name="senha"
						style="width: 396px;" maxlength="30" required="required"
						value="${usuario.senha}" />
				</div>
				<div class="form-group">
					<label for="inputCodigo">Telefone</label> <input
						class="form-control" type="text" id="inputCodigo"
						class="form-control" name="telefone" style="width: 396px;"
						maxlength="30" required="required" value="${usuario.telefone}" />
				</div>
				<button type="submit">Alterar</button>
			</form>
		</div>
		</div>
		<strong>Desenvolvido por: <a
			href="https://github.com/luizclaudiotrindade" target="_blank">Luiz
				Claudio</a></strong>
</body>
</html>