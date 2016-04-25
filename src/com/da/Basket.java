package com.da;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
/**
 * A Basket holds Items, the class can be expanded to contain more modifying
 * methods such as removing items if needed easily. The implementation of the 
 * Collection to store Items may also then need to be revisited based on possible
 * changes to how we could interact with the basket. 
 */
public class Basket {

	//Map<Item, Integer> may be an improvement if the use case for baskets become complex and need quantities easily.
	private List<Item> items;

	public Basket() {
		this.items = new LinkedList<Item>();
	}

	//We may have to control what type of Items can get added to the basket
	public void add(Predicate<Item> basketAdditionPolicy, Item item) {
		if (basketAdditionPolicy.test(item)){
			items.add(item);
		}
	}

	public Collection<Item> getContents() {
		return items;
	}
	
}
	