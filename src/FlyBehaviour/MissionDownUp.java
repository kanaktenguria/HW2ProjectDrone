package FlyBehaviour;
import Message.*;

public class MissionDownUp extends FlyBehaviour {

    //    public MissionDownUpRotate(){
//
//
//    }

//    DroneCommunicator droneCommunicator= getDroneCommunicator;
//    @Override
//    public void doMission(DroneCommunicator droneCommunicator) throws Exception {
////        Message message;
//////        message= new CommandMode();
//////        message.doAction(droneCommunicator);
////        message= new TakeOff();
////        message.doAction(droneCommunicator);
////        message=new MoveDown();
////        message.doAction(droneCommunicator);
////        message= new MoveUp();
////        message.doAction(droneCommunicator);
////        message=new RotateClockWise();
////        message.doAction(droneCommunicator);
////        message= new Land();
////        message.doAction(droneCommunicator);
////        System.out.println("Mission completed.");
//    }


    @Override
    public void doMission() throws Exception {
        message=new MoveDown();
        message.doAction(droneCommunicator,droneState);
        message= new MoveUp();
        message.doAction(droneCommunicator,droneState);
//        message=new RotateClockWise();
//        message.doAction(droneCommunicator,droneState);
    }


}
