/*
Name Surname = Hakkı Kokur
NO = 150120033
*/

import java.util.Calendar;


public class Project {
    private String projectName;
    private java.util.Calendar startDate;
    private boolean state;

    Project(String projectName, java.util.Calendar startDate, boolean state){
        setProjectName(projectName);
        setStartDate(startDate);
        setState(state);
    }

    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    public String getProjectName(){
        return projectName;
    }

    public void setStartDate(java.util.Calendar startDate){
        this.startDate = startDate;
    }

    public String getStartDate(){
        return "" + startDate.get(Calendar.DAY_OF_MONTH) + "/" + startDate.get(Calendar.MONTH) + "/" + startDate.get(Calendar.YEAR);
    }

    public void setState(boolean state){
        this.state = state;
    }

    public void setState(String state){
        if(state == "Open")
            this.state = true;
        else
            this.state = false;
    }

    public String getState(){
        if (state)
            return "Open";
        else 
            return "Close";
    }

    public void close(){
        if(state)
            this.state = false;
    }




}
