<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang='pt-br'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
<link rel="stylesheet" href="css/styles.css">
<title>Projeto - ARQDESIS-3ASIN</title>
</head>
<body>
	<div id="nav">

		<h1>
			<p>Sistema de Compra de Passagem Aérea
			<p />
		</h1>

		<ul>
			<li><a href="" onclick="window.close()">Sair</a></li>

			<li><a href="">Relátorio</a>

				<ul>
					<li><a href="ticketReport.jsp">Relátorios de Passagem</a></li>
				</ul></li>

			<li><a href="">Passagem</a>

				<ul>
					<li><a href="buyTicket.jsp">Comprar Passagem</a></li>
					<li><a href="consultTicket.jsp">Consultar</a></li>
					<li><a href="changeTicket.jsp">Alterar</a></li>
					<li><a href="cancelTicket.jsp">Cancelar</a></li>
				</ul></li>

			<li><a href="">Vôo</a>

				<ul>
					<li><a href="registerFlight.jsp">Cadastrar</a></li>
					<li><a href="changeFlight.jsp">Alterar</a></li>
					<li><a href="consultFlight.jsp">Consultar</a></li>
					<li><a href="excludeFlight.jsp">Excluir</a></li>
				</ul></li>

			<li><a href="">Passageiro</a>

				<ul>
					<li><a href="registerPassenger.jsp">Cadastrar</a></li>
					<li><a href="changePassenger.jsp">Alterar</a></li>
					<li><a href="consultPassenger.jsp">Consultar</a></li>
					<li><a href="excludePassenger.jsp">Excluir</a></li>
				</ul></li>

			<li><a href="">Aeronave</a>

				<ul>
					<li><a href="registeringAirplane.jsp">Cadastrar</a></li>
					<li><a href="changeAirplane.jsp">Alterar</a></li>
					<li><a href="consultAirplane.jsp">Consultar</a></li>
					<li><a href="excludeAirplane.jsp">Excluir</a></li>
				</ul></li>

			<li><a href="index.html">Inicio</a></li>

		</ul>
	</div>

	<h2>
		<p>
			<br>Cadastrar Aeronave
		</p>
		<br>
	</h2>

	<div id="meio">
		<form method="post" action="registeringAirplane.do"
			id="form_registeringAirplane">
			<h3>
				<fieldset>
					<legend>Dados da Aeronave</legend>
					<table cellspacing="10">

						<tr>
							<td><label for="airCompanyID">Numeração Companhia: </label></td>
							<td align="left"><input type="number" name="airCompanyID"
								id="idCompanhia2" size="3" maxlength="3"></td>
						</tr>

						<tr>
							<td><label for="qtySeats">Quantidade de assentos: </label></td>
							<td align="left"><input type="number" name="qtySeats"
								id="idQuantidadeAssentos" size="5" maxlength="5"></td>
						</tr>

						<tr>
							<td><label for="modelAirplane">Modelo:</label></td>
							<td align="left"><select name="modelAirplane" id="idModelo">
									<option type="text" value="Airbus">Airbus</option>
									<option type="text" value="Boeing">Boeing</option>
									<option type="text" value="Jatinho">Jatinho Particular</option>
							</select></td>
						</tr>

						<script>
							function validacao() {

								var idCompanhia = document
										.getElementById("idCompanhia2");
								var quantidadeAssentos = document
										.getElementById("idQuantidadeAssentos");
								var modelo = document
										.getElementById("idModelo");
								var vazio = "";

								if (idCompanhia == vazio
										|| quantidadeAssentos == vazio
										|| modelo == vazio) {
									alert('Por favor preencher todos os campos')
								} else {
									alert('Seus dados foram encaminhado')
								}
							}
						</script>

						<tr>
							<td>
								<div id="botao">
									<input type="submit" name="confirmar" value="Confirmar"
										class="button" onclick="validacao()" />
								</div>
							</td>
						</tr>
					</table>
				</fieldset>
				<br />
			</h3>
		</form>
	</div>

	<footer> <p1>Projeto WEB USJT-ARQDSIS-3ASIN-2015.</p1> </footer>
</body>
</html>