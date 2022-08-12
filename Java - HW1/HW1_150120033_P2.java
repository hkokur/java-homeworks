/* Purpose : Converting a date that be given in days to Year,Month,Day format.
 * Name and Surname : Hakkı Kokur
 * Student ID : 150120033
 */

import java.util.Scanner;

public class HW1_150120033_P2 {

	public static void main(String[] args) {
		
		// crating Scanner object to take values from user on the future. 
		Scanner input = new Scanner(System.in);
		
		//getting the number of days
		System.out.print("Number of days: ");
		int days = input.nextInt();
		
		// calculating year
		int year = days/365;
		// calculating month
		int month = (days-365*year)/31;
		// calculating day
		int day = (days%365)-month*31;
		
		// Showing the calculating result
		System.out.print("Year: " + year + ", Month: " + month + ", Day: " + day + ".");
	
		
	}

}
