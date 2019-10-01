package FlyBehaviour;
import Message.*;

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
        message=new MoveForward();
        message.doAction(droneCommunicator,droneState);
        message= new MoveLeft();
        message.doAction(droneCommunicator,droneState);
        message=new MoveBackward();
        message.doAction(droneCommunicator,droneState);
    }

}
