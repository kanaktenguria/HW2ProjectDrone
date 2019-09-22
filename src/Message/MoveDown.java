package Message;
import Communicator.DroneCommunicator;

public class MoveDown extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveDown(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("down 50");
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
