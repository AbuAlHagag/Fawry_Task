package classes;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Collections;
import java.util.TreeSet;

//define the items in the inventory and it's quantities
public class Inventory {
	private static boolean inventory_init = false;
	protected static TreeSet<Product> items = new TreeSet<Product>();
	
	public static Cheese chedder = new Cheese("Chedder", 40, 100, 100, LocalDate.of(2026, 10, 22));
	public static Biscuit cookie = new Biscuit("Cookie", 4, 1000, 5, LocalDate.of(2028, 1, 19));
	public static TV tv_samsung = new TV("TV Samsung", 1000, 30, 5000);
	public static Mobile iphone_12_pro_x = new Mobile("Iphone 12 pro X", 500, 50);
	public static ScratchCard gift_card = new ScratchCard("Gift Card", 10, 10, LocalDate.of(2026, 1, 9));
	
	public static void Init() {
		items.add(chedder);
		items.add(cookie);
		items.add(tv_samsung);
		items.add(iphone_12_pro_x);
		items.add(gift_card);
		inventory_init = true;
	}
	
	public static TreeSet<Product> getItems() {
		return items;
	}
	
	public static void print_inventory_items() {
		for(Product item: Inventory.items) {
			System.out.println(item.toString());
		}
		System.out.println("\n");
	}
 
	//optimized using trees
	public static boolean CheckItem(Product item_to_check) {
		
//		assert !inventory_init : "Inventory is not Initialized!";
		if(!inventory_init) {
			System.out.println("Inventory is not Initialized!");
			return false;
		}
		
		if (items.contains(item_to_check)) {
			return true;
		}
		return false;
	}
	
	
}
