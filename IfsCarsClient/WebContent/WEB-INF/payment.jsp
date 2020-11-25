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
BIENVENUE DANS L'ESPACE DE PAIEMENT
<h2>R�cap de votre panier</h2>
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
		out.println("<h3>Votre compte:</h3>");
		out.println("Num�ro: "+ (Long) request.getSession().getAttribute("verif_account_id")+"\n");
		out.println("Devise du compte: " + request.getSession().getAttribute("verif_currency")+"\n");
		out.println("Montant: "+(Double) request.getSession().getAttribute("amount_account")+"\n");
	}
%>

</form>
</body>
</html>