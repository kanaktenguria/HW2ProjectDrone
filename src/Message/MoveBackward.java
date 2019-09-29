package Message;
import Communicator.DroneCommunicator;

public class MoveBackward extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveBackward(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }
int x;
    public MoveBackward(int x){
        this.x=x;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        String request= "back "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
//        droneCommunicator.getState();
        Thread.sleep(5000);
    }

    @Override
    public String getMessageType() {
        return null;
    }


//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
