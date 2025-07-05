package classes;

import java.time.LocalDate;

public class ScratchCard extends Product {
	
	public ScratchCard(String name, double price, int quantity, LocalDate expire_date) {
		super(name, price, quantity);
		this.weight = 0;
		this.shippable = false;
		this.expire_date = expire_date;
		this.expirable = true;
	}
	
}
