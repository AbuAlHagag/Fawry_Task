package classes;

import java.time.LocalDate;

public abstract class Product implements MainProductInterface, Comparable<Product> {

	private String name;
	private double price;
	protected int inventory_quantity;
	protected double weight;
	protected boolean shippable; 
	protected LocalDate expire_date;
	protected boolean expirable; 
	
	@Override
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}


	public int getInventoryQuantity() {
		return inventory_quantity;
	}

	@Override
	public double getWeight() {
		return weight;
	}
	
	public boolean isShippable() {
		return shippable;
	}
	
	public LocalDate getExpire_date() {
		return expire_date;
	}
	
	public boolean isExpirable() {
		return expirable;
	}
	
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.inventory_quantity = quantity;
		this.weight = 0;
		this.shippable = false;
		this.expire_date = LocalDate.of(1,1,1);
	}
	
	public Product(String name, double price, int quantity, double weight) {
		this.name = name;
		this.price = price;
		this.inventory_quantity = quantity;
		this.weight = weight;
		this.shippable = true;
		this.expire_date = LocalDate.of(1,1,1);
	}
	
	
	//for sorting and searching
	@Override
    public int compareTo(Product other) {
        return this.getName().compareTo(other.getName());
    }
	
	@Override
	public String toString() {
		return "Item " + name + " price: " + price + " quantity: " + inventory_quantity;
	
	}

}
