package fr.uge.webServices.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Queue;

/**
 * 
 * @author Jonathan CHU Interface for remote objects that represent cars that
 *         can be located.
 *
 */
public interface ICar extends Remote {

	Long getId() throws RemoteException;

	boolean getAvailability() throws RemoteException;

	float getRating() throws RemoteException;

	Queue<Long> getTenants() throws RemoteException;

	void setId(Long id) throws RemoteException;

	void setAvailability(boolean available) throws RemoteException;

	void setRating(float rating) throws RemoteException;

	void addTenant(Long customerId) throws RemoteException;

	void removeTenant() throws RemoteException;

	Long getNextTenantId() throws RemoteException;

	Long getPrice() throws RemoteException;

	void setPrice(Long price) throws RemoteException;

	void setNextTenantId(Long customerId) throws RemoteException;
	
	String getModel() throws RemoteException;
	
	void setModel(String model) throws RemoteException;

}
