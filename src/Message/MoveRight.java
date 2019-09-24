package Message;
import Communicator.DroneCommunicator;

public class MoveRight extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveRight(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }
int x;
    public MoveRight(int x){
        this.x=x;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        String request= "right "+x;
        droneCommunicator.sendRequest(request);
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
