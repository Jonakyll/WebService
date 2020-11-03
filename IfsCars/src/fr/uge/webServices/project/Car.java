package fr.uge.webServices.project;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Objects;

public class Car extends UnicastRemoteObject implements ICar {

	private Long id;
	private boolean located;
	private float rating;
	private List<Long> tenants;

	public Car() throws RemoteException {

	}

	@Override
	public Long getId() throws RemoteException {
		return id;
	}

	@Override
	public boolean getState() throws RemoteException {
		return located;
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
	public void setState(boolean located) throws RemoteException {
		this.located = located;
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
