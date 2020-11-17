package fr.uge.webServices.project;

public class Car {

	private Long id;
	private Long price;
	private boolean available;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public boolean getAvailability() {
		return available;
	}

	public void setAvailability(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "\t" + id + "\n\t" + price + "\n\t" + available;
	}
}
