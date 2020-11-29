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
		this.depositOf(1L, 10000000);
		this.addAccount(2L, "JPY");
		this.depositOf(2L, 10000);
		this.addAccount(3L, "EUR");
		this.depositOf(3L, 10000);
		this.addAccount(4L, "USD");
		this.depositOf(4L, 10000);
		this.addAccount(5L, "USD");
		this.depositOf(5L, 10000);
		this.addAccount(6L, "USD");
		this.depositOf(6L, 10000);
		this.addAccount(7L, "USD");
		this.depositOf(7L, 10000);
		this.addAccount(8L, "USD");
		this.depositOf(8L, 10000);
		this.addAccount(9L, "USD");
		this.depositOf(9L, 10000);
		
	}
	
	public int addAccount(Long id, String currency) throws RemoteException {
		if (!soapServer.currencyExists("", currency, true)){
			System.out.println(soapServer.currencyExists("", currency, true));
			System.out.println("Compte non ajouté car currency inexistante");
			return -1;
		}
		int oldSize = accountMap.size();
		accountMap.put(id, new Account(id, currency));
		return accountMap.size()-oldSize;
	}
	
	/*public void addAccount(Long id, Account account) throws RemoteException {
		if (!soapServer.currencyExists("", account.getCurrency(), true)){
			System.out.println("Compte non ajouté car currency inexistante");
		}
		accountMap.putIfAbsent(id, account);
	}*/

	private double isAbleToPay(Long id, double amountEUR) throws RemoteException {
		Account account = accountMap.get(id);
		double amountToPay = (double) soapServer.convert("", "EUR",  account.getCurrency(), amountEUR, 
				false, ".", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
		if (account.getValue() >=amountToPay) {
			return amountToPay;
		}
		return -1;
	}
	
	public boolean pay(Long id, double amountEUR) throws RemoteException {
		if (amountEUR<0) {
			throw new IllegalArgumentException();
		}
		double amountToPay = isAbleToPay(id, amountEUR);
		if (amountToPay==-1) {
			System.out.println("Achat non effectué, compte pas assez approvisionné");
			return false;
		}
		accountMap.get(id).moneyBackOf(amountToPay);
		System.out.println("Achat effectué");
		return true;
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
	
	public boolean checkAccount(long id) {
		if (accountMap.containsKey(id)){
			return true;
		}
		return false;
	}
	
	public double getAmountAccount(long id) {
		return accountMap.get(id).getValue();
	}
	
	public double getAmountAccountEUR(long id) throws RemoteException {
		Account account = accountMap.get(id);
		return (double) soapServer.convert("", account.getCurrency(), "EUR", account.getValue(), 
				false, ".", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
	}
	
	public String getCurrencyAccount(long id) {
		return accountMap.get(id).getCurrency();
	}
	
	public int getSize() {
		return accountMap.size();
	}

	
	
	
	

}
