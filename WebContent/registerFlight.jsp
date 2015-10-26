<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
			<p>Sistema de Compra de Passagem Aérea<p/>
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
			<br>Cadastrar Vôos
		</p>
		<br>
	</h2>

	<div id="meio">
		<form method="post" action="RegisterFlight.do" id="form_RegisterFlight">
			<h3>
				<fieldset>
					<legend>Dados do Vôo</legend>
					<table cellspacing="10">

						<tr>
							<td><label for="boardingFlight">Origem:</label></td>
							<td align="left"><select name="boardingFlight">
									<option value="Confins, Aeroporto Internacional de Minas - Tancredo Neves">
									Confins, Aeroporto Internacional de Minas - Tancredo Neves</option>
									<option value="Guarulhos, Aeroporto Internacional de Guarulhos">
									Guarulhos, Aeroporto Internacional de Guarulhos</option>
									<option value="Belém, Aeroporto Internacional de Belém - Val de Cans">
									Belém, Aeroporto Internacional de Belém - Val de Cans</option>
									<option value="Rio de Janeiro, Aeroporto Internacional do RJ - Galeão">
									Rio de Janeiro, Aeroporto Internacional do RJ - Galeão</option>
							</select></td>

							<td><label for="landingFlight">Destino:</label></td>
							<td align="left"><select name="landingFlight">
									<option value="Confins, Aeroporto Internacional de Minas - Tancredo Neves">
									Confins, Aeroporto Internacional de Minas - Tancredo Neves</option>
									<option value="Guarulhos, Aeroporto Internacional de Guarulhos">
									Guarulhos, Aeroporto Internacional de Guarulhos</option>
									<option value="Belém, Aeroporto Internacional de Belém - Val de Cans">
									Belém, Aeroporto Internacional de Belém - Val de Cans</option>
									<option value="Rio de Janeiro, Aeroporto Internacional do RJ - Galeão">
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

							<td><label for="priceFlight">Preço R$:</label></td>
							<td align="left"><input type="text" name="priceFlight" id="moeda"
								size="5"></td>
						</tr>

						<tr>
							<td><label for="escalas">Status:</label></td>
							<td align="left"><select name="escala">
									<option value="normal">Normal</option>
									<option value="cancelado">Cancelado</option>
									<option value="atrasado">Atrasado</option>
									<option value="suspenso">Suspenso</option>
							</select></td>

							<td><label for="airplaneID">Codigo Aeronave:</label></td>
							<td align="left"><input type="number" name="airplaneID"
								size="3"></td>
						</tr>

						<tr>
							<td>
								<div id="botao">
									<input type="submit" name="confirmar" value="Confirmar"
										class="button" />
								</div>
							</td>
						</tr>
					</table>
				</fieldset>
				<br />
			</h3>
		</form>
	</div>

	<script type="text/javascript">
		function id(el) {
			return document.getElementById(el);
		}
		String.prototype.formatMoney = function() {
			var v = this.replace(/(\d{1,3})$/g, "$1,00");
			v = v.replace(/(\d{1,3})(\d{3},00)$/, "$1.$2");
			return v;
		};
		window.onload = function() {
			id('moeda').onblur = function() {
				var v = this.value;
				if (v.indexOf(',') === 0) {
					v = v.replace(',', '');
					if (v.length === 1)
						v = '0,' + v + '0';
					else
						v = '0,' + v;
				} else {
					v = v.formatMoney();
				}
				this.value = v;
			}
		};
	</script>

	<SCRIPT LANGUAGE="JavaScript">
		function Mascara_Hora(Hora) {
			var hora01 = '';
			hora01 = hora01 + Hora;
			if (hora01.length == 2) {
				hora01 = hora01 + ':';
				document.forms[0].Hora.value = hora01;
			}
			if (hora01.length == 5) {
				Verifica_Hora();
			}
		}

		function Verifica_Hora() {
			hrs = (document.forms[0].Hora.value.substring(0, 2));
			min = (document.forms[0].Hora.value.substring(3, 5));

			estado = "";
			if ((hrs < 00) || (hrs > 23) || (min < 00) || (min > 59)) {
				estado = "errada";
			}

			if (document.forms[0].Hora.value == "") {
				estado = "errada";
			}

			if (estado == "errada") {
				alert("Hora inválida!");
				document.forms[0].Hora.focus();
			}
		}
	</script>

	<footer> <p1>Projeto WEB USJT-ARQDSIS-3ASIN-2015.</p1> </footer>

</body>
</html>