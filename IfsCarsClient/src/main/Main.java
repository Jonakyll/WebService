package main;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.Garage;
import fr.uge.webServices.project.GarageServiceLocator;

public class Main {

	public static void main(String[] args) throws ServiceException, RemoteException {
		Garage garage = new GarageServiceLocator().getGarage();
		Car car = new Car();
		
		car.setId(1111L);
		car.setAvailability(true);
		car.setPrice(60_000L);
		
		garage.addCar(car);
		garage.getPrice(car);
		garage.getAvailability(car);
		garage.addToCart();
		garage.buy();
		garage.showCars();
	}
}
