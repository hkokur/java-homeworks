/* Purpose : Finding monthly interest rate and total compound interest amount of being given money by user.
 * Name and Surname : Hakkı Kokur
 * Student ID : 150120033
 */

import java.util.Scanner;

public class HW1_150120033_P3 {

	public static void main(String[] args) {
		//crating scanner object
		Scanner input = new Scanner(System.in);
		
		// getting necessary value from user with Scanner object. 
		System.out.print("Enter initial principal amount: ");
		double principalAmount = input.nextDouble();
		System.out.print("Enter annual interest rate(e.g. 9.5): ");
		double annualInterestRate = input.nextDouble();
		System.out.print("Enter number of the time periods in month: ");
		int month = input.nextInt();
		
		//Closing Scanner object
		input.close();
		
		// Calculating monthly interest rate 
		double monthlyInterestRate = annualInterestRate/12;
		
		//Calculating final amount of money on the end of the periods. 
		double finalAmount = principalAmount*Math.pow((1+(annualInterestRate/1200)), month);
		
		// printing results 
		System.out.println("Initial principal amount: " + principalAmount);
		System.out.println("Monthly interest rate: " + (int)(monthlyInterestRate*100)/100.0);
		System.out.println("Total compound interest amount: "+ (int)((finalAmount - principalAmount)*100)/100.0);
		System.out.println("Final balance amount: " + (int)(finalAmount*100)/100.0);
		
	}

}
