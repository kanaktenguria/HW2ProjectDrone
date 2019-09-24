package Message;
import Communicator.DroneCommunicator;

public class RotateAntiClockWise extends Message {
//    private DroneCommunicator droneCommunicator;
//    public RotateAntiClockWise(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }
int x;

    public RotateAntiClockWise(int x) {
        this.x = x;
    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        String request= "ccw "+x;
        droneCommunicator.sendRequest(request);
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
