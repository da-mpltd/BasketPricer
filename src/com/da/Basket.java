package com.da;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * A Basket holds Items, the class can be expanded to contain more modifying
 * methods such as removing items if needed easily.  
 */
public class Basket {

	private Map<Item, Integer> items;
	
	public Basket() {
		this.items = new HashMap<Item,Integer>();
	}

	public void add(Predicate<Item> basketAdditionPolicy, Item item) {
		add(basketAdditionPolicy,item,1);
	}

	public void add(Predicate<Item> basketAdditionPolicy, Item item, int quantity) {
		if(quantity <= 0){
			throw new IllegalArgumentException("Quantity must be greater than zero.");
		}
		if (basketAdditionPolicy.test(item)){			
			items.merge(item, quantity, (original, increment) -> (original + increment));
		}
	}	

	public Map<Item, Integer> getItems() {
		return items;
	}
	
}
	