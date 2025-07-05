package classes;

import java.util.ArrayList;
import java.time.LocalDate;
//import java.time.Period;

public class Cart {
	
	private String customer_name;
	private String customer_address;
	private double customer_balance;
	private double subtotal;
	private double total_cost;
	private double weight_total;
	private boolean shippable; 
	private double shipping_cost;
	private boolean error = false; 
	private ArrayList<Pair<Product, Integer>> items;
	
	public double getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public double getWeight_total() {
		return weight_total;
	}
	
	public double getTotal_cost() {
		return total_cost;
	}
	
	public boolean IsShippable() {
		return shippable;
	}

	public double getShipping_cost() {
		return shipping_cost;
	}
	
	public Cart() {
		items = new ArrayList<Pair<Product, Integer>>();
		this.shippable = false;
		this.shipping_cost = 0;
	}
	
	public void add(Product product, int quantity) {
		if(!Inventory.CheckItem(product)) {
			error = true;
			System.out.println(product.getName() + " is not in the inventory");
		}
		
		if(quantity == 0) {
			error = true;
			System.out.println("can't order 0 quantity of " + product.getName());
		}
		
		if(quantity < 0) {
			error = true;
			System.out.println("can't order a negative quantity of " + product.getName());
		}
		
		items.add(new Pair<Product, Integer>(product, quantity));
	}
	
	public void checkout(String customer_name, String customer_address, double customer_balance) {
		
		this.customer_name = customer_name;
		this.customer_address = customer_address;
		this.customer_balance = customer_balance;
		
		//check the inventory
		if(error) {
			return;
		}
		
		if(items.isEmpty()) {
			System.out.println("Your cart is Empty!");
			return;
		}
		
		if(!checkQuantities()) {
			return;
		}
		
		if(!checkExpireDates()) {
			return;
		}
		

		
		//checkout calculations
		weight_total = calcCartWeight();
		subtotal = calcCartPrice();
		shipping_cost = calcShippingCost();
		total_cost = calcTotalCost();
		
		//Check the balance
		if(!checkBalance()) {
			return;
		}
		
		//minus items ordered from the inventory
		minus_ordered_items();
		
		//check inventory
		//Inventory.print_inventory_items();
		
		//customer_info
		System.out.println("Bill to " + customer_name + "\n");
		if(IsShippable()) {
			System.out.println("Ship to " + customer_address + "\n");
		}
		System.out.println("Receipt Date " + LocalDate.now() + "\n");
		
		//receipt print
		System.out.println("** Shipment notice **\n");

		for(Pair<Product, Integer> item : items) {
			if(item.getKey().isShippable()) {
				System.out.println(item.getValue()+ "X " + item.getKey().getName() + " => " + (item.getValue() * item.getKey().getWeight()) + "g");
			}
			
		}
		
		System.out.println("Total package weight " + (weight_total / 1000) + "Kg\n");
		System.out.println("** Checkout receipt **\n");
		
		for(Pair<Product, Integer> item : items) {
			System.out.println(item.getValue()+ "X " + item.getKey().getName() + " => " + (item.getValue() * item.getKey().getPrice()) + "$");			
		}
		
		System.out.println("\n---------------------------------------\n");
		
		System.out.println("subTotal => " + subtotal);
		System.out.println("shipping => " + shipping_cost);
		System.out.println("Amount => " + total_cost);
		
	}
	
	public double calcCartWeight() {
		
		double sum = 0;
		
		for(Pair<Product, Integer> item: items) {
			if(item.getKey().isShippable()) {
				sum += item.getValue() * item.getKey().getWeight();
				this.shippable = true;
			}
		}
		
		return sum;
	}
	
	public double calcCartPrice() {
		
		double sum = 0;
		
		for(Pair<Product, Integer> item: items) {
			sum += item.getValue() * item.getKey().getPrice();
		}
		
		return sum;
	}
	
	public double calcShippingCost() {
		
		double sum = 0;
		
		if(IsShippable()) {sum += 30; }
		
		return sum;
	}
	
	public double calcTotalCost() {
		return subtotal + shipping_cost;
	}
	
	public boolean checkQuantities() {
		boolean available = true;
		
		for(Pair<Product, Integer> item: items) {
			if(item.getKey().getInventoryQuantity() < item.getValue()) {
				
				available = false;
				System.out.println("the inventory is out of " + item.getKey().getName());
			}
		}
		
		return available;
	}
	
	public boolean checkExpireDates() {
		boolean valid = true;
		
		for(Pair<Product, Integer> item: items) {
			if(item.getKey().isExpirable()) {
				if(item.getKey().getExpire_date().isBefore(LocalDate.now())) {
					
					valid = false;
					System.out.println(item.getKey().getName() + " is Expired!");
				}
			}
		}
		
		return valid;
	}
	
	public boolean checkBalance() {
		
		if(customer_balance < total_cost) {
			System.out.println("Insufficant balance to pay " + total_cost);
			return false;
		}
		
		return true;
	}
	
	private void minus_ordered_items() {
		for(Pair<Product,Integer> item:items) {
			item.getKey().inventory_quantity -= item.getValue();
		}
	}
	

	
	
	

}
