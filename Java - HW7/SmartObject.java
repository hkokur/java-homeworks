/*
Name Surname : Hakkı Kokur
Student ID : 150120033
*/ 

import java.util.Calendar;

abstract class SmartObject{
    private String alias;
    private String macID;
    private String IP;
    private boolean connectionStatus;
    private String typeOfDevice;

    SmartObject(){

    }

    SmartObject(String alias, String macID, String IP, boolean connectionStatus, String typeOfDevice){
        setAlias(alias);
        setMacID(macID);
        setIP(IP);
        setConnectionStatus(connectionStatus);
        setTypeOfDevice(typeOfDevice);
    }

    public void setAlias(String alias){
        this.alias = alias;
    }
    
    public String getAlias(){
        return alias;
    }
    
    public void setMacID(String macID){
        this.macID = macID;
    }

    public void setIP(String IP){
        this.IP = IP;
    }

    public void setConnectionStatus(boolean connectionStatus){
        this.connectionStatus = connectionStatus;
    }

    public boolean getConnectionStatus(){
        return this.connectionStatus;
    }

    public void setTypeOfDevice(String typeOfDevice){
        this.typeOfDevice = typeOfDevice;
    }

    public String getTypeOfDevice(){
        return this.typeOfDevice;
    }

    public boolean connect(String IP){
        this.IP = IP;
        this.connectionStatus = true;
        return true;
    }

    public boolean disconnect(){
        this.IP = "";
        this.connectionStatus = false;
        return true;
    }

    public void SmartObjectToString(){
        System.out.println("This is "+ typeOfDevice + " device " + this.alias);
        System.out.println("	MacId: " + macID);
        System.out.println("	IP: "+ this.IP );
    }

    public String getCurrentTime(){
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        return "(Current time: " + hour + ":" + minute + ":" + second +")";
    }
    public abstract boolean testObject();
    public abstract boolean shutDownObject();

}