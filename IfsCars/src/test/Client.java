package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.uge.webServices.project.ICar;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		ICar car = (ICar) Naming.lookup("rmi://localhost:1099/car");

		System.out.println(car.getRating());
		System.out.println(car.getState());
		System.out.println(car.getId());
		System.out.println(car.getTenants());

	}

}
