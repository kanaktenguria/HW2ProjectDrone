package Message;

import Communicator.DroneCommunicator;

public class Battery extends Message {
//    String battery=null;
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("battery?");
        System.out.println(droneCommunicator.receiveRequest()+"received");
    }

    @Override
    public String getMessageType() {
        return null;
    }
//    public String getBattery(){
//        return battery;
//    }
}
