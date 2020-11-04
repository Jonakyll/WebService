package fr.uge.webServices.project;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Objects;

public class Car extends UnicastRemoteObject implements ICar {

	private Long id;
	private boolean available;
	private float rating;
	private List<Long> tenants;

	public Car() throws RemoteException {

	}

	@Override
	public Long getId() throws RemoteException {
		return id;
	}

	@Override
	public boolean getAvailability() throws RemoteException {
		return available;
	}

	@Override
	public float getRating() throws RemoteException {
		return rating;
	}

	@Override
	public List<Long> getTenants() throws RemoteException {
		return List.copyOf(tenants);
	}

	@Override
	public void setId(Long id) throws RemoteException {
		this.id = id;
	}

	@Override
	public void setAvailability(boolean available) throws RemoteException {
		this.available = available;
	}

	@Override
	public void setRating(float rating) throws RemoteException {
		this.rating = rating;
	}

	@Override
	public void setTenants(List<Long> tenants) throws RemoteException {
		Objects.requireNonNull(tenants);
		this.tenants = List.copyOf(tenants);
	}

}
