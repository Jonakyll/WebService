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
	public ICar addCar(Long customerId, Long carId) throws RemoteException {
		Objects.requireNonNull(carId);

		ICar car = cars.get(carId);

		if (car != null) {
			if (car.getAvailability() && (car.getTenants().isEmpty() || customerId.equals(car.getNextTenantId()))) {

//					make the customer rent the car
				car.setAvailability(false);
				car.setNextTenantId(null);

				return car;
			} else {

//					put the customer into the waiting list
				if (!car.getTenants().contains(customerId)) {
					car.addTenant(customerId);
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public void removeCar(Long customerId, Long carId) throws RemoteException {
		Objects.requireNonNull(carId);

		ICar car = cars.get(carId);

		if (car != null) {
			car.removeTenant();

			// ask to the client to rate the car
			// ask to the next client if he wants to rent?

			car.setAvailability(true);
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
	public void rateCar(Long customerId, Long carId, float rating) throws RemoteException {
		Objects.requireNonNull(carId);

		ICar car = cars.get(carId);
		if (car != null) {
			car.setRating(rating);
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
