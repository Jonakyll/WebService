<%@page import="fr.uge.webServices.project.Car"%>
<%@page import="fr.uge.webServices.commons.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IfsCarsService</title>
</head>
<body>
<header>
<a href="/IfsCarsClient" >ACCUEIL</a>
<br>
</header>
<br>
<h1>BIENVENUE DANS L'ESPACE DE PAIEMENT</h1>
<h2>Récap de votre panier</h2>
<% 
	Client client = (Client) request.getSession().getAttribute("client"); 
	if (client!=null){
		java.util.List<Car> cart = client.getCart();
		out.println("<h3>Montant: "+(Integer) request.getSession().getAttribute("amount")+ " euros</h3>");
		for (Car car : cart) {
			out.println("<p>");
			out.println("id\t\t" + car.getId());
			out.println("price\t\t" + car.getPrice() + "\n");
			out.println("</p>");
		}
	}
%>
<%
	if (request.getSession().getAttribute("verif_account_id")==null){
%>
	<%@ include file="account.jsp" %>
<%
	}else{
		out.println("<h3>Votre compte bancaire associé:</h3>");
		out.println("<p>Numéro: "+ (Long) request.getSession().getAttribute("verif_account_id")+"</p>");
		out.println("<p>Devise du compte: " + request.getSession().getAttribute("verif_currency")+"</p>");
		out.println("<p>Montant: "+(Double) request.getSession().getAttribute("amount_account")+"</p>");
%>
	<p><label for="deposit">Faire un dépôt:</label>
	<input type="number" value="0" name="deposit">
	<input type="submit" value="Valider" name="makeADeposit"></p>
	<form method = "post" action =""> <input type="submit" value="Changer de compte" name="disconnect"></form>
	<br>
	<form method = "post" action =""> <input type="submit" value="Payer" name="BUY"></form>
<%
	}
%>

</form>
</body>
</html>