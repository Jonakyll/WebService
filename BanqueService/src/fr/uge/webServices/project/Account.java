package fr.uge.webServices.project;

public class Account {
	private long id_owner;
	private String currency;
	private double value = 0.0;
	
	public Account(long id_owner, String currency) {
		this.id_owner = id_owner;
		this.currency = currency;
	}

	public void moneyDepositOf(double montant) {
		if (montant<0) {
			throw new IllegalArgumentException();
		}
		value+=montant;
	}
	
	public boolean moneyBackOf(double montant) {
		if (value-montant<0) {
			return false;
		}
		value-=montant;
		return true;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return "Account [id_owner=" + id_owner + ", currency=" + currency + ", value=" + value + "]";
	}
	
	
}