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

        droneCommunicator.sendRequest("takeoff");
        System.out.println(droneCommunicator.receiveRequest()+"received");
        double zAxis=80;
        droneState.move(0.0,0.0,zAxis);
//        droneCommunicator.getState();
        Thread.sleep(5000);
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
