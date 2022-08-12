/*
Name Surname = Hakkı Kokur
NO = 150120033
*/


public class Department {
    private int departmentId;
    private String departmentName;

    Department(int departmentId, String departmentName){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getDepartmentName(){
        return departmentName;
    }
    public String toString(){
        String s;
        s = "Department [departmentId=" +this.departmentId + ", departmentName="+ this.departmentName+"]";
        return s;
    }

}
