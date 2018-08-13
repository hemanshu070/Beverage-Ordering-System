package com.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Drinks {
	
	enum Type{
		
		HOT(),
		COLD();
	}
	
	enum Beverage {
		
		Coffee(18),
		Tea(5),
		ColdDrink(21);
		
		int tax;
		Beverage(int tax) {
			
			this.tax = tax;
		}
		
		int getTax() {
			return tax;
		}
	}
	
	enum yourDrink{
		
		LATTE(40,Beverage.Coffee,Type.HOT),
		CAPACHINO(50,Beverage.Coffee,Type.HOT),
		EXPRESSO(30,Beverage.Coffee,Type.HOT),
		MASALA(15,Beverage.Tea,Type.HOT),
		BLACK(10,Beverage.Tea,Type.HOT),
		OREO(70,Beverage.Coffee,Type.COLD),
		FAPE(80,Beverage.Coffee,Type.COLD),
		PEPSI(50,Beverage.ColdDrink, Type.COLD),
		COLA(40,Beverage.ColdDrink,Type.COLD);
		private Beverage bever;
		private int price;
		private Type typeofDrink;
		yourDrink(int p,Beverage bever,Type typeofDrink) {
			this.price = p;
			this.typeofDrink = typeofDrink;
			this.bever = bever;
		}
		int getPrice() {
			return price;
		}
		Type getType( ) {
			return typeofDrink;
		}
		Beverage getBeverageType() {
			return bever;
		}
		int getTax() {
			return getBeverageType().getTax();
		}
		
	}
	
	public void showCatalogue() {
		
		int n = 1;
		List<Integer> listforPrices = new ArrayList<>();
		Set<Integer> taxList = new HashSet<>();
		for(yourDrink drink : yourDrink.values()) 
		{
			
			System.out.println(n+++".   "+drink.typeofDrink +"."+drink.getBeverageType()+"."+drink +" - rs"+drink.getPrice());
			listforPrices.add(drink.getPrice());
	        //taxList.add(drink.getTax());
			
		}
		
	}
}
