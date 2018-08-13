package com.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.Type.Drinks.yourDrink;

public class GenerateBill {
	
	static String choice;
	
	public void enterYourChoice() {
		
		System.out.println("\n\nSelect Items from Catalogue\n");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		choice = sc.nextLine();
		System.out.println(choice);
		OrderSummary();
	}
	
	public int calculateCost() {
		
		int totalCost = 0;
		yourDrink[] drinkarray = yourDrink.values();
		String [] index = choice.split(",");
		for(String number: index) {
			
			int indexNumber = Integer.parseInt(number);
			totalCost = totalCost+drinkarray[indexNumber-1].getPrice();
		}
		//System.out.println("Total cost that is to be paid is"+totalCost);
		
		return totalCost;
	}
	
	public int calculateTax(int totalCost) {
		
		List<Integer> tax = new ArrayList<>();
		yourDrink[] drinkarray = yourDrink.values();
		String [] index = choice.split(",");
		for(String number: index) {
			
			int indexNumber = Integer.parseInt(number);
			tax.add(drinkarray[indexNumber-1].getTax());
		}
		Collections.sort(tax,Collections.reverseOrder());
		int totalTaxPayable = tax.get(0);
		return totalTaxPayable;
	
	}
	
	public double calculateTotalPayableCost(int totalTaxPayable,int totalCost) {
		//System.out.println("Tax % to be paid is "+totalTaxPayable+"%");
		int temp = totalTaxPayable+100;
		double totalPayableCost = (float)temp/100*totalCost;
		//System.out.printf("The amount payable is %.2f",totalPayableCost);
		return totalPayableCost;
	}
	
	public Map<Integer, Integer> calculateQuantity(String choice) {
		
		int i=1;
		Map<Integer,Integer> quantityMap = new HashMap<>();
		String [] index = choice.split(",");
		for(String number: index) {
			
			int indexNumber = Integer.parseInt(number);
			
			if(quantityMap.containsKey(indexNumber)) {
				int valueOfi = quantityMap.get(indexNumber);
				valueOfi++;
				//System.out.println("Value In The Map after increment for key"+indexNumber+" is "+valueOfi);
			    quantityMap.put(indexNumber, valueOfi);
			}
			else {
				quantityMap.put(indexNumber, i);
			}
		}
		return quantityMap;
	}
	
	
	
	public void OrderSummary() {
		
		int No = 1;
		Map<Integer,Integer> quantityMap = new HashMap<>();
		quantityMap = calculateQuantity(choice);
		yourDrink[] drinkarray = yourDrink.values();
		String [] index = choice.split(",");
		System.out.println("Order Summary:\n"
				+ "\n"
				+ "No.       Item.       Quantity.       Price.\n");
		

		   for(Map.Entry<Integer, Integer> entry: quantityMap.entrySet()) {
			   
		    System.out.println(No+++"        "+drinkarray[entry.getKey()-1].name()+"              "+entry.getValue()+"                "+drinkarray[entry.getKey()-1].getPrice());
		
		}
		   System.out.println("----------------------------------------------------------------------------------------------------------");
		   
		   System.out.println("Total                    "+calculateCost()+"\n"
		   		+ "Tax to be paid:                        "+calculateTax(calculateCost())+"\n"
		   				+ "-------------------------------------------------------------------------------------------------------");
		   System.out.println("Total amount to be paid                          "+calculateTotalPayableCost(calculateTax(calculateCost()),calculateCost()));
	}
	
	}
	
	


