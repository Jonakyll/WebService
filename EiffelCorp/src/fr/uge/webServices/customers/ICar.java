package fr.uge.webServices.customers;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICar extends Remote {

	Long getId() throws RemoteException;

	boolean getState() throws RemoteException;

	float getRating() throws RemoteException;

	List<Long> getTenants() throws RemoteException;

	void setId(Long id) throws RemoteException;

	void setState(boolean located) throws RemoteException;

	void setRating(float rating) throws RemoteException;

	void setTenants(List<Long> tenants) throws RemoteException;

}
