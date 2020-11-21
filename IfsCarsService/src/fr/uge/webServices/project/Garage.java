package fr.uge.webServices.project;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import fr.uge.webServices.common.ICar;
import fr.uge.webServices.common.IGarage;

public class Garage {

	private Map<Long, Car> cars = new HashMap<Long, Car>();

	public Garage() {
		try {
			IGarage iGarage = (IGarage) Naming.lookup("rmi://localhost:1099/garage");
			for (ICar c : iGarage.getCarsToBuy()) {
				Car car = new Car();
				car.setId(c.getId());
				car.setAvailability(c.getAvailability());
				car.setPrice(c.getPrice());
				this.addCar(car);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Long getPrice(Car car) {
		Objects.requireNonNull(car);
		Car c = cars.get(car.getId());
		if (c != null) {
			return c.getPrice();
		} else {
			System.out.println("\tcar not found");
			return 0L;
		}
	}

	public boolean getAvailability(Car car) {
		Objects.requireNonNull(car);
		Car c = cars.get(car.getId());
		if (c != null) {
			return c.getAvailability();
		} else {
			System.out.println("\tcar not found");
			return false;
		}
	}

	public void addToCart() {
	}

	public void buy() {
	}

	public void addCar(Car car) {
		Objects.requireNonNull(car);
		cars.put(car.getId(), car);
	}

	public Car[] getCars() {
		List<Car> res = new ArrayList<Car>();
		for (Car car : cars.values()) {
			res.add(car);
		}
		Car[] cars = new Car[res.size()];
		for (int i = 0; i < res.size(); ++i) {
			cars[i] = res.get(i);
		}
		return cars;
	}

}
