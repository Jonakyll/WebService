package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import fr.uge.webServices.common.IGarage;
import fr.uge.webServices.customers.Customer;
import fr.uge.webServices.customers.RequestsParser;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		if (args.length != 1) {
			System.err.println("customer id missing");
			return;
		}
		System.out.println(Long.parseLong(args[0]));

		IGarage garage = (IGarage) Naming.lookup("rmi://localhost:1099/garage");
		Customer customer = new Customer();

		customer.setId(Long.parseLong(args[0]));
		garage.addCustomer(customer);

		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			String request = scan.nextLine();
			
			RequestsParser.parseRequest(garage, customer, request);
		}
	}

}
