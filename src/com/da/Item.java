package com.da;

/**
 * Design choice made here to use int for pence price to keep it simple
 * If we expect there to be fractional pricing or fx rates then 
 * BigDecimal would be better for accuracy. 
 * While the list of items were all Fruit, there is nothing to guarantee 
 * it will always be Fruit so we'll use Item for the pojo name.
 * Design choice to not verify price > 0. Would need to verify if baskets can
 * hold items with negative price that act as discounts for example.
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pencePrice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pencePrice != other.pencePrice)
			return false;
		return true;
	}

}
