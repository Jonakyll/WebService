package fr.uge.webServices.customers;

import java.util.List;
import java.util.Objects;

public class Customer {
	private Long id;
	private List<ICar> cars;
	
	public void rentCar(ICar car) {
		Objects.requireNonNull(car);
		cars.add(car);
	}
	
	public void returnCar(ICar car) {
		Objects.requireNonNull(car);
		cars.remove(car);
	}

}
