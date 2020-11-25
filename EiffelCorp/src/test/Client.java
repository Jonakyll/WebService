package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.uge.webServices.common.IGarage;
import fr.uge.webServices.customers.Customer;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		if (args.length != 1) {
			System.err.println("customer id missing");
			return;
		}
		IGarage garage = (IGarage) Naming.lookup("rmi://localhost:1099/garage");

		Customer customer = new Customer();

		customer.setId(Long.parseLong(args[0]));

		garage.addCustomer(customer);

		System.out.println("==== 1 ====");

		customer.rentCar(garage, garage.getCars().get(0));

		for (var car : garage.getCars()) {
			System.out.println("car\t\t" + car);
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("id\t\t" + car.getId());
			System.out.println("tenants\t\t" + car.getTenants());
			System.out.println("nextTenant\t" + car.getNextTenantId() + "\n");
		}

		System.out.println(customer.getId());
		for (var car : customer.getCars()) {
			System.out.println(car);
		}

		System.out.println("\n==== 2 ====");

		customer.returnCar(garage, garage.getCars().get(0));

		customer.rateCar(garage, garage.getCars().get(0), 3F);
		customer.rateCar(garage, garage.getCars().get(0), 5F);
		customer.rateCar(garage, garage.getCars().get(0), 4F);

		for (var car : garage.getCars()) {
			System.out.println("car\t\t" + car);
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("id\t\t" + car.getId());
			System.out.println("tenants\t\t" + car.getTenants());
			System.out.println("nextTenant\t" + car.getNextTenantId() + "\n");
		}

		System.out.println(customer.getId());
		for (var car : customer.getCars()) {
			System.out.println(car);
		}

		System.out.println("\n==== 3 ====");

		customer.rentCar(garage, garage.getCars().get(0));

		for (var car : garage.getCars()) {
			System.out.println("car\t\t" + car);
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("id\t\t" + car.getId());
			System.out.println("tenants\t\t" + car.getTenants());
			System.out.println("nextTenant\t" + car.getNextTenantId() + "\n");
		}

		System.out.println(customer.getId());
		for (var car : customer.getCars()) {
			System.out.println(car);
		}

		System.out.println("\n=====CARS TO BUY =====");
		for (var car : garage.getCarsToBuy()) {
			System.out.println(car.getId());
		}

	}

}
