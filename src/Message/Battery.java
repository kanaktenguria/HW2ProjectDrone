package Message;

import Communicator.DroneCommunicator;

public class Battery extends Message {
//    String battery=null;
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("battery?");
        String battery= droneCommunicator.receiveRequest();
        System.out.println("Battery percentage= "+ battery);
    }
//    public String getBattery(){
//        return battery;
//    }
}
