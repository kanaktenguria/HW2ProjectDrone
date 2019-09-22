package Message;
import Communicator.DroneCommunicator;

public class RotateAntiClockWise extends Message {
//    private DroneCommunicator droneCommunicator;
//    public RotateAntiClockWise(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("ccw 360");
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
