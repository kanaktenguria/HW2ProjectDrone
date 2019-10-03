package FlyBehaviour;
import Action.*;

public class MissionLeftRotateRight extends FlyBehaviour {

    @Override
    public void doMission() throws Exception {
        action =new MoveLeft();
        action.doAction(droneCommunicator,droneState);
        action = new RotateAntiClockWise();
        action.doAction(droneCommunicator,droneState);
        action =new MoveRight();
        action.doAction(droneCommunicator,droneState);
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
