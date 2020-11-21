package fr.uge.webServices.project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Car {

	private Long id;
	private boolean available;
	private List<Float> rating = new ArrayList<Float>();
	private Queue<Long> tenants = new ArrayBlockingQueue<Long>(10);

	private Long nextTenant;
	private Long price;

	public Long getId() {
		return id;
	}

	public boolean getAvailability() {
		return available;
	}

	public float getRating() {
		return rating.isEmpty() ? -1L : rating.stream().reduce(0F, Float::sum) / rating.size();
	}

	public Long[] getTenants() {
		List<Long> res = new ArrayList<Long>();
		tenants.forEach(l -> res.add(l));
		Long[] cars = new Long[res.size()];
		for (int i = 0; i < res.size(); ++i) {
			cars[i] = res.get(i);
		}
		return cars;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAvailability(boolean available) {
		this.available = available;
	}

	public void setRating(float rating) {
		if (rating < 0 || rating > 5) {
			throw new IllegalArgumentException();
		}
		this.rating.add(rating);
	}

	public void addTenant(Long customerId) {
		this.tenants.offer(customerId);
	}

	public void removeTenant() {
		this.nextTenant = this.tenants.poll();
	}

	public Long getNextTenantId() {
		return nextTenant;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setNextTenantId(Long customerId) {
		this.nextTenant = customerId;
	}

}
