package classes;

import java.time.LocalDate;

public class TV extends Product {
	
	public TV(String name, double price, int quantity, double weight) {
		super(name, price, quantity, weight);
		this.weight = weight;
		this.shippable = true;
		this.expire_date = LocalDate.of(1, 1, 1);
		this.expirable = false;
	}

}
