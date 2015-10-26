<%@page import="java.util.*"%>
<%@page import="to.*"%>
<%@page import="model.*"%>
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
			<p>Compra de Passagens A�reas
			<p />
		</h1>

		<ul>

			<li><a onclick="window.close()">Sair</a></li>

			<li><a href="">Rel�torio</a>

				<ul>
					<li><a href="ticketReport.jsp">Rel�torios de Passagem</a></li>
				</ul></li>

			<li><a href="">Passagem</a>

				<ul>
					<li><a href="buyTicket.jsp">Comprar Passagem</a></li>
					<li><a href="consultTicket.jsp">Consultar</a></li>
					<li><a href="changeTicket.jsp">Alterar</a></li>
					<li><a href="cancelTicket.jsp">Cancelar</a></li>
				</ul></li>

			<li><a href="">V�o</a>

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
			<br>Alterar Passagem
		</p>
		<br>
	</h2>

	<div id="meio">
		<form method="post" action="ConsultTicket.do" id="form_ConsultTicket">
			<h3>
				<fieldset>
					<legend>Consultar Passagem</legend>
					<table cellspacing="10">

						<tr>
							<td><label for="flightID">Numera��o V�o</label></td>
							<td align="left"><input type="number" name="flightID"
								id="idflightID" size="3" maxlength="3"></td>

							<td><label for="CPF">CPF:</label></td>
							<td align="left"><input type="number" name="CPF" size="11"
								maxlength="11"></td>

							<td><label for="seatName">Assento Escolhido</label></td>
							<td align="left"><input type="text" name="seatName"
								id="idSeatName" size="3" maxlength="3"></td>
						</tr>
						<br>
						<div id="botao">
							<input type="submit" name="consultar" value="Consultar"
								class="button" onclick="validacao()" />
						</div>
						</td>
						</td>
					</table>
				</fieldset>

				<fieldset>
					<form method="post" action="ChangeTicket.do" id="form_ChangeTicket">
						<legend>Dados da Passagem</legend>
						<table cellspacing="10">

							<tr>
								<td><label for="flightID">Numera��o V�o</label></td>
								<td align="left"><input type="number" name="flightID"
									id="idflightID" size="3" maxlength="3"></td>

								<label for="seatName">Estilo:</label>
								<select name="seatName" id="idSeatName" size="1">
									<option value=""></option>
									<%
										SeatsTO seats = (SeatsTO)request.getAttribute("listSeat");
													ArrayList<String> listaAssento = seats.getSeatName();
													for(String nome:listaAssento){
														out.print("<option value=\""+nome+"\">"+nome+"</option>");
													}
									%>
								</select>
							</tr>
							<tr>
								<td>
									<div id="botaoAlterar">
										<input type="submit" name="alterar" value="Alterar"
											class="button" />
									</div>
								</td>
							</tr>
						</table>
					</form>
				</fieldset>
				<br />
			</h3>
	</div>

	<script>
		function validacao() {
			var idVoo = document.getElementById("idVoo");
			var cpf = document.getElementById("cpf");
			var assento = document.getElementById("assento");

			if (idVoo == "" && cpf == "" && assento == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}
		}
	</script>

	<footer> <p1>Projeto WEB USJT-ARQDSIS-3ASIN-2015.</p1> </footer>

</body>
</html>