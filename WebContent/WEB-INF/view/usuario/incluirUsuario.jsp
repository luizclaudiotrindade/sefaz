<!Doctype html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>
	<c:import url="areaUsuario.jsp" />
	<div class="col-md-9">
		<div class="profile-content">
			<hr>
			<h3>Cadastrar Usuário</h3>
			<hr>
			<div style="text-align: center; color: red;">${usuarioEncontrado}</div>
			<form action="save" method="post">
				<div class="form-row">
					<div class="col">
						Nome: <br /> <input class="form-control" type="text" name="nome" />

					</div>

					<div class="col">
						email: <br /> <input class="form-control" type="text"
							name="email" />
					</div>


					<div class="col">
						Senha: <br /> <input class="form-control" type="text"
							name="senha" />

					</div>

					<div class="col">
						Telefone: <br /> <input class="form-control" type="text"
							name="telefone" />

					</div>

				</div>
				<br> <input type="submit" class="btn btn-primary"
					value="cadastrar">
			</form>

		</div>
		<center>
			<strong>Desenvolvido por: <a
				href="https://github.com/luizclaudiotrindade" target="_blank">Luiz
					Claudio</a></strong>
		</center>
	</div>


</body>
</html>