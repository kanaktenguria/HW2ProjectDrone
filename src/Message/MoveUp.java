package Message;
import Communicator.DroneCommunicator;

public class MoveUp extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveUp(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("up 50");
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
