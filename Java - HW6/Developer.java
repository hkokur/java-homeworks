/*
Name Surname = Hakkı Kokur
NO = 150120033
*/


import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee {
    private ArrayList<Project> projects = new ArrayList<>();
    public static int numberOfDevelopers;

    Developer(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String marialStatus, String hasDriverLicence,
    double salary, java.util.Calendar hireDate, Department department, double performanceScore, ArrayList<Project> p){
        super(id, firstName, lastName, gender, birthDate, marialStatus, hasDriverLicence, salary, hireDate, department, performanceScore);
        projects = p;
        numberOfDevelopers +=1;
    }

    Developer(RegularEmployee re, ArrayList<Project> p){
        super(re.getId(),re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMarialStatus(), 
        re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
        projects = p;
        numberOfDevelopers +=1;
    }

    public boolean addProject(Project s){
        projects.add(s);
        return true;
    }

    public boolean removeProject(Project s){
        projects.remove(s);
        return true;
    }

    public String getProject(){
        String s;
        s = "				[Project ";
        for(Project project : projects){
            s += "[projectName="+ project.getProjectName()+", startDate="+ project.getStartDate()+", state="+ project.getState()+"]" ;
            if (projects.indexOf(project) != (projects.size()-1)){
                s +=",";
            }
        }
        s += "]";
        return s;
    }


}
