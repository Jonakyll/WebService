package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.uge.webServices.common.IGarage;

public class Client {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IGarage garage = (IGarage) Naming.lookup("rmi://localhost:1099/garage");

		for (var car : garage.getCars()) {
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("id\t\t" + car.getId());
			System.out.println("tenants\t\t" + car.getTenants() + "\n");
		}
	}

}
