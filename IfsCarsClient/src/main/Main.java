package main;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uge.webServices.commons.Client;
import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.Garage;
import fr.uge.webServices.project.GarageServiceLocator;

public class Main {

	public static void main(String[] args) throws ServiceException, RemoteException {
		Client client = new Client();
		Garage garage = new GarageServiceLocator().getGarage();

		client.checkAccount(3L);
		
		System.out.println("==== SHOW CARS TO BUY =====");
		Car[] cars = client.getCars();
		for (int i = 0; i < cars.length; ++i) {
			System.out.println("id\t\t" + cars[i].getId());
			System.out.println("availability\t" + cars[i].isAvailability());
			System.out.println("price\t\t" + cars[i].getPrice() + "\n");
		}

		System.out.println("\n===== SHOW CLIENT CART =====");
		System.out.println("cart:");
		for (Car car : client.getCart()) {
			System.out.println("\tid: " + car.getId());
		}
		System.out.println("amount to pay:\t" + client.getAmountToPay());

		System.out.println("\n===== THE CLIENT ADDS CARS TO HIS CART=====");
		client.addToCart(0);
		client.addToCart(1);
		client.addToCart(2);
		client.addToCart(3);

		System.out.println("===== SHOW CLIENT CART =====");
		System.out.println("cart:");
		for (Car car : client.getCart()) {
			System.out.println("\tid: " + car.getId());
		}
		System.out.println("amount to pay (in EUR):\t" + client.getAmountToPay());
		
		System.out.println("===== THE CLIENT PAYS =====");
		if (client.buy()) {
			System.out.println("===== CARS PAID =====");
		} else {
			System.out.println("===== THE CLIENT COULDN'T PAY =====");			
		}
		
		
	}
}
