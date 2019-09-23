package Message;
import Communicator.DroneCommunicator;

public class Land extends Message {
//    private DroneCommunicator droneCommunicator;
//    public Land(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        droneCommunicator.sendRequest("land");
//        droneCommunicator.getState();
        Thread.sleep(5000);
    }


//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
