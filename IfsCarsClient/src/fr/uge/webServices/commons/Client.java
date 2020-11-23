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

	public Client() throws ServiceException {
		this.garage = new GarageServiceLocator().getGarage();
	}
	
	
	public Car[] getCars() throws RemoteException {
//		List<Car> cars = Arrays.asList(garage.getCars());
//		List<Car> res = new ArrayList<Car>();
//		for (Car car : cars) {
//			if (!containsVehicle(car.getId())) {
//				res.add(car);
//			}
//		}
//		return res.toArray(new Car[0]);
		return garage.getCars();
	}
	
	private boolean containsVehicle(long id) {
		for (Car car : cart) {
			if (car.getId().equals(id)) {
				return true;
			}
		}
		return false;
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
	
	
}
