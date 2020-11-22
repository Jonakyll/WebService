package fr.uge.webServices.project;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.xml.rpc.ServiceException;

import com.currencysystem.webservices.currencyserver.CurncsrvReturnRate;
import com.currencysystem.webservices.currencyserver.CurrencyServerLocator;
import com.currencysystem.webservices.currencyserver.CurrencyServerSoap;

public class Bank {
	private HashMap<Long, Account> accountMap;
	private CurrencyServerSoap soapServer;
	
	public Bank() throws ServiceException, RemoteException {
		this.accountMap =new HashMap<Long, Account>();
		this.soapServer = new CurrencyServerLocator().getCurrencyServerSoap();
		initBank();
	}
	
	private void initBank() throws RemoteException {
		this.addAccount(1L, "USD");
		this.addAccount(2L, "JPY");
		this.addAccount(3L, "EUR");
		this.addAccount(4L, "USD");
		this.addAccount(5L, "USD");
		this.addAccount(6L, "USD");
		this.addAccount(7L, "USD");
		this.addAccount(8L, "USD");
		this.addAccount(9L, "USD");
		
	}
	
	public void addAccount(Long id, String currency) throws RemoteException {
		if (!soapServer.currencyExists("", currency, true)){
			System.out.println(soapServer.currencyExists("", currency, true));
			System.out.println("Compte non ajouté car currency inexistante");
		}
		
		accountMap.put(id, new Account(id, currency));
		System.out.println("compte "+id+" ajouté Taille de la map: "+accountMap.size());
	}
	
	/*public void addAccount(Long id, Account account) throws RemoteException {
		if (!soapServer.currencyExists("", account.getCurrency(), true)){
			System.out.println("Compte non ajouté car currency inexistante");
		}
		accountMap.putIfAbsent(id, account);
	}*/

	private double isAbleToPay(Long id, double amountEUR) throws RemoteException {
		Account account = accountMap.get(id);
		double accountCurrentCurrency = (double) soapServer.convert("", "EUR",  account.getCurrency(), account.getValue(), 
				false, ".", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
		if (account.getValue() >=accountCurrentCurrency) {
			return accountCurrentCurrency;
		}
		return -1;
	}
	
	public void payVehicle(Long id, double amountEUR) throws RemoteException {
		if (amountEUR<0) {
			throw new IllegalArgumentException();
		}
		double amountToPay = isAbleToPay(id, amountEUR);
		if (amountToPay==-1) {
			System.out.println("Achat non effectué, compte pas assez approvisionné");
			return ;
		}
		accountMap.get(id).moneyBackOf(amountToPay);
		System.out.println("Vehicle acheté");
		return;
	}
	
	public void depositOf(Long id, double amount) {
		if (amount<0) {
			throw new IllegalArgumentException();
		}
		accountMap.get(id).moneyDepositOf(amount);
	}

	public void display() {
		System.out.println("AFFICHAGE DE LA BANQUE:");
		System.out.println(accountMap.size());
		for (Account account : accountMap.values()) {
			System.out.println(account);
		}
	}
	
	public String stringDisplay() {
		StringBuilder builder = new StringBuilder();
		builder.append("AFFICHAGE DE LA BANQUE:\n");
		for (Account account : accountMap.values()) {
			builder.append(account);
		}
		return builder.toString();
	}
	
	
	
	

}
