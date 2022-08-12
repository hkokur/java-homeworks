/*
Name Surname = Hakkı Kokur
NO = 150120033
*/

public class RegularEmployee extends Employee{
    private double performanceScore;
    private double bonus;

    RegularEmployee(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String marialStatus, String hasDriverLicence,
    double salary, java.util.Calendar hireDate, Department department, double performanceScore){
        super(id, firstName, lastName, gender, birthDate, marialStatus, hasDriverLicence, salary, hireDate, department);
        setPerformanceScore(performanceScore);
    }

    RegularEmployee(Object employee, double perfScore){
        super(((Employee)employee).getId(),((Employee)employee).getFirstName(), ((Employee)employee).getLastName(), ((Employee)employee).getGender(), ((Employee)employee).getBirthDate(), ((Employee)employee).getMarialStatus(), 
        ((Employee)employee).getHasDriverLicence(), ((Employee)employee).getSalary(), ((Employee)employee).getHireDate(), ((Employee)employee).getDepartment());
        setPerformanceScore(perfScore);
    }

    public void setPerformanceScore(double performanceScore){
        this.performanceScore = performanceScore;
    }

    public double getPerformanceScore(){
        return performanceScore;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public double getBonus(){
        return Math.round(bonus*100)/100.0;
    }



}
