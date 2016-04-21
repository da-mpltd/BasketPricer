package com.da;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/**
 * A Checkout takes one Basket at a time to have its cost calculated
 *
 */
public class Checkout {

	private Basket basket;

	public Checkout(Basket basket){
		this.basket=basket;
	}

	//This could have been a simple iteration and summation
	//However this lets us have more freedom to change pricing in the future.
	public int priceBasketInPence(ToIntFunction<Basket> basketPricingStrategy){	
		return basketPricingStrategy.applyAsInt(basket);		
	}

	public static void main(String[] args) {
		
		Basket fruitBasket = new Basket();
		
		Predicate<Item> basketAdditionPolicy = i -> i.getName().equalsIgnoreCase("banana")
				||i.getName().equalsIgnoreCase("orange")
				||i.getName().equalsIgnoreCase("apple")
				||i.getName().equalsIgnoreCase("lemon")
				||i.getName().equalsIgnoreCase("peach");
		
		fruitBasket.add(basketAdditionPolicy, new Item("banana", 25));
		fruitBasket.add(basketAdditionPolicy, new Item("oRange", 45)); //adhoc testing
		fruitBasket.add(basketAdditionPolicy, new Item("apple", 35));
		fruitBasket.add(basketAdditionPolicy, new Item("lemon", 55));
		fruitBasket.add(basketAdditionPolicy, new Item("peach", 95));
		fruitBasket.add(basketAdditionPolicy, new Item("kiwi", 999)); //adhoc testing

		Checkout checkout = new Checkout(fruitBasket);
		
		ToIntFunction<Basket> totalCostPricingStrategy = b -> b.getContents().stream().mapToInt(item -> item.getPencePrice()).sum();
		
		//Avoiding Loggers to reduce import statements
		System.out.println(checkout.priceBasketInPence(totalCostPricingStrategy));
	}

}
