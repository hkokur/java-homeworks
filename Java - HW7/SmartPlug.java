/*
Name Surname : Hakkı Kokur
Student ID : 150120033
*/ 

import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable{
    private boolean status;
    private Calendar programTime;
    private boolean programAction;
    
    SmartPlug(String alias, String macID){
        setAlias(alias);
        setMacID(macID);
        setTypeOfDevice("SmartPlug");
    }

    public void turnOn(){
        if(getConnectionStatus()){
            if(status)
                System.out.println("Smart Plug -" + super.getAlias() + " has been already turned on");
            else{
                status = true;
                programAction = false;
                System.out.println("Smart Plug - " + super.getAlias() + " is turned on now " + super.getCurrentTime());
            }
        }
    }

    public void turnOff(){
        if(getConnectionStatus()){
            if(!status)
                System.out.println("Smart Plug -" + super.getAlias() + " has been already turned off");
            else{
                status = false;
                programAction = true;
                System.out.println("Smart Plug - " + super.getAlias() + " is turned off now " + super.getCurrentTime());
            }
        }
    }

    public boolean testObject(){
        if(super.getConnectionStatus()){
            super.SmartObjectToString();
            turnOn();
            turnOff();
            System.out.println("Test completed for SmartPlug");
            return true;
        }
        else
            return false;
    }

    public boolean shutDownObject(){
        if(getConnectionStatus()){
            SmartObjectToString();
            turnOff();
            return true;
        }
        else
            return false;
    }


    public void setTimer(int seconds){
        if(super.getConnectionStatus()){
            programTime = Calendar.getInstance();
            programTime.add(Calendar.SECOND, seconds);

            if(status)
                System.out.println("Smart Plug - "+ super.getAlias() + " will be turned off "+ seconds +" seconds later! " + getCurrentTime());
            else
                System.out.println("Smart Plug - "+ super.getAlias() + " will be turned on "+ seconds +" seconds later! " + getCurrentTime());
        }
    }

    public void cancelTimer(){
        if(getConnectionStatus())
            programTime = null;
    }

    public void runProgram(){
        if(getConnectionStatus()){
            if (programTime != null){
                if(programTime.get(Calendar.SECOND) == Calendar.getInstance().get(Calendar.SECOND)){
                    System.out.println("runProgram -> " + this.getTypeOfDevice() + " - "+ super.getAlias());
                    if(status){
                        turnOff();
                    }
                    else{
                        turnOn();
                    }
                    programTime = null;
                }
            }
        }
    }


}
