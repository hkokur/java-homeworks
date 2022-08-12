/*
Name Surname = Hakkı Kokur
NO = 150120033
*/


import java.util.ArrayList;

public class Manager extends Employee{
    private ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
    private double bonusBudget;

    Manager(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String marialStatus, String hasDriverLicence,
    double salary, java.util.Calendar hireDate, Department department, double bonusBudget){
        super(id, firstName, lastName, gender, birthDate, marialStatus, hasDriverLicence, salary, hireDate, department);
        setBonusBudget(bonusBudget);
    }

    Manager(Object employee, double bonusBudget){
        super(((Employee)employee).getId(),((Employee)employee).getFirstName(), ((Employee)employee).getLastName(), ((Employee)employee).getGender(), ((Employee)employee).getBirthDate(), ((Employee)employee).getMarialStatus(), 
        ((Employee)employee).getHasDriverLicence(), ((Employee)employee).getSalary(), ((Employee)employee).getHireDate(), ((Employee)employee).getDepartment());
        setBonusBudget(bonusBudget);
    }

    public void setBonusBudget(double bonusBudget){
        this.bonusBudget = bonusBudget;
    }

    public double getBonusBudget(){
        return bonusBudget;
    }

    public void addEmployee(RegularEmployee e){
        regularEmployees.add(e);
    }

    public void removeEmployee(RegularEmployee e){
        regularEmployees.remove(e);
    }

    public ArrayList<RegularEmployee> getRegularEmployees(){
        return regularEmployees;
    }

    public void distributeBonusBudget(){
        double sigma = 0;

        for(RegularEmployee e:regularEmployees){
            sigma +=e.getSalary() * e.getPerformanceScore();
        }

        double unit = bonusBudget / sigma;

        for(RegularEmployee e: regularEmployees){
            e.setBonus(unit * e.getSalary()* e.getPerformanceScore());        }
    }
    
    public String toString(){
        String s  = "	Manager [id:" + getId() + ", " + getFirstName() + " " + getLastName() + " \n		" 
        + "# of Employees: " + this.regularEmployees.size() + "]";
        return s;
    }


}
