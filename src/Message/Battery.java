package Message;

import Communicator.DroneCommunicator;

public class Battery {
//    String battery=null;

    public void doAction() throws Exception {
        try {
            DroneCommunicator drone = new DroneCommunicator("127.0.0.1", 8889);
            drone.sendRequest("battery?");
            String battery = drone.receiveRequest();
            System.out.println("Battery percentage= " + battery);
        }catch(NullPointerException e){
            System.out.println(e);
        }
    }
//    public String getBattery(){
//        return battery;
//    }
}