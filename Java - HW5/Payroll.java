/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Creating the structure of the payroll that employees have. 
*/

public class Payroll {
	int workHour;
	int itemCount;
	
	Payroll(int workHour, int itemCount){
		this.workHour = workHour;
		this.itemCount = itemCount;
	}
	
	public int calculateSalary(){
		int salary = workHour*3 + itemCount*2;
		return salary;
	}
	
	public String toString() {
		String print = "The work hour is" + workHour + " and the produced item count is "+ itemCount;
		return print;
	}
}
