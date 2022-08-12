/*
Name Surname = Hakkı Kokur
NO = 150120033
*/


import java.util.Calendar;

public class Person{
    private int id;
    private String firstName;
    private String lastName;
    private byte gender;
    private java.util.Calendar birthDate;
    private byte marialStatus;
    private boolean hasDriverLicence;

    public Person(){}

    public Person(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String marialStatus, String hasDriverLicence){
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setBirthDate(birthDate);
        setMarialStatus(marialStatus);
        setHasDriverLicence(hasDriverLicence);
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setBirthDate(java.util.Calendar birthDate){
        this.birthDate = birthDate;
    }
    public java.util.Calendar getBirthDate(){
        return birthDate;
    }

    public void setGender(String gender){

        switch(gender){
            case "Woman":
                this.gender = 1;
                break;
            case "M1an":
                this.gender = 2;
                break;
        }
    }

    public String getGender(){
        if (gender == 1)
            return "Woman";
        else
            return "Man"; 
    }

    public void setMarialStatus(String status){
        switch(status){
            case "Single" :
                this.marialStatus = 1;
                break;
            case "Maried":
                this.marialStatus = 2;
                break;
        }
    }

    public String getMarialStatus(){
        if (marialStatus == 1)
            return "Single";
        else
            return "Maried";
    }

    public void setHasDriverLicence(String info){
        switch(info){
            case "Yes":
                this.hasDriverLicence = true;
                break;
            case "No":
                this.hasDriverLicence = false;
                break;
        }
    }

    public String getHasDriverLicence(){
        if (hasDriverLicence)
            return "Yes";
        else
            return "No";
    }

    public String toString(){       
        return "[id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName+ ", gender=" + (this.gender == 1 ? "Woman" : "Man")+
        " birthDate="+ birthDate.get(Calendar.DAY_OF_MONTH) + "/" + birthDate.get(Calendar.MONTH) + "/" +birthDate.get(Calendar.YEAR)+
        ", maritalStatus=" + (this.marialStatus == 1 ? "Single" : "Maried") + ", hasDriverLicence=" +
        (this.hasDriverLicence == true ? "Yes" : "No") + "]";
    }

}