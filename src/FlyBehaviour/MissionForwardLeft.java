package FlyBehaviour;
import Message.*;
import Communicator.DroneCommunicator;

public class MissionForwardLeft extends FlyBehaviour {
//    public MissionForwardLeft(){
//
//    }
    @Override
    public void doMission(DroneCommunicator droneCommunicator) throws Exception {
        Message message;
//        message= new CommandMode();
//        message.doAction(droneCommunicator);
//        byte[] buf= new byte[256];
//        message= new TakeOff();
//        message.doAction(droneCommunicator);
////        message.encode();
////        droneCommunicator.getState();
//        message=new MoveForward();
//        message.doAction(droneCommunicator);
////        droneCommunicator.getState();
//        message= new MoveLeft();
//        message.doAction(droneCommunicator);
////        droneCommunicator.getState();
//        message=new MoveBackward();
//        message.doAction(droneCommunicator);
////        droneCommunicator.getState();
//        message= new Land();
//        message.doAction(droneCommunicator);
//        droneCommunicator.getState();
        System.out.println("Mission completed.");
    }
}
