package fr.uge.webServices.customers;

import java.rmi.RemoteException;

import fr.uge.webServices.common.IGarage;

public class RequestsParser {

	public static void parseRequest(IGarage garage, Customer customer, String request) throws RemoteException {
		String[] tokens = request.split(" ");

		switch (tokens[0]) {
		case "@rent":
			if (tokens.length == 2) {
				customer.rentCar(garage, Long.parseLong(tokens[1]));
			}
			return;
		case "@return":
			if (tokens.length == 2) {
				customer.returnCar(garage, Long.parseLong(tokens[1]));
			}
			return;
		case "@rate":
			if (tokens.length == 3) {
				customer.rateCar(garage, Long.parseLong(tokens[1]), Float.parseFloat(tokens[2]));
			}
			return;
		case "@info":
			for (var car : customer.getCars()) {
				System.out.println("" + car.getId() + ": " + car.getModel());
			}
			return;
		case "@garage":
			for (var car : garage.getCars()) {
				System.out.println("id\t\t" + car.getId());
				System.out.println("model\t\t" + car.getModel());
				System.out.println("availability\t" + car.getAvailability());
				System.out.println("rating\t\t" + car.getRating());
				System.out.println("tenants\t\t" + car.getTenants());
				System.out.println("nextTenant\t" + car.getNextTenantId() + "\n");
			}
			return;
		default: {
			return;
		}
		}
	}

}
