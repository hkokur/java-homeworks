/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Creating the structure of the employees that work for factory.
*/

public class Employee {
	int id;
	String name;
	String surname;
	int workHour;
	int speed;
	Item[] items;
	Payroll payroll;
	
	Employee(int id, String name, String surname, int workHour, int speed){
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.workHour = workHour;
		this.speed = speed;
	}
	
	Item[] startShift() {
		int producedItemNumbers = workHour*speed;
		items = new Item[producedItemNumbers];
		
		for(int i = 0; i < producedItemNumbers;i++) {
			items[i] = new Item((int)((Math.random()*100)+1));
		}
		
		return items;
	}
	
	public Payroll endShift() {
		payroll = new Payroll(workHour,items.length);
		return payroll;
	}
	
	public String toString(){
		String str = "This is employee with id " + this.id +" speed "+ this.speed + ".The work hour is " + this.workHour+" and the produce item count is "+ this.items.length+".";
		return str;
	}
	
	public int getId() {
		return this.id;
	}
	
}
