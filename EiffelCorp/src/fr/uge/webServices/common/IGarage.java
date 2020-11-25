package fr.uge.webServices.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IGarage extends Remote {

	ICar addCar(Long customerId, String model) throws RemoteException;

	void removeCar(Long customerId, String model) throws RemoteException;

	ICar findCar(Long id) throws RemoteException;

	List<ICar> getCars() throws RemoteException;

	void rateCar(Long customerId, String model, float rating) throws RemoteException;

	List<ICar> getCarsToBuy() throws RemoteException;
	
	void addCustomer(ICustomer customer) throws RemoteException;
}
