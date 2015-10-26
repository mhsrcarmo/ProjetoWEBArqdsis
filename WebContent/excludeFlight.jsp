<%@page import="model.Flight"%>
<%@page import="to.FlightTO"%>
<%@page import="java.util.*"%>
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
			<br>Excluir Vôo
		</p>
		<br>
	</h2>

	<br />
	<div id="meio">
		<form method="post" action="ConsultFlight.do" id="form_ConsultFlight">
			<h3>
				<fieldset>
					<legend>Consultar Vôo</legend>
					<table cellspacing="10">

						<tr>
							<td><label for="boardingFlight">Origem:</label></td>
							<td align="left"><select name="boardingFlight">
									<option
										value="Confins, Aeroporto Internacional de Minas - Tancredo Neves">
										Confins, Aeroporto Internacional de Minas - Tancredo Neves</option>
									<option value="Guarulhos, Aeroporto Internacional de Guarulhos">
										Guarulhos, Aeroporto Internacional de Guarulhos</option>
									<option
										value="Belém, Aeroporto Internacional de Belém - Val de Cans">
										Belém, Aeroporto Internacional de Belém - Val de Cans</option>
									<option
										value="Rio de Janeiro, Aeroporto Internacional do RJ - Galeão">
										Rio de Janeiro, Aeroporto Internacional do RJ - Galeão</option>
							</select></td>

							<td><label for="landingFlight">Destino:</label></td>
							<td align="left"><select name="landingFlight">
									<option
										value="Confins, Aeroporto Internacional de Minas - Tancredo Neves">
										Confins, Aeroporto Internacional de Minas - Tancredo Neves</option>
									<option value="Guarulhos, Aeroporto Internacional de Guarulhos">
										Guarulhos, Aeroporto Internacional de Guarulhos</option>
									<option
										value="Belém, Aeroporto Internacional de Belém - Val de Cans">
										Belém, Aeroporto Internacional de Belém - Val de Cans</option>
									<option
										value="Rio de Janeiro, Aeroporto Internacional do RJ - Galeão">
										Rio de Janeiro, Aeroporto Internacional do RJ - Galeão</option>
							</select></td>
						</tr>

						<tr>
							<td><label for="dateFlight">Data do Vôo:</label></td>
							<td align="left"><select name="dateFlight">
									<option value="20151025">25/10/2015</option>
									<option value="20151026">26/10/2015</option>
									<option value="20151027">27/10/2015</option>
									<option value="20151028">28/10/2015</option>
							</select></td>


							<td><label for="timeFlight">Hora:</label></td>
							<td align="left"><select name="timeFlight">
									<option value="20:00">20:00</option>
									<option value="21:00">21:00</option>
									<option value="22:00">22:00</option>
									<option value="23:00">23:00</option>
							</select></td>
						</tr>
						<tr>
							<td><div id="botao">
									<input type="submit" name="consultar" value="Consultar"
										class="button" onclick="validacao()" />
								</div></td>
						</tr>
					</table>
				</fieldset>

				<fieldset>
					<legend>Dados Vôo</legend>
					<table cellspacing="10">

						<%
							ArrayList<Flight> lista = (ArrayList<Flight>) request.getAttribute("lista");
												if (lista != null){
													Flight flight = lista.get(0);
													
													out.println("<tr><td><label for=\"flightID\">Numeração Vôo:</label></td>"
																+"<td align=\"left\"><input type=\"number\"name=\"flightID\"size=\"3\""
																+"maxlength=\"3\" value="+flight.getFlightID()+"></td></tr>"
																+"<tr><td><label for=\"boardingFlight\">Origem:</label></td>"
																+"<td align=\"left\"><input type=\"text\" name=\"boardingFlight\""
																+"readonly=\"readonly\" value=" + flight.getBoardingFlight()+ "></td>"
																+"<tr><td><label for=\"landingFlight\">Origem:</label></td>"
																+"<td align=\"left\"><input type=\"text\" name=\"landingFlight\""
																+"readonly=\"readonly\" value=" + flight.getLandingFlight()+ "></td></tr>"
																+"<tr><td><label for=\"dateFlight\">Data do Vôo:</label></td>"
																+"<td align=\"left\"><input type=\"date\" name=\"dateFlight\""
																+"readonly=\"readonly\" value="+flight.getDateFlight()+"></td>"
																+"<td><label for=\"timeFlight\">Hora:</label></td>"
																+"<td align=\"left\"><input type=\"text\" name=\"timeFlight\" size=\"9\""
																+"readonly=\"readonly\" value="+flight.getTimeFlight()+"></td>"
																+"<td><label for=\"priceFlight\">Preço R$:</label></td>"
																+"<td align=\"left\"><input type=\"number\" name=\"priceFlight\" size=\"9\""
																+"readonly=\"readonly\" value="+flight.getPriceFlight()+"></td></tr>"
																+"<tr><td><label for=\"flight_St\">Status:</label></td>"
																+"<td align=\"left\"><input type=\"text\" name=\"flight_St\""
																+"readonly=\"readonly\" value="+flight.getFlight_St()+"></td>"
																+"<td><label for=\"airplaneID\">Codigo Aeronave:</label></td>"
																+"<td align=\"left\"><input type=\"number\" name=\"airplaneID\""
																+"size=\"9\" readonly=\"readonly\" value="+flight.getAirplaneID()+"></td></tr>");
												}else{
													out.println("<tr><td><label for=\"flightID\">Numeração Vôo:</label></td>"
															+"<td align=\"left\"><input type=\"number\"name=\"flightID\"size=\"3\" maxlength=\"3\"></td></tr>"
															+"<tr><td><label for=\"boardingFlight\">Origem:</label></td>"
															+"<td align=\"left\"><input type=\"text\" name=\"boardingFlight\""
															+"readonly=\"readonly\" ></td>"
															+"<tr><td><label for=\"landingFlight\">Origem:</label></td>"
															+"<td align=\"left\"><input type=\"text\" name=\"landingFlight\""
															+"readonly=\"readonly\"></td></tr>"
															+"<tr><td><label for=\"dateFlight\">Data do Vôo:</label></td>"
															+"<td align=\"left\"><input type=\"date\" name=\"dateFlight\""
															+"readonly=\"readonly\"></td>"
															+"<td><label for=\"timeFlight\">Hora:</label></td>"
															+"<td align=\"left\"><input type=\"text\" name=\"timeFlight\" size=\"9\""
															+"readonly=\"readonly\"></td>"
															+"<td><label for=\"priceFlight\">Preço R$:</label></td>"
															+"<td align=\"left\"><input type=\"number\" name=\"priceFlight\" size=\"9\""
															+"readonly=\"readonly\"></td></tr>"
															+"<tr><td><label for=\"flight_St\">Status:</label></td>"
															+"<td align=\"left\"><input type=\"text\" name=\"flight_St\""
															+"readonly=\"readonly\"></td>"
															+"<td><label for=\"airplaneID\">Codigo Aeronave:</label></td>"
															+"<td align=\"left\"><input type=\"number\" name=\"airplaneID\""
															+"size=\"9\" readonly=\"readonly\"></td></tr>");
												}
						%>
					</table>
				</fieldset>

				<fieldset>
					<form method="post" action="ExcludeFlight.do"
						id="form_ExcludeFlight">
						<legend>Digite o Numero do Vôo que ser excluido</legend>
						<table cellspacing="10">
							<tr>
								<td><label for="flightID">Numeração Vôo:</label></td>
								<td align="left"><input type="number" name="flightID"
									id="idVoo" size="3" maxlength="3"></td>

								<td><div id="botaoExcluir">
										<input type="submit" name="excluir" value="Excluir"
											class="button" onClick="validacao()" />
									</div></td>
							</tr>
						</table>
					</form>
				</fieldset>
				<br />
			</h3>
		</form>
	</div>
	<br />
	<script>
		function validacao() {
			var idOrigem = document.getElementById("idBoardingFlight");
			var idDestino = document.getElementById("idLandingFlight");
			var idData = document.getElementById("idDateFlight");
			var idHora = document.getElementById("idTimeFlight");

			if (idOrigem == "" || idDestino == "" || idData == ""
					|| idHora == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}

		}
	</script>

	<footer> <p1>Projeto WEB USJT-ARQDSIS-3ASIN-2015.</p1> </footer>

</body>
</html>