/*
Name Surname : Hakkı Kokur
Student ID : 150120033
*/ 

import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl,Programmable {
    private boolean hasLightTurned;
    private Calendar programTime;
    private boolean programAction;

    SmartLight(String alias, String macID){
        setAlias(alias);
        setMacID(macID);
        setTypeOfDevice("SmartLight");
    }

    public void turnOnLight(){
        if (super.getConnectionStatus()){
            if(hasLightTurned)
                System.out.println("Smart Ligth - "+ super.getAlias()+ " has been already turned on");
            else{
                this.hasLightTurned = true;
                this.programAction = false;
                System.out.println("Smart Light - "+ super.getAlias() + " is turned on now " + getCurrentTime()); 
            }
        }
    }

    public void turnOffLight(){
        if (super.getConnectionStatus()){
            if(!hasLightTurned)
                System.out.println("Smart Ligth - "+ super.getAlias()+ " has been already turned off");
            else{
                this.hasLightTurned = false;
                this.programAction = true;
                System.out.println("Smart Light - "+ super.getAlias() + " is turned off now " + getCurrentTime()); 
            }
        }
    }

    public boolean testObject(){
        if(super.getConnectionStatus()){
            super.SmartObjectToString();
            turnOnLight();
            turnOffLight();
            System.out.println("Test completed for SmartLight");
            return true;
        }
        else
            return false;
    }

    public boolean shutDownObject(){
        if(super.getConnectionStatus()){
            super.SmartObjectToString();
            turnOffLight();
            return true;
        }
        else
            return false;
    }

    public void onLeave(){
        if(super.getConnectionStatus()){
            turnOffLight();
        }
    }

    public void onCome(){
        if(super.getConnectionStatus()){
            turnOnLight();
        }
    }

    public void setTimer(int seconds){
        if(super.getConnectionStatus()){
            programTime =  Calendar.getInstance();
            programTime.add(Calendar.SECOND, seconds);

            if(hasLightTurned)
                System.out.println("Smart light - "+ super.getAlias() + " will be turned off "+ seconds +" seconds later! " + getCurrentTime());
            else
                System.out.println("Smart light - "+ super.getAlias() + " will be turned on "+ seconds+"  seconds later! " + getCurrentTime());
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
                    if(hasLightTurned){
                        turnOffLight();
                    }
                    else{
                        turnOnLight();
                    }
                    programTime = null;
                }
            }
        }
    }
}
