package Message;
import Communicator.DroneCommunicator;

public class RotateClockWise extends Message {
//    private DroneCommunicator droneCommunicator;
//    public RotateClockWise(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    int x;

    public RotateClockWise(int x) {
        this.x = x;
    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        String request= "cw "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
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
