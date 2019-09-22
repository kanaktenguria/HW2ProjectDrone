package Message;

import Communicator.DroneCommunicator;

public class CommandMode extends Message{
//    private DroneCommunicator droneCommunicator;
//    public CommandMode() {
//        this.droneCommunicator = droneCommunicator;
//    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
        int maxRetries = 3;
        while (maxRetries > 0){
            droneCommunicator.sendRequest("command");
            String reply= droneCommunicator.receiveRequest();
            if (reply.equals("ok")) {
                System.out.println("Entering command mode.. \nSending mission commands.");
                break;
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
