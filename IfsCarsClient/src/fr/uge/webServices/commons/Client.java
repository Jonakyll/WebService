package fr.uge.webServices.commons;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.Garage;
import fr.uge.webServices.project.GarageServiceLocator;

public class Client {
	private Garage garage;
	private int amountToPay = 0;

	public Client() throws ServiceException {
		this.garage = new GarageServiceLocator().getGarage();;
	}
	
	
	public Car[] getCars() throws RemoteException {
		return garage.getCars();
	}
	
	public void addToBucket(int i) throws RemoteException {
		amountToPay += this.getCars()[i].getPrice();
	}


	public int getAmountToPay() {
		return amountToPay;
	}
	
	
}
