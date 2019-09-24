package Message;
import Communicator.DroneCommunicator;

public class MoveLeft extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveLeft(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }
    int x;
    public MoveLeft(int x){
        this.x=x;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        String request= "left "+x;
        droneCommunicator.sendRequest(request);
//        droneCommunicator.getState();
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
