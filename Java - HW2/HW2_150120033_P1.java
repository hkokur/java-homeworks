/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Calculating 11 digit isbn from input that user enter
 */

public class HW2_150120033_P1 {
	public static void main(String[] args) {
	java.util.Scanner input = new java.util.Scanner(System.in);
	
	//getting digits from user
	System.out.print("Enter the first 9 digits of an ISBN as integer: ");
	int enteredDigits = input.nextInt();
	
	//taking digit from input one by one
	int ninethDigit = enteredDigits%10;
	int eighthDigit = (int)(enteredDigits/10)%10;
	int seventhDigit = (int)(enteredDigits/100)%10;
	int sixthDigit = (int)(enteredDigits/1000)%10;
	int fifthDigit = (int)(enteredDigits/10000)%10;
	int fourthDigit = (int)(enteredDigits/100000)%10;
	int thirdDigit = (int)(enteredDigits/1000000)%10;
	int secondDigit = (int)(enteredDigits/10000000)%10;
	int firstDigit = (int)(enteredDigits/100000000)%10;
	
	//calculating tenth digit 
	int tenthDigit = (1*firstDigit + 2*secondDigit + 3*thirdDigit + 4*fourthDigit + 5*fifthDigit + 6*sixthDigit + 7*seventhDigit + 8*eighthDigit + 9*ninethDigit)%11;
	//printing result
	System.out.print("The ISBN-10 number is ");
	if(tenthDigit == 10)
	System.out.print("" + firstDigit + secondDigit + thirdDigit + fourthDigit +fifthDigit + sixthDigit + seventhDigit + eighthDigit + ninethDigit + "X");
	else
	System.out.print("" + firstDigit + secondDigit + thirdDigit + fourthDigit +fifthDigit + sixthDigit + seventhDigit + eighthDigit + ninethDigit + tenthDigit);	
	}
}
