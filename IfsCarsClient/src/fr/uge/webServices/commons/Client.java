package fr.uge.webServices.commons;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.Garage;
import fr.uge.webServices.project.GarageServiceLocator;

public class Client {
	private Garage garage;
	private int amountToPay = 0;
	private List<Car> cart = new ArrayList<Car>();

	public Client() throws ServiceException {
		this.garage = new GarageServiceLocator().getGarage();;
	}
	
	
	public Car[] getCars() throws RemoteException {
		return garage.getCars();
	}
	
	public void addToCart(int i) throws RemoteException {
		Car carToAdd = garage.getCars()[i];
		for (Car car : cart) {
			if (car.getId() == carToAdd.getId()) {
				System.out.println("--------------------------------------NANI-----------------------------------");
				return;
			}
		}
		System.out.println("--------------------------------------OOF-----------------------------------");
		cart.add(carToAdd);
		amountToPay += this.getCars()[i].getPrice();
	}


	public int getAmountToPay() {
		return amountToPay;
	}
	
	public List<Car> getCart() {
		return cart;
	}
	
	
}
