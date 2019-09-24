package Message;
import Communicator.DroneCommunicator;

public class MoveDown extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveDown(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }
int x;
    public MoveDown(int x){
        this.x=x;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        String request= "down "+x;
        droneCommunicator.sendRequest(request);
        Thread.sleep(5000);
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
