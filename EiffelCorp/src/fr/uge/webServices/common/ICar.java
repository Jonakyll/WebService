package fr.uge.webServices.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICar extends Remote {

	Long getId() throws RemoteException;

	boolean getAvailability() throws RemoteException;

	float getRating() throws RemoteException;

	List<Long> getTenants() throws RemoteException;

	void setId(Long id) throws RemoteException;

	void setAvailability(boolean available) throws RemoteException;

	void setRating(float rating) throws RemoteException;

	void setTenants(List<Long> tenants) throws RemoteException;

}