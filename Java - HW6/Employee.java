import java.util.Calendar;

/*
Name Surname = Hakkı Kokur
NO = 150120033
*/


public class Employee extends Person {
    private double salary;
    private java.util.Calendar hireDate;
    private Department department;
    public static int numberOfEmployees;

    Employee(){}

    Employee(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String marialStatus, String hasDriverLicence,
    double salary, java.util.Calendar hireDate, Department department){
        super(id, firstName, lastName, gender, birthDate, marialStatus, hasDriverLicence);
        setSalary(salary);
        setHireDate(hireDate);
        setDepartment(department);
        numberOfEmployees +=1;
    }

    Employee(Object person, double salary, java.util.Calendar hireDate, Object department){
        super(((Person)person).getId(), ((Person)person).getFirstName(), ((Person)person).getLastName(), ((Person)person).getGender(),
                ((Person)person).getBirthDate(), ((Person)person).getMarialStatus(), ((Person)person).getMarialStatus());
        setSalary(salary);
        setHireDate(hireDate);
        setDepartment((Department)department);
        numberOfEmployees +=1;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setHireDate(java.util.Calendar hireDate){
        this.hireDate = hireDate;
    }
    public Calendar getHireDate(){
        return hireDate;
    }
    public String gHireDate(){
        String s;
        s = "" + hireDate.get(Calendar.DAY_OF_MONTH) + "/" + hireDate.get(Calendar.MONTH) + "/" + hireDate.get(Calendar.YEAR);
        return s;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public Department getDepartment(){
        return department;
    }

    public void setNumberOfEmployees(int numberOfEmployees){
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees(){
        return numberOfEmployees;
    }

    public double raiseSalary(double percent){
        this.salary = salary + salary*percent;
        return salary;
    }

    public double raiseSalary(int amount){
        salary +=amount;
        return salary;
    }

    
    public String toString(){
        return "" + getId();
    }


}
