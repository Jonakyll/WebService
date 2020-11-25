<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<h3>INDIQUEZ VOTRE COMPTE POUR LE PAIEMENT</h3>
<form method="post" action="">
	<p><label for="account_id">Entrez le numéro de votre compte:</label>
	<input type="number" value="" name="account_id"></p>
	<input type="submit" value="Valider" name="haveAccount">
</form>
<h3>SINON CREER UN NOUVEAU COMPTE</h3>
<form method="post" action="">
	<p><label for="account_id">Entrez le numéro de votre compte:</label>
	<input type="number" value="" name="account_id"></p>
	<p><label for="currency">Entrez la devise de votre compte:</label>
	<input type="text" value="EUR" name="currency"></p>
	<p><label for="deposit">Valeur de votre premier dépôt:</label>
	<input type="number" value="0" name="deposit"></p>
	<p><input type="submit" value="Valider" name="createAccount"></p>
</form>
