<%@page import="model.*"%>
<%@page import="to.*"%>
<%@page import="java.util.*"%>
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
			</tr>

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
			<br>Alterar Aeronave
		</p>
		<br>
	</h2>

	<br />
	<div id="meio">
		<form method="post" action="ConsultAirplane.do"
			id="form_ConsultAirplane">
			<h3>
				<fieldset>
					<legend>Consulta por ID Aeronave</legend>
					<table cellspacing="10">

						<tr>
							<td><label for="idAeronave">ID Aeronave:</label></td>
							<td align="left"><input type="text" name="idAeronave"
								size="4"></td>

							<td>
								<div id="botaoConsultar">
									<input type="submit" name="consultar" value="Consultar"
										class="button" onclick="validacao()" />
								</div>
							</td>
						</tr>
						</form>
					</table>
				</fieldset>
				<br />

				<form method="post" action="ChangeAirplane.do"
					id="form_ChangeAirplane">
					<fieldset>
						<legend>Dados da Aeronave</legend>
						<table cellspacing="10">

							<%
								ArrayList<Airplane> lista = (ArrayList<Airplane>) request.getAttribute("lista");
													if (lista != null){
														Airplane airplane = lista.get(0);
														out.println("<tr><td><label for=\"airCompanyID\">Numeração Companhia:</label></td>"
																	+"<td align=\"left\"><input type=\"number\" name=\"airCompanyID\""
																	+"id=\"idCompanhia2\" size=\"3\" maxlength=\"3\" value="
																	+airplane.getAirCompanyID()+"></td></tr>"
																	+"<tr><td><label for=\"qtySeats\">Quantidade de assentos: </label></td>"
																	+"<td align=\"left\"><input type=\"number\" name=\"qtySeats\""
																	+"id=\"idQuantidadeAssentos\" size=\"5\" maxlength=\"5\"value=" 
																	+airplane.getQtySeats()+"></td></tr>"
																	+"<tr><td><label for=\"modelAirplane\">Modelo:</label></td>"
																	+"<td align=\"left\"><select name=\"modelAirplane\" id=\"idModelo\">"
																	+"<option type=\"text\" value="+airplane.getModelAirplane()+">"+airplane.getModelAirplane()+"</option>"
																	+"<option type=\"text\" value=\"Airbus\">Airbus</option>"
																	+"<option type=\"text\" value=\"Boeing\">Boeing</option>"
																	+"<option type=\"text\" value=\"Jatinho\">Jatinho Particular</option>"
																	+"</select></td>");
													}else{
														out.println("<tr><td><label for=\"airCompanyID\">Numeração Companhia:</label></td>"
																+"<td align=\"left\"><input type=\"number\" name=\"airCompanyID\""
																+"id=\"idCompanhia2\" size=\"3\" maxlength=\"3\" value=></td></tr>"
																+"<tr><td><label for=\"qtySeats\">Quantidade de assentos: </label></td>"
																+"<td align=\"left\"><input type=\"number\" name=\"qtySeats\""
																+"id=\"idQuantidadeAssentos\" size=\"5\" maxlength=\"5\"></td></tr>"
																+"<tr><td><label for=\"modelAirplane\">Modelo:</label></td>"
																+"<td align=\"left\"><select name=\"modelAirplane\" id=\"idModelo\">"
																+"<option type=\"text\" value=\"Airbus\">Airbus</option>"
																+"<option type=\"text\" value=\"Boeing\">Boeing</option>"
																+"<option type=\"text\" value=\"Jatinho\">Jatinho Particular</option>"
																+"</select></td>");
													}
							%>

							</tr>
							<td>
								<div id="botaoAlterar">
									<input type="submit" name="alterar" value="Alterar"
										class="button" onclick="validacao2()" />
								</div>
							</td>
							</tr>
						</table>
					</fieldset>
			</h3>
		</form>
	</div>
	<br />


	<script>
		function validacao() {

			var idAeronave = document.getElementById("idAeronave");

			if (idAeronave == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}
		}
	</script>

	<script>
		function validacao2() {

			var idAeronave2 = document.getElementById("idAeronave2");
			var companhia = document.getElementById("nomeCompanhia");
			var quantidadeAssentos = document
					.getElementById("quantidadeAssentos");
			var modelo = document.getElementById("modelo");

			if (idAeronave2 == "" && companhia == ""
					&& quantidadeAssentos == "" && modelo == "") {
				alert('Por favor preencher todos os campos')
			} else {
				alert('Seus dados foram encaminhado')
			}

		}
	</script>

	<footer>
		<p1>Projeto WEB USJT-ARQDSIS-3ASIN-2015.</p1>
	</footer>
</body>
</html>