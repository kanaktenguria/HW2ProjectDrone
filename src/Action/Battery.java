package Action;

import Common.DroneCommunicator;
import Common.DroneState;

public class Battery extends Action {

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        droneCommunicator.sendRequest("battery?");
        System.out.println(droneCommunicator.receiveRequest()+"received"+". Battery:"+droneState.getBatteryPercentage());
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
