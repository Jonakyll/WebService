package fr.uge.webServices.project;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 
 * @author Jonathan CHU
 * Interface for remote objects that represent cars that
 * can be located.
 *
 */
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
