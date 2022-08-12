/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Calculating taxed money by tax amount that change year by year
 */

public class HW2_150120033_P3 {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		//getting variable from user
		String str = input.nextLine();
		int year = Integer.parseInt(str.substring(0,4));
		double income = Double.parseDouble(str.substring(5));
		
		//declaring desired variable 
		double taxAmount;		
		
		// categories of taxed money amount and tax rate by years
		int categoryOneAmount=0;
		double categoryOneRate=0.15;
		int categoryTwoAmount=0;
		double categoryTwoRate=0.20;
		int categoryThreeAmount=0;
		double categoryThreeRate=0.27;
		int categoryFourAmount=0;
		double categoryFourRate=0.35;
		double categoryFiveRate=0.40;
		
		// to avoid unnecessary process after this if block
		boolean calculation = false;
		
		//assigning value to categories and tax rate by years and eliminating undesired condition
		if((year <= 2020 ) && (year >= 2017)){
			if (income > 0) {
				calculation = true;
				if (year == 2017) {
					categoryOneAmount = 13000;
					categoryTwoAmount = 30000;
					categoryThreeAmount = 110000;
				}
				if (year == 2018) {
					categoryOneAmount = 14800;
					categoryTwoAmount = 34000;
					categoryThreeAmount = 120000; 
				}
				if(year == 2019) {
					categoryOneAmount = 18000;
					categoryTwoAmount = 40000;
					categoryThreeAmount = 148000;
					categoryFourAmount = 5000000;
				}
				if(year == 2020) {
					categoryOneAmount = 22000;
					categoryTwoAmount = 49000;
					categoryThreeAmount = 180000;
					categoryFourAmount = 600000;
				}								
			}
			else
				System.out.print("Income must be > 0");
		}
		else
			System.out.print("Undefined year value");
			
		// calculation to find desired variable
		if (calculation) {
			double categoryOneDefaultAmount = categoryOneAmount*categoryOneRate;
			double categoryTwoDefaultAmount = (categoryTwoAmount-categoryOneAmount)*categoryTwoRate;
			double categoryThreeDefaultAmount = (categoryThreeAmount-categoryTwoAmount)*categoryThreeRate;
			double categoryFourDefaultAmount = (categoryFourAmount-categoryThreeAmount)*categoryFourRate;
			if(income < categoryOneAmount)
				// calculation for category one
				taxAmount = income*categoryOneRate;
			else if(income < categoryTwoAmount)
				// calculation for category two
				taxAmount = (income-categoryOneAmount)*categoryTwoRate + categoryOneDefaultAmount  ; 
			else if(income < categoryThreeAmount)
				//calculation for category three
				taxAmount = (income-categoryTwoAmount)*categoryThreeRate + categoryTwoDefaultAmount + categoryOneDefaultAmount  ;
			else if(income<categoryFourAmount)
				//calculation for category four
				taxAmount = (income-categoryThreeAmount)*categoryFourRate + categoryThreeDefaultAmount + categoryTwoDefaultAmount + categoryOneDefaultAmount;
			else {
				switch((int)(categoryFourAmount*categoryFourRate)) {
				case 0:
					//calculation for overranged money on four rate taxing system 
					taxAmount = (income -categoryThreeAmount)*categoryFourRate + categoryThreeDefaultAmount + categoryTwoDefaultAmount + categoryOneDefaultAmount ;
					break;
				default:
					//calculation for overranged money on five rate taxing system
					taxAmount = (income - categoryFourAmount)*categoryFiveRate + categoryFourDefaultAmount + categoryThreeDefaultAmount + categoryTwoDefaultAmount + categoryOneDefaultAmount;
					break;
			}
		}			
			System.out.println("Income: " + income);
			System.out.println("Tax Amount: " + (int)(taxAmount*100)/100.0);
			System.out.println("Income after tax: " + (int)((income - taxAmount)*100)/100.0);
			System.out.println("Real Tax Rate: " + ((int)((((1- (income-taxAmount)/income)*10000)))/100.0) + "%");			
		}		
	}
}
