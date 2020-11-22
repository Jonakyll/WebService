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
BIENVENUE DANS L'ESPACE DE PAIMENT
<h2>Récap de votre panier</h2>
<% 
	/* Client client = (Client) request.getAttribute("client"); 
	java.util.List<Car> cart = client.getCart();
	out.println("<h2>Montant: "+(Integer) request.getAttribute("amount")+ " euros</h2>");
	for (Car car : cart) {
		out.println("<p>");
		out.println("id\t\t" + car.getId());
		out.println("price\t\t" + car.getPrice() + "\n");
		out.println("</p>");
	} */
%>
</body>
</html>