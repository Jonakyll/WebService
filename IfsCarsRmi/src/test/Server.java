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
		car.setprice(10_000L);

		ICar car2 = new Car();
		car2.setId(2222L);
		car2.setAvailability(true);
		car2.setprice(20_000L);
		
		ICar car3 = new Car();
		car3.setId(3333L);
		car3.setAvailability(true);
		car3.setprice(30_000L);
		
		ICar car4 = new Car();
		car4.setId(4444L);
		car4.setAvailability(true);
		car4.setprice(40_000L);
		
		IGarage garage = new Garage();
		((Garage) garage).addCarToRent(car);
		((Garage) garage).addCarToRent(car2);
		((Garage) garage).addCarToRent(car3);
		((Garage) garage).addCarToRent(car4);

		Naming.rebind("rmi://localhost:1099/garage", garage);
		System.out.println("server launched!");
	}

}
