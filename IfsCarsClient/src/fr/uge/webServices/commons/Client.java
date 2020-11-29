package fr.uge.webServices.commons;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.rpc.ServiceException;

import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.Garage;
import fr.uge.webServices.project.GarageServiceLocator;

public class Client {
	private Garage garage;
	private int amountToPay = 0;
	private List<Car> cart = new ArrayList<Car>();
	private long account_id =-1;

	public Client() throws ServiceException {
		this.garage = new GarageServiceLocator().getGarage();
	}
	
	public Client(long account_id) throws ServiceException {
		this.garage = new GarageServiceLocator().getGarage();
		this.account_id = account_id;
	}
	
	
	public Car[] getCars() throws RemoteException {
		return garage.getCars();
	}
	
	
	public void cleanCart() {
		amountToPay = 0;
		cart = new ArrayList<Car>();
	}
	
	public void addToCart(int i) throws RemoteException {
		Car carToAdd = garage.getCars()[i];
		for (Car car : cart) {
			if (car.getId().equals(carToAdd.getId())) {
				return;
			}
		}
		cart.add(carToAdd);
		amountToPay += this.getCars()[i].getPrice();
	}


	public int getAmountToPay() {
		return amountToPay;
	}
	
	public List<Car> getCart() {
		return cart;
	}


	public boolean checkAccount(long id) throws RemoteException {
		if( garage.checkAccount(id)) {
			account_id = id;
			return true;
		}
		return false;
	}
	
	public double getAmountAccount() throws RemoteException {
		return garage.getAmountAccount(account_id);
	}
	
	public double getAmountAccountEUR() throws RemoteException {
		return garage.getAmountAccountEUR(account_id);
	}
	
	public String getCurrencyAccount() throws RemoteException {
		if ( account_id == -1) {
			return null;
		}
		return garage.getCurrencyAccount(account_id);
	}


	public long getAccount_id() {
		return account_id;
	}


	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	
	public void depositOf(double amount) throws RemoteException {
		if ( account_id == -1) {
			System.out.println("Impossible de faire un dépôt sur un compte non valide");
			return ;
		}else {
			garage.depositOf(account_id, amount);
		}
	}
	
	public boolean createAccount(String currency) throws RemoteException {
		long res = garage.createBankAccount(currency);
		if (res==-1) {
			return false;
		}
		account_id = res;
		return true;
	}
	
	public boolean buy() throws RemoteException {
		Car[] cars = new Car[cart.size()];
		for (int i=0; i<cart.size();i++) {
			cars[i] = cart.get(i);
		}
		boolean test = garage.buy(account_id, cars, amountToPay);
		if (test) {
			cleanCart();
			return true;
		}
		return false;
	}
	
	public int bankSize() throws RemoteException {
		return garage.bankSize();
	}
	
	
}
