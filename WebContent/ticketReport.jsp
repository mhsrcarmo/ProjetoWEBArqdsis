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
			<li><a onclick="window.close()">Sair</a></li>

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
			<br>Relatórios de Vendas Diários
		</p>
		<br>
	</h2>

	<div id="meio">
		<form method="get" action="TicketReport.do" id="form_TicketReport">
			<h3>
				<fieldset>
					<legend>Relatorio de consulta de Passagens Vendidas</legend>
					<table cellspacing="10">

						<tr>
							<td><label for="dataPassagem">Data:</label></td>
							<td align="left"><input type="date" name="dataPassagem"
								size="4"></td>

							<td>
								<div id="botaoConsultar">
									<input type="submit" name="consultar" value="Consultar"
										class="button" onclick="validacao()" />
								</div>
							</td>
						</tr>
					</table>
				</fieldset>

				<br />
				<fieldset>
					<legend>Dados da Consulta</legend>

					<table id="t01">
						<br>
						<tr>
							<th name="idVoo">Num Vôo</th>
							<th name="origem">Origem</th>
							<th name="destino">Destino</th>
							<th name="data">Data</th>
							<th name="hora">Hora</th>
							<th name="preco">Preço</th>
							<th name="cpf">CPF</th>
							<th name="nome">Nome</th>
							<th name="assento">Nome</th>
						</tr>
						<tr>
						<tr>
							<td align="left"><input type="text" name="idVoo" size="5"
								maxlength="5" readonly="readonly"></td>
							<td align="left"><input type="text" name="origem" size="20"
								maxlength="20" readonly="readonly"></td>
							<td align="left"><input type="text" name="destino" size="20"
								maxlength="20" readonly="readonly"></td>
							<td align="left"><input type="date" name="data"
								readonly="readonly"></td>
							<td align="left"><input type="text" name="hora" size="5"
								maxlength="5" readonly="readonly"></td>
							<td align="left"><input type="number" name="preco" size="7"
								maxlength="7" readonly="readonly"></td>
							<td align="left"><input type="number" name="cpf" size="11"
								maxlength="11" readonly="readonly"></td>
							<td align="left"><input type="text" name="nome" size="20"
								maxlength="20" readonly="readonly"></td>
							<td align="left"><input type="text" name="assento" size="5"
								maxlength="5" readonly="readonly"></td>
						</tr>


					</table>
					<br>

				</fieldset>
			</h3>
		</form>
	</div>
	<br />

	<script>
		function validacao() {
			var data = document.getElementById("data");

			if (data == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}
		}
	</script>

	<footer> <p1>Projeto WEB USJT-ARQDSIS-3ASIN-2015.</p1> </footer>

</body>
</html>