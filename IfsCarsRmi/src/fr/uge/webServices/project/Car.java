package fr.uge.webServices.project;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import fr.uge.webServices.common.ICar;

public class Car extends UnicastRemoteObject implements ICar {

	private Long id;
	private boolean available;
	private List<Float> rating = new ArrayList<Float>();
	private Queue<Long> tenants = new ArrayBlockingQueue<Long>(10);

	private Long nextTenant;
	private Long price;

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
		return rating.isEmpty() ? -1L : rating.stream().reduce(0F, Float::sum) / rating.size();
	}

	@Override
	public Queue<Long> getTenants() throws RemoteException {
		return new LinkedList<Long>(tenants);
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
		if (rating < 0 || rating > 5) {
			throw new IllegalArgumentException();
		}
		this.rating.add(rating);
	}

	@Override
	public void addTenant(Long customerId) throws RemoteException {
		this.tenants.offer(customerId);
	}

	@Override
	public void removeTenant() throws RemoteException {
		this.nextTenant = this.tenants.poll();
	}

	@Override
	public Long getNextTenantId() throws RemoteException {
		return nextTenant;
	}

	@Override
	public Long getPrice() throws RemoteException {
		return price;
	}

	@Override
	public void setPrice(Long price) throws RemoteException {
		this.price = price;
	}

	@Override
	public void setNextTenantId(Long customerId) throws RemoteException {
		this.nextTenant = customerId;
	}

}
