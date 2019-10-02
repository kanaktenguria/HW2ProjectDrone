package Message;
import Common.DroneCommunicator;
import Common.DroneState;

public class TakeOff extends Message {
//    private DroneCommunicator droneCommunicator;
//    public TakeOff(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        if(droneState.getBatteryPercentage()<=10 || droneState.getHighTemperature()>=70) {
            System.out.println("Either Battery low or High temperature. Mission aborted");
        }else {
            droneState.setHasTakenOff(true);
            droneCommunicator.sendRequest("takeoff");
            System.out.println(droneCommunicator.receiveRequest() + "received");
            double zAxis = 80;
            droneState.move(0.0, 0.0, zAxis);
            Thread.sleep(5000);
        }
    }

    @Override
    public String getMessageType() {
        return null;
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
