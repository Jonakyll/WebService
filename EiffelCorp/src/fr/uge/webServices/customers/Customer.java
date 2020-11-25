package fr.uge.webServices.customers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.uge.webServices.common.ICar;
import fr.uge.webServices.common.ICustomer;
import fr.uge.webServices.common.IGarage;

public class Customer extends UnicastRemoteObject implements ICustomer {
	
	private Long id;
	private List<ICar> cars = new ArrayList<ICar>();

	public Customer() throws RemoteException {

	}

	public void rentCar(IGarage garage, String model) throws RemoteException {
		Objects.requireNonNull(garage);
		Objects.requireNonNull(model);
		
		ICar car = garage.addCar(id, model);
		if (car != null) {
			cars.add(car);
		}
	}

	public void returnCar(IGarage garage, String model) throws RemoteException {
		Objects.requireNonNull(garage);
		Objects.requireNonNull(model);
		garage.removeCar(id, model);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ICar> getCars() {
		return cars;
	}

	public void setCars(List<ICar> cars) {
		this.cars = cars;
	}

	public void rateCar(IGarage garage, String model, float rating) throws RemoteException {
		Objects.requireNonNull(garage);
		Objects.requireNonNull(model);
		garage.rateCar(id, model, rating);
	}

	@Override
	public void notify(String msg) {
		System.out.println(msg);
	}
}
