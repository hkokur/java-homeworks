/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Checking credit cards is whether or not it is valid with Luhn formula.
 */
import java.util.Scanner;

public class HW4_Q2_150120033 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String creditCardNumber = input.nextLine();
		boolean isValid;
		
		if(creditCardNumber.length()<= 1)
			System.out.print("Invalid input !");
		else {
			creditCardNumber = creditCardNumber.trim();
			boolean isValidInput = false;
			
			for(int i= 0; i<creditCardNumber.length();i++) {
				char digit = creditCardNumber.charAt(i);
				if((digit<=57)&&(digit>=48) ||(digit == 32))
					isValidInput = true;
				else
					isValidInput = false;
			}
			
			if (isValidInput) {
				isValid = validateNumber(creditCardNumber.trim());
				if(isValid) {
					System.out.print("Number is Valid");
				}
				else
					System.out.print("Number is Invalid");
			}
			else
				System.out.print("Invalid Input !");
		}	
	}
	
	public static boolean validateNumber(String number) {
		boolean isValid = false;
		
		String reverseNumber = "";
		
		for(int i = 0; i<number.length();i++) {
			if (number.charAt(number.length() -1 - i) != 32){
				reverseNumber += number.charAt(number.length() -1 - i);
			}
			
		}
		
		int sumOfAllDigits = 0;
		
		for(int i = 1; i< reverseNumber.length();i++,i++) {
			int intNumber = Integer.parseInt(reverseNumber.charAt(i)+"");
			int twiceIntNumber = intNumber*2;
			
			if(twiceIntNumber > 9)
				twiceIntNumber -=9;
			
			
			
			sumOfAllDigits +=twiceIntNumber; 
		}
		
		for(int i = 0; i< reverseNumber.length();i++,i++) {
			int intNumber = Integer.parseInt(reverseNumber.charAt(i)+"");
			sumOfAllDigits +=intNumber;
		}
		// printing DNumber
		System.out.print("DNumber:");
		for(int i =reverseNumber.length()-1 ;i>=0;i--) {
			if(i%2 == 0)
				System.out.print("_");
			else
				System.out.print(reverseNumber.charAt(i));
		}
		
		//printing LNumber
		System.out.println();
		System.out.print("LNumber:");
		for(int i = reverseNumber.length()-1; i>=0; i--) {
			if(i%2 != 0) {
				int intNumber = Integer.parseInt(reverseNumber.charAt(i)+"");
				int twiceIntNumber = intNumber*2;
				
				if(twiceIntNumber > 9)
					twiceIntNumber -=9;
				
				System.out.print(twiceIntNumber+"");
			}
			else
				System.out.print(reverseNumber.charAt(i));
		}
		System.out.println();
		
		if(sumOfAllDigits %10 == 0)
			return isValid = true;
		else
			return isValid;
	}

}
