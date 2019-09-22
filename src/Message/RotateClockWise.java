package Message;
import Communicator.DroneCommunicator;

public class RotateClockWise extends Message {
//    private DroneCommunicator droneCommunicator;
//    public RotateClockWise(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("cw 360");
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
