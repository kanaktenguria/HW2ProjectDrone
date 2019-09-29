package Message;
import Communicator.DroneCommunicator;

public class MoveForward extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveForward(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }
int x;
    public MoveForward(int x){
        this.x=x;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        String request= "forward "+x;
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
