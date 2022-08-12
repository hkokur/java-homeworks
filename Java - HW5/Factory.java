/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Creating the structure of how the factory will work. 
*/
public class Factory {
	String name;
	Employee[] employees = new Employee[0];
	Storage storage;
	Payroll[] payrolls = new Payroll[0];
	double itemPrice;
	
	Factory(String name, int capacity, double itemPrice){
		this.name = name;
		this.storage = new Storage(capacity);
		this.itemPrice = itemPrice;
	}
	
	double getRevenue(){
		double revenue;
		revenue = storage.Items.length * itemPrice;
		return revenue;
	}
	
	double getPaidSalaries() {
		double salary = 0;
		for(Payroll payroll: payrolls) {
			salary += payroll.calculateSalary();
		}
		return salary;
	}
	
	void addEmployee(Employee employee) {
		Employee[] array = new Employee[employees.length+1];
		System.arraycopy(employees, 0, array, 0, employees.length);
		array[employees.length] = employee;
		employees = array;
		
		for(Item item: employee.startShift()) {
			storage.addItem(item);
		}

	}
	
	public Employee removeEmployee(int id) {
		Employee employee = null;
		if(employees.length > 0) {
			boolean pass = false;
			for(int i = 0 ; i < employees.length ; i++) {
				if(employees[i].id == id)
					pass = true;
			}
			
			if (pass) {
				Employee[] array = new Employee[employees.length-1];
				for(int i = 0, j = 0; i < employees.length; i++,j++) {
					if(employees[i].id == id) {
						employee = employees[i];
						addPayroll(employee.endShift());
						j--;
					}
					else
						array[j]= employees[i];
				}
				employees = array;
			}
			else
				System.out.println("Employee does not exist!");
		}
		else
			System.out.println("There are no employees!");
		
		return employee;
	}
	
	void addPayroll(Payroll payroll) {
		Payroll[] array = new Payroll[payrolls.length+1];
		System.arraycopy(payrolls, 0, array, 0, payrolls.length);
		array[payrolls.length] = payroll;
		payrolls = array;
	}
	
}
