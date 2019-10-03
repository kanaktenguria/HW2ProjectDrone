package FlyBehaviour;
import Action.*;

public class MissionForwardLeft extends FlyBehaviour {
//    public MissionForwardLeft(){
//
//    }
//    @Override
//    public void doMission(DroneCommunicator droneCommunicator) throws Exception {
//        Message message;
////        message= new CommandMode();
////        message.doAction(droneCommunicator);
////        byte[] buf= new byte[256];
////        message= new TakeOff();
////        message.doAction(droneCommunicator);
//////        message.encode();
//////        droneCommunicator.getState();

//        droneCommunicator.getState();
////        message= new Land();
////        message.doAction(droneCommunicator);
////        droneCommunicator.getState();
//        System.out.println("Mission completed.");
//    }

    @Override
    public void doMission() throws Exception {
        action =new MoveForward();
        action.doAction(droneCommunicator,droneState);
        action = new MoveLeft();
        action.doAction(droneCommunicator,droneState);
        action =new MoveBackward();
        action.doAction(droneCommunicator,droneState);
    }

}
