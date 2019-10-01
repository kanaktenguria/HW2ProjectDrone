package Message;
import Communicator.DroneCommunicator;
import Communicator.DroneState;

public class TakeOff extends Message {
//    private DroneCommunicator droneCommunicator;
//    public TakeOff(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        droneCommunicator.sendRequest("takeoff");
        System.out.println(droneCommunicator.receiveRequest()+"received");
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
