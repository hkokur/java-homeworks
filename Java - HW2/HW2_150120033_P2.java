/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Finding day name with given formula
 */

public class HW2_150120033_P2 {


	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		// getting year,month and the day of the month from user
		System.out.print("Enter year (e.g. 2012): ");
		int year = input.nextInt();
		System.out.print("Enter month (e.g. 1-12): ");
		int month = input.nextInt();
		System.out.print("Enter the day of the month (e.g. 1-31): ");
		int day = input.nextInt();
		
		// switching January and February with proper numbers
		switch(month) {
		case 1: 
			month = 13;
			year -= 1;
			break;
		case 2: 
			month = 14;
			year -=1;
			break;
		}
	
		// calculating day according to formula
		int century = year/100;
		int yearOfCentury = year%100;
		int d = (day + (26*(month+1)/10) + yearOfCentury + yearOfCentury/4 + century/4 + 5*century)%7;
		
		// printing result
		switch(d) {
		case 0: System.out.print("Day of the week is Saturday"); break;
		case 1: System.out.print("Day of the week is Sunday"); break;
		case 2: System.out.print("Day of the week is Monday"); break;
		case 3: System.out.print("Day of the week is Tuesday"); break;
		case 4: System.out.print("Day of the week is Wednesday"); break;
		case 5: System.out.print("Day of the week is Thursday"); break;
		case 6: System.out.print("Day of the week is Friday");
		}
		
		
	}

}
