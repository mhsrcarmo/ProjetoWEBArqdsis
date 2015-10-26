<%@page import="model.*"%>
<%@page import="to.*"%>
<%@page import="java.util.*"%>
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
			<p>Compra de Passagens Aéreas
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
			<br>Consultar Passagem
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
							<td><label for="flightID">Numeração Vôo</label></td>
							<td align="left"><input type="number" name="flightID"
								id="idflightID" size="3" maxlength="3"></td>

							<td><label for="CPF">CPF:</label></td>
							<td align="left"><input type="number" name="CPF" id="idCPF"
								size="11" maxlength="11"></td>

							<td><label for="seatName">Assento Escolhido</label></td>
							<td align="left"><input type="text" name="seatName"
								id="idSeatName" size="3" maxlength="3"></td>
						</tr>
						<br>
						<tr>
							<td>
								<div id="botao">
									<input type="submit" name="consultar" value="Consultar"
										class="button" onclick="validacao()" />
								</div>
						</tr>
						</td>
					</table>
				</fieldset>

				<fieldset>

					<legend>Dados da Consulta</legend>

					<table id="t01">
						<br>
						<tr>
							<th name="ticketID">Num Passagem</th>
							<th name="clientCPF">CPF</th>
							<th name="flightID">Num Vôo</th>
							<th name="seatName">Assento</th>
							<th name="ticketType">Tipo de Passagem</th>
						</tr>

						<%
							ArrayList<Ticket> lista = (ArrayList<Ticket>) request.getAttribute("lista");
												if (lista != null){
													Ticket ticket = lista.get(0);
														out.println("<tr><td align=\"left\"><input type=\"text\" name=\"ticketID\" size=\"5\""
																	+"maxlength=\"5\" readonly=\"readonly\" value="+ ticket.getTicketID() +"></td>"
																	+"<tr><td align=\"left\"><input type=\"number\" name=\"clientCPF\" size=\"11\""
																	+"maxlength=\"11\" readonly=\"readonly\"value="+  ticket.getClientCPF() +"></td>"
																	+"<tr><td align=\"left\"><input type=\"text\" name=\"flightID\" size=\"5\""
																	+"maxlength=\"5\" readonly=\"readonly\" value="+  ticket.getFlightID() +"></td>"
																	+"<td align=\"left\"><input type=\"text\" name=\"seatName\" size=\"3\""
																	+"maxlength=\"3\" readonly=\"readonly\" value="+ ticket.getSeatName() +"></td>"
																	+"<td align=\"left\"><input type=\"text\" name=\"ticketType\" size=\"10\""
																	+"maxlength=\"10\" readonly=\"readonly\" value="+ ticket.getTicketType() +"></td></tr>");
												}else{
													out.println("<tr><td align=\"left\"><input type=\"text\" name=\"ticketID\" size=\"5\""
															+"maxlength=\"5\" readonly=\"readonly\"></td>"
															+"<tr><td align=\"left\"><input type=\"number\" name=\"clientCPF\" size=\"11\""
															+"maxlength=\"11\" readonly=\"readonly\"></td>"
															+"<tr><td align=\"left\"><input type=\"text\" name=\"flightID\" size=\"5\""
															+"maxlength=\"5\" readonly=\"readonly\"></td>"
															+"<td align=\"left\"><input type=\"text\" name=\"seatName\" size=\"3\""
															+"maxlength=\"3\" readonly=\"readonly\"></td>"
															+"<td align=\"left\"><input type=\"text\" name=\"ticketType\" size=\"10\""
															+"maxlength=\"10\" readonly=\"readonly\"></td></tr>");
												}
						%>

					</table>
					<br>
				</fieldset>
			</h3>
		</form>
	</div>
	<br />

	<script>
		function validacao() {
			var idVoo = document.getElementById("idflightID");
			var cpf = document.getElementById("idCPF");
			var assento = document.getElementById("idSeatName");

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