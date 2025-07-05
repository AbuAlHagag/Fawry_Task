package fawry_task;

import java.time.LocalDate;

import classes.Cart;
import classes.Inventory;
//used for testing
import classes.Cheese;

//Main Power Of The System
//Can initialize the inventory using any amount of objects
//Order items will be stored in the Inventory with quantities ordered to send to the customer
//minus the Ordered items amount for the items in the inventory
//Customer can be guest until choosing what to buy then give use the username and other info
//Search in the inventory is optimize using trees
//Check for any problem in the customer order/cart and inform the customer

//More To Implement
//Customer class with username, address and balance
//Store balance and minus the order from it


public class e_commerce_system {

	public static void main(String[] args) {
		
		Inventory.Init();
		
		Cart cart = new Cart();
		
		//can't use items that is not in the inventory
		Cheese Feta = new Cheese("Feta", 20, 100, 50, LocalDate.of(2026, 7, 26));
		
		cart.add(Inventory.chedder, 3);
//		cart.add(Feta, 3);
		cart.add(Inventory.cookie, 5);
		cart.add(Inventory.tv_samsung, 1);
		cart.add(Inventory.iphone_12_pro_x, 1);
		cart.add(Inventory.gift_card, 2);
		
		cart.checkout("John Smith","3787 pineview Drive Cambridge, MA 12210",2000);
	}
	

}
