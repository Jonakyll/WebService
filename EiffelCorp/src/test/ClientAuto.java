package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.uge.webServices.common.IGarage;
import fr.uge.webServices.customers.Customer;

public class ClientAuto {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IGarage garage = (IGarage) Naming.lookup("rmi://localhost:1099/garage");

		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		Customer customer3 = new Customer();

		customer1.setId(1111L);
		customer2.setId(2222L);
		customer3.setId(3333L);

		garage.addCustomer(customer1);
		garage.addCustomer(customer2);
		garage.addCustomer(customer3);

		System.out.println("==== SHOW THE CARS AVAILABLE ====");

		for (var car : garage.getCars()) {
			System.out.println("id\t\t" + car.getId());
			System.out.println("model\t\t" + car.getModel());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("tenants\t\t" + car.getTenants());
			System.out.println("nextTenant\t" + car.getNextTenantId() + "\n");
		}

		System.out.println("=============================================");
		System.out.println("===== CUSTOMER 1 RENTS A CAR (TOYOTA) =====");

		customer1.rentCar(garage, 1111L);

		System.out.println("===== SHOW THE CARS RENTED BY CUSTOMER 1 =====");
		System.out.println(customer1.getId());
		for (var car : customer1.getCars()) {
			System.out.println("" + car.getId() + ": " + car.getModel());
		}

		System.out.println("\n==== CUSTOMERS 2 AND 3 WANT TO RENT THE SAME CAR THAN CUSTOMER 1 ====");

		customer2.rentCar(garage, 1111L);
		customer3.rentCar(garage, 1111L);

		System.out.println("==== SHOW THE CARS AVAILABLE ====");

		for (var car : garage.getCars()) {
			System.out.println("id\t\t" + car.getId());
			System.out.println("model\t\t" + car.getModel());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("tenants\t\t" + car.getTenants());
			System.out.println("nextTenant\t" + car.getNextTenantId() + "\n");
		}

		System.out.println("===== SHOW THE CARS RENTED BY CUSTOMERS 2 AND 3 =====");
		System.out.println(customer2.getId());
		for (var car : customer2.getCars()) {
			System.out.println("" + car.getId() + ": " + car.getModel());
		}

		System.out.println(customer3.getId());
		for (var car : customer3.getCars()) {
			System.out.println("" + car.getId() + ": " + car.getModel());
		}

		System.out.println("===== CUSTOMER 1 RETURNS A CAR AND RATES IT =====");

		customer1.returnCar(garage, 1111L);
		customer1.rateCar(garage, 1111L, 5F);

		System.out.println("===== CUSTOMER 3 WANTS TO RENT THE TOYOTA CAR =====");

		customer3.rentCar(garage, 1111L);

		System.out.println("==== SHOW THE CARS AVAILABLE ====");

		for (var car : garage.getCars()) {
			System.out.println("id\t\t" + car.getId());
			System.out.println("model\t\t" + car.getModel());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("tenants\t\t" + car.getTenants());
			System.out.println("nextTenant\t" + car.getNextTenantId() + "\n");
		}

		System.out.println("===== SHOW THE CARS RENTED BY CUSTOMER 3 =====");
		System.out.println(customer3.getId());
		for (var car : customer3.getCars()) {
			System.out.println("" + car.getId() + ": " + car.getModel());
		}

		System.out.println("===== CUSTOMER 2 WANTS TO RENT THE TOYOTA CAR =====");

		customer2.rentCar(garage, 1111L);

		System.out.println("==== SHOW THE CARS AVAILABLE ====");

		for (var car : garage.getCars()) {
			System.out.println("id\t\t" + car.getId());
			System.out.println("model\t\t" + car.getModel());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("tenants\t\t" + car.getTenants());
			System.out.println("nextTenant\t" + car.getNextTenantId() + "\n");
		}

		System.out.println("===== SHOW THE CARS RENTED BY CUSTOMER 2 =====");
		System.out.println(customer2.getId());
		for (var car : customer2.getCars()) {
			System.out.println("" + car.getId() + ": " + car.getModel());
		}

		System.out.println("===== CUSTOMER 3 WANTS TO RENT ANOTHER CAR =====");

		customer3.rentCar(garage, 3333L);

		System.out.println("==== SHOW THE CARS AVAILABLE ====");

		for (var car : garage.getCars()) {
			System.out.println("id\t\t" + car.getId());
			System.out.println("model\t\t" + car.getModel());
			System.out.println("availability\t" + car.getAvailability());
			System.out.println("rating\t\t" + car.getRating());
			System.out.println("tenants\t\t" + car.getTenants());
			System.out.println("nextTenant\t" + car.getNextTenantId() + "\n");
		}

		System.out.println("===== SHOW THE CARS RENTED BY ALL CUSTOMERS =====");
		System.out.println(customer1.getId());
		for (var car : customer1.getCars()) {
			System.out.println("" + car.getId() + ": " + car.getModel());
		}

		System.out.println(customer2.getId());
		for (var car : customer2.getCars()) {
			System.out.println("" + car.getId() + ": " + car.getModel());
		}

		System.out.println(customer3.getId());
		for (var car : customer3.getCars()) {
			System.out.println("" + car.getId() + ": " + car.getModel());
		}
	}
}
