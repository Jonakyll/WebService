package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import fr.uge.webServices.common.ICar;
import fr.uge.webServices.common.IGarage;
import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.Garage;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099);

		ICar car = new Car();
		car.setId(1111L);
		car.setAvailability(true);

		ICar anotherCar = new Car();
		anotherCar.setId(4444L);
		anotherCar.setAvailability(true);
		
		IGarage garage = new Garage();
		((Garage) garage).addCarToRent(car);
		((Garage) garage).addCarToRent(anotherCar);

		Naming.rebind("rmi://localhost:1099/garage", garage);
		System.out.println("server launched!");
	}

}
