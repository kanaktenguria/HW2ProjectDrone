package Message;
import Communicator.DroneCommunicator;

public class MoveForward extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveForward(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception{
        droneCommunicator.sendRequest("forward 50");
//        droneCommunicator.getState();
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
