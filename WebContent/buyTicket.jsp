<%@page import="java.util.*"%>
<%@page import="to.*"%>
<%@page import="model.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			<br>Comprar Passagem
		</p>
		<br>
	</h2>

	<div id="meio">
		<form method="post" action="ConsultFlight.do"
			id="form_ConsultFlight.do">
			<div id="t1">
				<fieldset>
					<legend>Selecione um Vôo</legend>
					<table cellspacing="10">

						<tr>
							<td><label for="boardingFlight">Origem:</label></td>
							<td align="left"><select name="boardingFlight"
								id="idBoardingFlight">
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
							<td align="left"><select name="landingFlight"
								id="idLandingFlight">
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
							<td align="left"><select name="dateFlight" id="idDateFlight">
									<option value="20151025">25/10/2015</option>
									<option value="20151026">26/10/2015</option>
									<option value="20151027">27/10/2015</option>
									<option value="20151028">28/10/2015</option>
							</select></td>


							<td><label for="timeFlight">Hora:</label></td>
							<td align="left"><select name="timeFlight" id="idTimeFlight">
									<option value="20:00">20:00</option>
									<option value="21:00">21:00</option>
									<option value="22:00">22:00</option>
									<option value="23:00">23:00</option>
							</select></td>
						</tr>
						<br>
						<tr>
							<td><div id="botaoProximo">
									<input type="submit" onclick="validacao1('t2','t1')"
										name="proximo" value="Proximo" class="button" />
								</div></td>
						</tr>
					</table>
				</fieldset>
			</div>

			<div id="t2">
				<fieldset>
					<legend>Dados Vôo</legend>
					<table id="t01">
						<br>
						<tr>
							<th name="idVoo">Num Vôo</th>
							<th name="origem">Origem</th>
							<th name="destino">Destino</th>
							<th name="data">Data</th>
							<th name="hora">Hora</th>
							<th name="preco">Preço</th>
							<th name="status">Status</th>
							<th name="idAeronave">Num Aeronave</th>
						</tr>
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

						<fieldset>
							<table cellspacing="5">
								<tr>
									<td><label for="legenda" id="legenda">J = Assento
											Janela, M = Assento Meio, C = Assento Corredor</label></td>
								</tr>
							</table>
						</fieldset>
						<br>
						<td><div id="botaoProximo">
								<input type="button" onclick="Mudarestado('t2','t3')"
									name="proximo" value="Proximo" class="button" />
							</div></td>
						<br>
					</table>
				</fieldset>
				<br />
			</div>
		</form>

		<div id="t3">
			<fieldset>
				<form method="post" action="ListarAssentos.do"
					id="form_ListarAssentos">
					<table cellspacing="10">
						<legend>Pesquise os assentos disponiveis do vôo escolhido</legend>
						<td><label for="flightID">Numeração Companhia: </label></td>
						<td align="left"><input type="number" name="flightID"
							id="idflightID" size="3" maxlength="3"></td>

						<td><div id="botao">
								<input type="submit" name="consultarAssentos" value="Consultar"
									class="button" onClick="validacao3" ()/>
							</div></td>

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
						<td><div id="botao">
								<input type="submit" name="proximo" value="Proximo"
									class="button" onclick="validadcao4('t3','t4')" />
							</div></td>
						<br>
					</table>
				</form>
			</fieldset>
		</div>

		<div id="t4">
			<fieldset>
				<form method="post" action="BuyTicket.do" id="form_BuyTicket">
					<table cellspacing="10">
						<legend>Dados Vôo</legend>

						<tr>
							<td><label for="clientId">Numeração Cliente</label></td>
							<td align="left"><input type="number" name="clientId"
								id="idclient" size="3" maxlength="3"></td>
						</tr>

						<tr>
							<td><label for="flightID">Numeração Vôo</label></td>
							<td align="left"><input type="number" name="flightID"
								id="idflightID" size="3" maxlength="3"></td>
						</tr>

						<tr>
							<td><label for="seatName">Assento Escolhido</label></td>
							<td align="left"><input type="text" name="seatName"
								id="idSeatName" size="3" maxlength="3"></td>
						</tr>

						<tr>
							<td><div id="botao">
									<input type="submit" name="comprar" value="Comprar"
										class="button" onclick="validacao2()" />
								</div></td>
						</tr>
					</table>
				</form>
			</fieldset>
		</div>
	</div>

	<script>
		function validacao() {
			var idVoo = document.getElementById("idVoo");

			if (idVoo == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}
		}
	</script>

	<script>
		function validacao1(id, div2) {

			var origem = document.getElementById("idBoardingFlight");
			var destino = document.getElementById("idLandingFlight");
			var data = document.getElementById("idDateFlight");
			var hora = document.getElementById("idTimeFlight");

			if (origem == "" || destino == "" || data == "" || hora == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}

			var divstyle = new String();
			divstyle = document.getElementById(id).style.display;

			var divAux = new String();
			divAux = document.getElementById(div2).style.display;

			if (divAux == "block" || divAux == "") {
				document.getElementById(div2).style.display = "none";
			}

			document.getElementById(id).style.display = "block";
			return false;
		}
	</script>

	<script>
		function validacao2() {

			var idCliente = document.getElementById("idclient");
			var idVoo = document.getElementById("idflightID");
			var idSeatName = document.getElementById("idAssento");

			if (idCliente == "" && idVoo == "" && idAssento == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}

		}
	</script>

	<script>
		function validadcao3(id, div2) {
			var idVoo = document.getElementById("idflightID");

			if (idVoo == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}
		}
	</script>

	<script>
		function validadcao4(id, div2) {
			var seatName = document.getElementById("idSeatName");

			if (seatName == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}

			var divstyle = new String();
			divstyle = document.getElementById(id).style.display;

			var divAux = new String();
			divAux = document.getElementById(div2).style.display;

			if (divAux == "block" || divAux == "") {
				document.getElementById(div2).style.display = "none";
			}

			document.getElementById(id).style.display = "block";
			return false;
		}
	</script>

	<script>
		function Mudarestado(id, div2) {
			var divstyle = new String();
			divstyle = document.getElementById(id).style.display;

			var divAux = new String();
			divAux = document.getElementById(div2).style.display;

			if (divAux == "block" || divAux == "") {
				document.getElementById(div2).style.display = "none";
			}

			document.getElementById(id).style.display = "block";
			return false;
		}
	</script>

	<footer>
		<p1>Projeto WEB USJT-ARQDSIS-3ASIN-2015.</p1>
	</footer>
</body>
</html>