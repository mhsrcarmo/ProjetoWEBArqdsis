<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<br>Cadastrar Passageiro
		</p>
		<br>
	</h2>

	<br />
	<div id="meio">
		<form method="post" action="registerPassenger.do"
			id="form_registerPassenger">
			<h3>
				<fieldset>
					<legend>Dados do Passageiro</legend>
					<table cellspacing="10">

						<tr>
							<td><label for="CPF">CPF:</label></td>
							<td align="left"><input type="number" name="CPF" size="11"
								maxlength="11"></td>
						</tr>

						<tr>
							<td><label for="treatmentClient">Forma de
									Tratamento:</label></td>
							<td align="left"><select name="treatmentClient">
									<option value="sr">Sr.</option>
									<option value="sra">Sra.</option>
									<option value="dr">Dr.</option>
							</select></td>
						</tr>

						<tr>
							<td><label for="nameClient">Nome:</label></td>
							<td align="left"><input type="text" name="nameClient"></td>

							<td><label for="lastNameClient">Sobrenome:</label></td>
							<td align="left"><input type="text" name="lastNameClient"></td>
						</tr>

						<tr>
							<td><label for="emailClient">Email:</label></td>
							<td align="left"><input type="email" name="emailClient"></td>
						</tr>

						<tr>
							<td><label for="birthDate">Data de Nascimento:</label></td>
							<td align="left"><input type="date" name="birthDate"></td>
						</tr>

						<tr>
							<td><label for="telephoneClient">Telefone:</label></td>
							<td align="left"><input type="number" name="telephoneClient"
								size="9" maxlength="9"></td>
						</tr>
						<br>
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
	<br />
	<footer> <p1>Projeto WEB USJT-ARQDSIS-3ASIN-2015.</p1> </footer>
</body>
</html>