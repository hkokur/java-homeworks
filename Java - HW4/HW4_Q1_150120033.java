/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Calculating each flats' bill according to consumption
 */

import java.util.Scanner;

public class HW4_Q1_150120033 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int flatNumbers = input.nextInt();
		
		double[] consumptions = new double[flatNumbers];
		
		for(int i=1; i<= flatNumbers; i++) {
			consumptions[i-1] = input.nextDouble();
		}
		
		double totalBill = input.nextDouble();
		double[] bills = calculateTheInvoice(consumptions, totalBill);
		
		printBills(bills);
		
	}
	
	public static double[] calculateTheInvoice (double[] flats, double totalBill) {
		double oneThirdOfBill = totalBill*0.3;
		double restOfBill = totalBill - oneThirdOfBill;
		
		double[] bills = new double[flats.length];
		
		double totalConsumption = 0;
		for(double consumption:flats) {
			totalConsumption += consumption;
		}
		
		for(int i=0; i<flats.length;i++) {
			bills[i] = (flats[i]*restOfBill)/totalConsumption + oneThirdOfBill/flats.length;
		}
		return bills;
	}
	
	public static void printBills(double[] bills) {		
		
		int i = 1;
		for(double bill: bills) {
			System.out.println("Flat #"+ i +": "+ (int)(bill*100)/100.0);
			i +=1;
		}
		
	}
	
}
