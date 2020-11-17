package fr.uge.webServices.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Garage {

	private Map<Long, Car> cars = new HashMap<Long, Car>();

	public Long getPrice(Car car) {
		Objects.requireNonNull(car);
		System.out.println("get price");
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
		System.out.println("get availability");
		Car c = cars.get(car.getId());
		if (c != null) {
			return c.getAvailability();
		} else {
			System.out.println("\tcar not found");
			return false;
		}
	}

	public void addToCart() {
		System.out.println("add to card");
	}

	public void buy() {
		System.out.println("buy");
	}

	public void addCar(Car car) {
		Objects.requireNonNull(car);
		System.out.println("add car");
		cars.put(car.getId(), car);
	}

	public void showCars() {
		System.out.println("show cars");
		for (Car car : cars.values()) {
			System.out.println(car);
		}
	}

}
