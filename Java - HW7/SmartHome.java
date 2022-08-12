/*
Name Surname : Hakkı Kokur
Student ID : 150120033
*/ 

import java.util.ArrayList;

public class SmartHome {
    ArrayList<SmartObject> smartObjectList = new ArrayList<>();
    
    SmartHome(){}

    public boolean addSmartObject(SmartObject smartObject){
        smartObjectList.add(smartObject);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Adding new SmartObject");
        System.out.println("--------------------------------------------------------------------------");
        if(smartObject.connect("10.0.0.10" + smartObjectList.indexOf(smartObject)))
            System.out.println(smartObject.getAlias() + " connection established");
        System.out.println("Test is starting for "+ smartObject.getTypeOfDevice());
        smartObject.testObject();
        System.out.println();
        return true;
    }

    public boolean removeSmartObject(SmartObject smartObject){
        smartObjectList.remove(smartObject);
        return true;
    }

    public void controlLocation(Boolean onCome){
        if(onCome){
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("LocationControl : OnCome");
            System.out.println("--------------------------------------------------------------------------");
            for(SmartObject smartObject: smartObjectList){
                if (smartObject instanceof LocationControl){
                    System.out.println("On Come -> "+ smartObject.getTypeOfDevice() +" - "+smartObject.getAlias() );
                    ((LocationControl)smartObject).onCome();
                }
                
            }
        }
        else{
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("LocationControl : onLeave");
            System.out.println("--------------------------------------------------------------------------");
            for(SmartObject smartObject: smartObjectList){
                if (smartObject instanceof LocationControl){
                    System.out.println("On Leave -> "+ smartObject.getTypeOfDevice() +" - "+smartObject.getAlias() );
                    ((LocationControl)smartObject).onLeave();
                }
                
            }
        }
    }

    public void controlMotion(boolean hasMotion, boolean isDay){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("MotionControl: HasMotion, isDay");
        System.out.println("--------------------------------------------------------------------------");
        for(SmartObject smartObject: smartObjectList){
            if (smartObject instanceof MotionControl){
                ((MotionControl)smartObject).controlMotion(hasMotion, isDay);
            }   
        }
    }

    public void controlProgrammable(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: runProgram");
        System.out.println("--------------------------------------------------------------------------");
        for(SmartObject smartObject: smartObjectList){
            if (smartObject instanceof Programmable){
                ((Programmable)smartObject).runProgram();
            }   
        }   
    }

    public void controlTimer(int seconds){
        if(seconds > 0){
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Programmable: Timer = "+ seconds+" seconds");
            System.out.println("--------------------------------------------------------------------------");
            for(SmartObject smartObject: smartObjectList){
                if (smartObject instanceof Programmable){
                    ((Programmable)smartObject).setTimer(seconds);;
                }   
            }
        }
        else{
            for(SmartObject smartObject: smartObjectList){
                if (smartObject instanceof Programmable){
                    ((Programmable)smartObject).cancelTimer();;;
                }   
            }
        }
    }

    public void controlTimerRandomly(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: Timer = 5 or 10 seconds randomly");
        System.out.println("--------------------------------------------------------------------------");
        for(SmartObject smartObject: smartObjectList){
            if (smartObject instanceof Programmable){
                long number = Math.round(Math.random());   // multiply Math.random() with 2 if you want call calcenTimer randomly
                if(number == 0)
                    ((Programmable)smartObject).setTimer(10);
                else if(number == 1)
                    ((Programmable)smartObject).setTimer(5);
                else
                    ((Programmable)smartObject).cancelTimer();
            }   
        }
    }

    public void sortCameras(){
        ArrayList<SmartCamera> cameras = new ArrayList<>();
        for(SmartObject smartObject:smartObjectList){
            if(smartObject instanceof Comparable){
                cameras.add((SmartCamera)smartObject);
            }
        }

        for(int i = 0; i < cameras.size(); i++){
            SmartCamera obj =  cameras.get(i);
            SmartCamera minObj = obj;
            int c = i;
            for(int j = i; j < cameras.size(); j++){
                if((minObj.compareTo(cameras.get(j)) == 1)){ 
                    minObj = cameras.get(j);
                    c = j;
                }
            }

            cameras.set(c, obj);
            cameras.set(i, minObj);
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort Smart Cameras");
        System.out.println("--------------------------------------------------------------------------");
        for(SmartCamera smartObject:cameras){
            System.out.println("SmartCamera -> " + smartObject.getAlias() + "'s battery life is " + smartObject.getBatteryLife() + " status is "+ ((smartObject.getStatus() == true) ? "recording": "not recording"));
        }
    }


}
