<%@page import="java.util.List"%>
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
			out.println("Modèle\t" + car.getModel());
			out.println("Rating\t" + car.getRating());
			out.println("price\t\t" + car.getPrice() + "\n");
			out.println("</p>");
		}
	}
%>
<%
	if (client.getAccount_id()==-1){
%>
	<%@ include file="account.jsp" %>
<%
	}else{
		out.println("<h3>Votre compte bancaire associé:</h3>");
		out.println("<p>Numéro: "+ client.getAccount_id()+"</p>");
		out.println("<p>Devise du compte: " + client.getCurrencyAccount()+"</p>");
		out.println("<p>Montant: "+ client.getAmountAccount() +" (soit "+client.getAmountAccountEUR() +" euros)</p>");
%>
	<p><form method = "post" action ="">
	<label for="deposit">Faire un dépôt:</label><input type="number" value="0" name="deposit">
	<input type="submit" value="Valider" name="makeADeposit"></form></p>
	<form method = "post" action =""> <input type="submit" value="Changer de compte" name="disconnect"></form>
	<br>
	<form method = "post" action =""> <input type="submit" value="Payer" name="BUY"></form>
<%
	}
	if (request.getSession().getAttribute("achat") != null && request.getSession().getAttribute("achat").equals("fait")){
	 	List<Car> cars =(List<Car>) request.getSession().getAttribute("achats");
		out.println("<p>Félicitations vous avez acheté :</p>");
		for(int i=0;i<cars.size();i++){
			out.println("<p>");
			out.println("id\t\t" + cars.get(i).getId());
			out.println("Modèle\t" + cars.get(i).getModel());

			out.println("<p>");
		}
	}else if(request.getSession().getAttribute("achat") != null && request.getSession().getAttribute("achat").equals("erreur")) {
		out.println("<p>Achat non fait: Compte pas assez approvisionné </p>");
	}
%>

</form>
</body>
</html>