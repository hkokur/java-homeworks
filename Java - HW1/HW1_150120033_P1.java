/* Purpose : We want to calculate price of fuel that a car consume for several miles
 * Name and Surname : Hakkı Kokur
 * Student ID : 150120033
 */

import java.util.Scanner;

public class HW1_150120033_P1 {
	
	public static void main(String[] args) {
		
		// Crating a Scanner object
		Scanner input = new Scanner(System.in);
		
		// i take values that i will use for calculation with Scanner object 
		System.out.print("Enter the driving distance: ");
		double distance = input.nextDouble();
		System.out.print("Enter miles per gallon: ");
		double milesPerGallon = input.nextDouble();
		System.out.print("Enter price per gallon: ");
		double pricePerGallon = input.nextDouble();
		
		// When i find how much he spend gallon, i multiply with prince per gallon.
		// Then to find the number with two digit after dot, i multiply with 100 and convert to integer type and convert to double type with dividing 100.0. 
		System.out.print("The cost of driving is $"+ (int)((distance/milesPerGallon)*pricePerGallon*100)/100.0 + "\n");
		
		//closing the Scanner object.
		input.close();
		
	}

}
