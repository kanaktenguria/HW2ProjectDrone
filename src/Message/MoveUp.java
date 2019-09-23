package Message;
import Communicator.DroneCommunicator;

public class MoveUp extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveUp(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }
    int x;
    public void MoveUp(int x){
        this.x=x;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        String request= "up "+x;
        droneCommunicator.sendRequest(request);
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
