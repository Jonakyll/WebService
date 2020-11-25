package fr.uge.webServices.project;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import fr.uge.webServices.common.ICar;
import fr.uge.webServices.common.ICustomer;
import fr.uge.webServices.common.IGarage;

public class Garage extends UnicastRemoteObject implements IGarage {

	private Map<Long, ICar> cars = new HashMap<Long, ICar>();
	private Map<Long, ICustomer> customers = new HashMap<Long, ICustomer>();

	public Garage() throws RemoteException {
	}

	@Override
	public boolean addCar(Long customerId, ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		ICar c = cars.get(car.getId());
		ICustomer customer = customers.get(customerId);
		customer.notify("RENT CAR");

		if (c != null) {
			if (c.getAvailability() && (c.getTenants().isEmpty() || customerId.equals(c.getNextTenantId()))) {

//			make the customer rent the car
				c.setAvailability(false);
				c.setNextTenantId(null);
				return true;
			} else {

//			put the customer into the waiting list
				if (!c.getTenants().contains(customerId)) {
					c.addTenant(customerId);
				}
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public void removeCar(Long customerId, ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		ICar c = cars.get(car.getId());
		ICustomer customer = customers.get(customerId);
		customer.notify("RETURN CAR");

		if (c != null) {

//		?
			c.removeTenant();

			// ask to the client to rate the car
			// ask to the next client if he wants to rent?

			c.setAvailability(true);
		}
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

	@Override
	public void rateCar(Long customerId, ICar car, float rating) throws RemoteException {
		Objects.requireNonNull(car);
		ICar c = cars.get(car.getId());
		ICustomer customer = customers.get(customerId);
		customer.notify("RATE CAR");

		if (c != null) {
			c.setRating(rating);
		}
	}

	@Override
	public List<ICar> getCarsToBuy() throws RemoteException {
		return cars.values().stream().filter(car -> {
			try {
				return car.getRating() != -1L;
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
	}

	@Override
	public void addCustomer(ICustomer customer) throws RemoteException {
		Objects.requireNonNull(customer);
		customers.put(customer.getId(), customer);
	}

}
