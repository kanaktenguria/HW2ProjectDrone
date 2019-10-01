package FlyBehaviour;
import Message.*;

public class MissionLeftRotateRight extends FlyBehaviour {

    @Override
    public void doMission() throws Exception {
        message=new MoveLeft();
        message.doAction(droneCommunicator,droneState);
        message= new RotateAntiClockWise();
        message.doAction(droneCommunicator,droneState);
        message=new MoveRight();
        message.doAction(droneCommunicator,droneState);
    }


//    public MissionLeftRotateRight(){
//
//    }
//    @Override
//    public void doMission(DroneCommunicator droneCommunicator) throws Exception {
//        Message message;
////        message= new CommandMode();
////        message.doAction(droneCommunicator);
//        message= new TakeOff();
//        message.doAction(droneCommunicator);

//        message= new Land();
//        message.doAction(droneCommunicator);
//        System.out.println("Mission completed.");
//    }
}
