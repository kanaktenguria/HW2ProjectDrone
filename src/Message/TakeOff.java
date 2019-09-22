package Message;
import Communicator.DroneCommunicator;

public class TakeOff extends Message {
//    private DroneCommunicator droneCommunicator;
//    public TakeOff(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("takeoff");
//        droneCommunicator.getState();
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
