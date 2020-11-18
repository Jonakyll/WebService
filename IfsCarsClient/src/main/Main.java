package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uge.webServices.common.ICar;
import fr.uge.webServices.common.IGarage;
import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.Garage;
import fr.uge.webServices.project.GarageServiceLocator;

public class Main {

	public static void main(String[] args) throws ServiceException, RemoteException, MalformedURLException, NotBoundException {
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
		
		//pour checker que les appels aux methodes rmi fonctionnent bien
		
		IGarage iGarage = (IGarage) Naming.lookup("rmi://localhost:1099/garage");
		for (ICar c : iGarage.getCars()) {
			System.out.println("car\t\t" + c);
			System.out.println("rating\t\t" + c.getRating());
			System.out.println("availability\t" + c.getAvailability());
			System.out.println("id\t\t" + c.getId());
			System.out.println("tenants\t\t" + c.getTenants());
			System.out.println("nextTenant\t" + c.getNextTenantId() + "\n");
		}
		
		//=========================================================
		
//		garage.setCarsToBuy(iGarage.getCarsToBuy());

	}
}
