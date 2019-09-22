package Message;
import Communicator.DroneCommunicator;

public class MoveRight extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveRight(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("right 50");
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
