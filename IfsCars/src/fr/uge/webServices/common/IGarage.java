package fr.uge.webServices.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IGarage extends Remote {

	boolean addCar(Long customerId, ICar car) throws RemoteException;

	void removeCar(Long customerId, ICar car) throws RemoteException;

	ICar findCar(Long id) throws RemoteException;
	
	List<ICar> getCars() throws RemoteException;

}
