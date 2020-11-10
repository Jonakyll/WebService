package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.uge.webServices.common.IGarage;
import fr.uge.webServices.customers.Customer;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IGarage garage = (IGarage) Naming.lookup("rmi://localhost:1099/garage");

		Customer customer1 = new Customer();
		Customer customer2 = new Customer();

		customer1.setId(1111L);
		customer2.setId(2222L);

		System.out.println("==== RENT ====");

		customer1.rentCar(garage, garage.getCars().get(0));
		customer1.rentCar(garage, garage.getCars().get(1));

		for (var car : garage.getCars()) {
			System.out.println("car\t\t" + car);
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("id\t\t" + car.getId());
			System.out.println("tenants\t\t" + car.getTenants() + "\n");
		}

		System.out.println(customer1);
		for (var car : customer1.getCars()) {
			System.out.println(car);
		}

		System.out.println("\n" + customer2);
		for (var car : customer2.getCars()) {
			System.out.println(car);
		}
		
		System.out.println("\n==== RETURN ====");

		customer1.returnCar(garage, garage.getCars().get(0));
		customer2.returnCar(garage, garage.getCars().get(0));

		for (var car : garage.getCars()) {
			System.out.println("car\t\t" + car);
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("id\t\t" + car.getId());
			System.out.println("tenants\t\t" + car.getTenants() + "\n");
		}

		System.out.println(customer1);
		for (var car : customer1.getCars()) {
			System.out.println(car);
		}

		System.out.println("\n" + customer2);
		for (var car : customer2.getCars()) {
			System.out.println(car);
		}
		
	}

}
