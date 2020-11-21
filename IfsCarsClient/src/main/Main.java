package main;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.Garage;
import fr.uge.webServices.project.GarageServiceLocator;

public class Main {

	public static void main(String[] args) throws ServiceException, RemoteException {
//		IGarage iGarage = (IGarage) Naming.lookup("rmi://localhost:1099/garage");
		Garage garage = new GarageServiceLocator().getGarage();

//		for (ICar c : iGarage.getCars()) {
//
//			Car car = new Car();
//			car.setId(c.getId());
//			car.setAvailability(c.getAvailability());
//			car.setPrice(c.getPrice());
//			garage.addCar(car);
//			
//		}

//		garage.getPrice(car);
//		garage.getAvailability(car);
//		garage.addToCart();
//		garage.buy();
		Car[] cars = garage.getCars();
		for (int i = 0; i < cars.length; ++i) {
			System.out.println("id\t\t" + cars[i].getId());
			System.out.println("availability\t" + cars[i].isAvailability());
			System.out.println("price\t\t" + cars[i].getPrice() + "\n");
		}

		// pour checker que les appels aux methodes rmi fonctionnent bien

		// =========================================================

//		garage.setCarsToBuy(iGarage.getCarsToBuy());

	}
}
