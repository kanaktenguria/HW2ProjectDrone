package Message;
import Communicator.DroneCommunicator;

public class MoveBackward extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveBackward(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("back 50");
//        droneCommunicator.getState();
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
