package classes;

import java.time.LocalDate;

public class Biscuit extends Product {

	public Biscuit(String name, double price, int quantity, double weight,LocalDate expire_date) {
		super(name, price, quantity, weight);
		this.weight = weight;
		this.shippable = true;
		this.expire_date = expire_date;
		this.expirable = true;
	}
}
