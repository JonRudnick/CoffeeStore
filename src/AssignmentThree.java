/* author: Jonathan Rudnick
 * date: Sep 18, 2013
 * description: The program creates a "store" from which the user can specify items and
 * their quantities to purchase, as well as the sales tax on that purchase.
 * proposed points (out of 20): 20 (all parts completed)
 */

import java.util.Scanner;

public class AssignmentThree {

	public static void main(String[] args) {
		
		//Generic welcome message!
		System.out.println("Welcome to our store!");
		
		//Declaring variables for each item name, price, and quantity. This allows values
		//to be changed easily at initialization rather than throughout the program
		String latteName = "Latte";
		double lattePrice = 2.75;
		int latteQuantity = 0;
		String mochaName = "Coffee";
		double mochaPrice = 2.95;
		int coffeeQuantity = 0;
		String coffeeName = "Mocha";
		double coffeePrice = 3.75;
		int mochaQuantity = 0;
		
		//Declaration of other variables used in the program
		Scanner keyboard = new Scanner(System.in);
		String itemChoice = ""; //first user input, for item choice
		int quantity = 0; //quantity input
		String userInput; //second user input, used in the while loop
		double salesTax;
		double totalPrice;
		double subTotal;
		
		//Menu. Simply lists each item and its price.
		System.out.println(latteName + " - " + lattePrice);
		System.out.println(coffeeName + " - " + coffeePrice);
		System.out.println(mochaName + " - " + mochaPrice);
		
		//ask for and gather user input of buying choice
		System.out.println("");
		System.out.println("What would you like to buy?");
		itemChoice = keyboard.nextLine();
		
		//ifs. the program once again uses variables instead of values to increase modifiability
		//ask for and gather user input of quantity
		if(Character.toUpperCase(itemChoice.charAt(0)) == latteName.charAt(0)) {
			System.out.println("How many " + latteName + "s would you like?");
			latteQuantity += keyboard.nextInt();
			keyboard.nextLine(); //gobble up the next line
		}
		else if(Character.toUpperCase(itemChoice.charAt(0)) == coffeeName.charAt(0)) {
			System.out.println("How many " + coffeeName + "s would you like?");
			coffeeQuantity = keyboard.nextInt();
			keyboard.nextLine(); //gobble up the next line
		}
		else if(Character.toUpperCase(itemChoice.charAt(0)) == mochaName.charAt(0)) {
			System.out.println("How many " + mochaName + "s would you like?");
			mochaQuantity = keyboard.nextInt();
			keyboard.nextLine(); //gobble up the next line
		}
		
		//user input asking if the user wishes to continue
		System.out.println("Do you want to buy anything else? [y/n]");
		userInput = keyboard.nextLine();
		
		while (userInput.charAt(0) == 'y') { //as before, charAt is used rather than a separate
											 //variable to conserve space
			
			//reprint menu so user doesn't have to scroll up
			System.out.println(latteName + " - " + lattePrice);
			System.out.println(coffeeName + " - " + coffeePrice);
			System.out.println(mochaName + " - " + mochaPrice);
			
			//same question as earlier
			System.out.println("");
			System.out.println("What would you like to buy?");
			itemChoice = keyboard.nextLine();
			
			//same if format. assigning values is done with += so that a user may add
			//to the quantity of an item already on their list, rather than replacing
			//the value
			if(Character.toUpperCase(itemChoice.charAt(0)) == latteName.charAt(0)) {
				System.out.println("How many " + latteName + "s would you like?");
				latteQuantity += keyboard.nextInt();
				keyboard.nextLine();
			}
			else if(Character.toUpperCase(itemChoice.charAt(0)) == coffeeName.charAt(0)) {
				System.out.println("How many " + coffeeName + "s would you like?");
				coffeeQuantity = keyboard.nextInt();
				keyboard.nextLine();
			}
			else if(Character.toUpperCase(itemChoice.charAt(0)) == mochaName.charAt(0)) {
				System.out.println("How many " + mochaName + "s would you like?");
				mochaQuantity = keyboard.nextInt();
				keyboard.nextLine();
			}

			//the check which either reruns or completes the while loop
			System.out.println("Do you want to buy anything else? [y/n]");
			userInput = keyboard.nextLine();
		}
		
		//another input to gather sales tax
		System.out.println("What is the sales tax?");
		salesTax = keyboard.nextDouble();
		keyboard.nextLine();
		//if statement checks whether user input a decimal or natural number for tax
		//and converts to decimal
		if(salesTax > 1) {
			salesTax /= 100;
		}
		//price for each item is calculated by multiplying item price by item quantity
		lattePrice *= latteQuantity; 
		coffeePrice *= coffeeQuantity;
		mochaPrice *= mochaQuantity;
		//subtotal is calculated by totaling item prices
		subTotal = lattePrice + coffeePrice + mochaPrice;
		//tax (now a decimal) is multiplied by the subtotal
		salesTax *= subTotal;
		//total is subtotal more tax
		totalPrice = subTotal + salesTax;
		
		//System for item list is "item(quantity) - price"
		System.out.printf("%s(%d) - $%.2f\n", latteName, latteQuantity, lattePrice);
		System.out.printf("%s(%d) - $%.2f\n", coffeeName, coffeeQuantity, coffeePrice);
		System.out.printf("%s(%d) - $%.2f\n", mochaName, mochaQuantity, mochaPrice);
		System.out.printf("Subtotal: $%.2f\n", subTotal); //prints subtotal
		System.out.printf("Tax: $%.2f\n", salesTax); //prints tax
		System.out.printf("Total: $%.2f\n", totalPrice); //prints total
		System.out.println("Thank you. Come again!"); //bye bye
	}
}