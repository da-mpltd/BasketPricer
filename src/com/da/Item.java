package com.da;

/**
 * Design choice made here to use int for pence price to keep it simple
 * If we expect there to be fractional pricing or fx rates then 
 * BigDecimal would be better for accuracy. 
 * While the list of items were all Fruit, there is nothing to guarantee 
 * it will always be Fruit so we'll use Item for the pojo name
 * Did not add boilerplate generated equals and hashcode methods as no maps used/needed.
 *
 */
public class Item {
	
	private String name;
	private int pencePrice;
	
	public Item(String name, int pencePrice) {
		this.name = name;
		this.pencePrice = pencePrice;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPencePrice() {
		return pencePrice;
	}

	
}
