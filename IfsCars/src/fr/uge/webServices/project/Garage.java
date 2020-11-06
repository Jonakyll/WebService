package fr.uge.webServices.project;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
	public void addCar(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		cars.put(car.getId(), car);
	}

	@Override
	public void removeCar(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		cars.remove(car.getId());
	}

	@Override
	public ICar findCar(Long id) throws RemoteException {
		return cars.get(id);
	}

	@Override
	public List<ICar> getCars() throws RemoteException {
		return cars.values().stream().collect(Collectors.toList());
	}

}
