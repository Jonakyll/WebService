package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

import fr.uge.webServices.common.ICar;
import fr.uge.webServices.common.IGarage;
import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.Garage;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099);

		ICar car = new Car();
		car.setId(1234L);
		car.setRating(4.5F);
		car.setAvailability(true);
		car.setTenants(List.of(2222L, 3333L));

		ICar anotherCar = new Car();
		anotherCar.setId(5678L);
		anotherCar.setRating(5.F);
		anotherCar.setAvailability(true);
		anotherCar.setTenants(List.of());
		
		IGarage garage = new Garage();
		garage.addCar(car);
		garage.addCar(anotherCar);

		Naming.rebind("rmi://localhost:1099/garage", garage);
		System.out.println("server launched!");
	}

}
