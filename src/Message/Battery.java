package Message;

import Common.DroneCommunicator;
import Common.DroneState;

public class Battery extends Message {
//    String battery=null;
    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        droneCommunicator.sendRequest("battery?");
        System.out.println(droneCommunicator.receiveRequest()+"received"+". Battery:"+droneState.getBatteryPercentage());
    }

    @Override
    public String getMessageType() {
        return null;
    }
//    public String getBattery(){
//        return battery;
//    }
}
