package fr.uge.webServices.project;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import fr.uge.webServices.common.ICar;
import fr.uge.webServices.common.IGarage;

public class Garage extends UnicastRemoteObject implements IGarage {

	private Map<Long, ICar> cars = new HashMap<Long, ICar>();

	public Garage() throws RemoteException {
	}

	@Override
	public boolean addCar(Long custommerId, ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		ICar c = cars.get(car.getId());
		if (c.getAvailability()) {

//			make the customer rent the car
			c.setAvailability(false);
			return true;
		} else {

//			put the customer into the waiting list
			List<Long> tenants = new ArrayList<Long>(c.getTenants());
			if (!tenants.contains(custommerId)) {
				tenants.add(custommerId);
				c.setTenants(tenants);
			}
			return false;
		}
	}

	@Override
	public void removeCar(Long customerId, ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		ICar c = cars.get(car.getId());
		List<Long> tenants = new ArrayList<Long>(c.getTenants());
		tenants.remove(customerId);
		c.setTenants(tenants);
		c.setAvailability(true);
	}

	@Override
	public ICar findCar(Long id) throws RemoteException {
		return cars.get(id);
	}

	@Override
	public List<ICar> getCars() throws RemoteException {
		return cars.values().stream().collect(Collectors.toList());
	}

	public void addCarToRent(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		cars.put(car.getId(), car);
	}

}
