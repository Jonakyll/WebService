<%@page import="fr.uge.webServices.project.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IfsCarsService</title>
</head>
<body>
<h1>Votre panier:</h1>
<h2>Montant:
<%
	if (request.getSession().getAttribute("amount")==null){
		out.println(" 0 euros");
	}else{
		out.println(" "+(Integer) request.getSession().getAttribute("amount")+ " euros");
	}
%></h2>
<h2>Contenu: </h2>
<%
	java.util.List<Car> cart = (java.util.List<Car>) request.getSession().getAttribute("cart");
	for (Car car : cart) {
		out.println("<p>");
		out.println("id\t\t" + car.getId());
		out.println("Modèle\t" + car.getModel());
		out.println("Rating\t" + car.getRating());
		out.println("price\t\t" + car.getPrice() + "\n");
		out.println("</p>");
	}
%>
<form method = "post" action ="/IfsCarsClient/Payment"> <input type="submit" value="Passer au paiment" name="HOME"></form>
<br>
<form method = "post" action =""> <input type="submit" value="Vider votre panier" name="clean"></form>
<h1>Nos voitures:</h1>
	<%
	Car[] cars = (fr.uge.webServices.project.Car [])request.getSession().getAttribute("cars");
	for(int i=0;i<cars.length;i++){
		out.println("<p>");
		out.println("id\t\t" + cars[i].getId());
		out.println("Modèle\t" + cars[i].getModel());
		out.println("Rating\t" + cars[i].getRating());
		out.println("price\t\t" + cars[i].getPrice() + "\n");
		out.println("<form method=\"post\" action=\"\"> <input type=\"submit\" value=\"Ajouter au panier\" name=\""+cars[i].getId()+"\"/></form></p>");
	}
	%>
</body>
</html>