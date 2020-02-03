<!Doctype html>
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min
.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
	  $("#pesquisa").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#tabelaListaProduto").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
</script>

</head>
<body>

	<c:import url="areaUsuario.jsp" />
	<div class="col-md-9">
		<div class="profile-content">
			<form action="filter">
				<div class="form-group">
					<label for="inputCodigo">Nome</label> <input type="text"
						id="pesquisa"  class="form-control" name="nome"
						style="width: 100px;" maxlength="45" />
				</div>
				<div class="form-group">
					<label for="inputDescricao">Email</label> <input type="text"
						  id="pesquisa" class="form-control" name="email"
						style="width: 500px;" maxlength="100" />
				</div>
				<div class="form-group">
					<button type="reset" class="btn btn-default">&nbsp; Limpar
						&nbsp;</button>
					&nbsp;
					<button type="submit" class="btn btn-primary">&nbsp;
						Filtrar &nbsp;</button>
				</div>
			</form>

			<hr>
			<h3>Listar Usuarios</h3>
			<hr>
			<div style="text-align: center; color: red;">${mensagem}</div>
			<jsp:useBean id="dao" class="br.com.sefaz.model.UsuarioDao" />
			<table id="tabelaListaProduto" 
				class="table table-striped table-bordered">
				<thead>

					<tr>
						<th style="width: 5%; vertical-align: middle; text-align: center;">
							Nome</th>
						<th style="width: 25%; vertical-align: middle;">Email</th>
						<th style="width: 25%; vertical-align: middle;">Senha</th>
						<th style="width: 25%; vertical-align: middle;">Telefone</th>
					</tr>
				</thead>
				<c:forEach var="usuario" items="${listaUsuario}">
					<tr>
						<td style="vertical-align: middle; text-align: center;">${usuario.nome}</td>
						<td style="vertical-align: middle;">${usuario.email}</td>
						<td style="vertical-align: middle;">${usuario.senha}</td>
						<td style="vertical-align: middle;">${usuario.telefone}</td>
						<td style="vertical-align: middle; text-align: center;"><a
							href="edit?id=${usuario.id}">Alterar</a> &nbsp; &nbsp;</td>
						<td style="vertical-align: middle; text-align: center;"><a
							href="delete?id=${usuario.id}">Remover</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>