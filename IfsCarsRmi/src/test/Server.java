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
		car.setPrice(10_000L);
		car.setRating(1);
		car.setModel("toyota");

		ICar car2 = new Car();
		car2.setId(2222L);
		car2.setAvailability(true);
		car2.setPrice(20_000L);
		car2.setRating(2);
		car2.setModel("porsche");

		ICar car3 = new Car();
		car3.setId(3333L);
		car3.setAvailability(true);
		car3.setPrice(30_000L);
		car3.setRating(3);
		car3.setModel("tesla");

		ICar car4 = new Car();
		car4.setId(4444L);
		car4.setAvailability(true);
		car4.setPrice(40_000L);
		car4.setModel("hyundai");
		
		ICar car5 = new Car();
		car5.setId(5555L);
		car5.setAvailability(true);
		car5.setPrice(5_000L);
		car5.setRating(3.5F);
		car5.setModel("audi");
		
		ICar car6 = new Car();
		car6.setId(6666L);
		car6.setAvailability(true);
		car6.setPrice(2_500L);
		car6.setModel("renault");
		
		ICar car7 = new Car();
		car7.setId(7777L);
		car7.setAvailability(true);
		car7.setPrice(7_500L);
		car7.setRating(4);
		car7.setModel("bmw");
		
		ICar car8 = new Car();
		car8.setId(8888L);
		car8.setAvailability(true);
		car8.setPrice(9_0000L);
		car8.setRating(4.3F);
		car8.setModel("mercedes");
		
		ICar car9 = new Car();
		car9.setId(9999L);
		car9.setAvailability(true);
		car9.setPrice(10_000L);
		car9.setRating(2.9F);
		car9.setModel("nissan");
		
		ICar car10 = new Car();
		car10.setId(1010L);
		car10.setAvailability(true);
		car10.setPrice(3_000L);
		car10.setModel("peugeot");

		IGarage garage = new Garage();
		((Garage) garage).addCarToRent(car);
		((Garage) garage).addCarToRent(car2);
		((Garage) garage).addCarToRent(car3);
		((Garage) garage).addCarToRent(car4);
		((Garage) garage).addCarToRent(car5);
		((Garage) garage).addCarToRent(car6);
		((Garage) garage).addCarToRent(car7);
		((Garage) garage).addCarToRent(car8);
		((Garage) garage).addCarToRent(car8);
		((Garage) garage).addCarToRent(car9);
		((Garage) garage).addCarToRent(car10);


		Naming.rebind("rmi://localhost:1099/garage", garage);
		System.out.println("server launched!");
	}

}
