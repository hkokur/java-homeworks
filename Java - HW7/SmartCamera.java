/*
Name Surname : Hakkı Kokur
Student ID : 150120033
*/ 

public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {
    private boolean status;
    private int batteryLife;
    private boolean nightVision;

    SmartCamera(String alias, String macID, boolean nightVision, int batteryLife){
        setAlias(alias);
        setMacID(macID);
        setTypeOfDevice("SmartCamera");
        setBatteryLife(batteryLife);
        setNightVision(nightVision);
    }

    public void setBatteryLife(int batteryLife){
        this.batteryLife = batteryLife;
    }

    public int getBatteryLife(){
        return this.batteryLife;
    }

    public void setNightVision(boolean nightVision){
        this.nightVision = nightVision;
    }

    public boolean getStatus(){
        return status;
    }

    public void recordOn(boolean isDay){
        if(super.getConnectionStatus()){
            if (isDay){
                if(status)
                    System.out.println("Smart Camera - "+ super.getAlias() + " has been already turned on");
                else{
                    this.status = true;
                    System.out.println("Smart Camera - "+ super.getAlias() + " is turned on now");
                }
            }
            else{
                if(nightVision){
                    if(status)
                        System.out.println("Smart Camera - "+ super.getAlias() + " has been already turned on");
                    else{
                        this.status = true;
                        System.out.println("Smart Camera - "+ super.getAlias() + " is turned on now");
                    }
                }
                else
                    System.out.println("Sorry! Smart Camera - "+ super.getAlias() + " does not have night vision feature.");
            }

        }
    }

    public void recordOff(){
        if(super.getConnectionStatus()){
            if(status){
                this.status = false;
                System.out.println("Smart Camera - "+ super.getAlias() + " is turned off now");
            }
            else
                System.out.println("Smart Camera - "+ super.getAlias() + " has been already turned off");
        }
    }

    public boolean testObject(){
        if(super.getConnectionStatus()){
            super.SmartObjectToString();
            System.out.println("Test is starting for SmartCamera day time");
            recordOn(true);
            recordOff();
            System.out.println("Test is starting for SmartCamera night time");
            recordOn(false);
            recordOff();
            System.out.println("Test completed for SmartCamera");
            return true;
        }
        else
            return false;
    }

    public boolean shutDownObject(){
        if(getConnectionStatus()){
            SmartObjectToString();
            recordOff();
            return true;
        }
        else
            return false;
    }

    public boolean controlMotion(boolean hasMotion, boolean isDay){
        if(hasMotion)
            System.out.println("Motion detected!");
        else 
            System.out.println("Motion not detected!");
        if(isDay)
            recordOn(isDay);
        else{
            if(nightVision)
                recordOn(isDay);
        }

        return true;
    }

    public int compareTo(SmartCamera smartcamera){
        if(this.batteryLife > smartcamera.getBatteryLife())
            return 1;
        else
            return -1;
    }

    public String toString(){
        String s = "SmartCamera -> "+ this.getAlias() + "'s battery life is " + this.batteryLife + " status is " + ((this.status == true) ? "recording": "not recording");
        return s;
    }
}
