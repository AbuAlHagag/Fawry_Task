package classes;

import java.time.LocalDate;

public class Mobile extends Product{

	public Mobile(String name, double price, int quantity) {
		super(name, price, quantity);
		this.weight = 0;
		this.shippable = false;
		this.expire_date = LocalDate.of(1,1,1);
		this.expirable = false;
	}
	
}
