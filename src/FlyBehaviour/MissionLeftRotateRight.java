package FlyBehaviour;
import Message.*;
import Communicator.DroneCommunicator;

public class MissionLeftRotateRight extends FlyBehaviour {

//    public MissionLeftRotateRight(){
//
//    }
    @Override
    public void doMission(DroneCommunicator droneCommunicator) throws Exception {
        Message message;
//        message= new CommandMode();
//        message.doAction(droneCommunicator);
        message= new TakeOff();
        message.doAction(droneCommunicator);
        message=new MoveLeft();
        message.doAction(droneCommunicator);
        message= new RotateAntiClockWise();
        message.doAction(droneCommunicator);
        message=new MoveRight();
        message.doAction(droneCommunicator);
        message= new Land();
        message.doAction(droneCommunicator);
        System.out.println("Mission completed.");
    }
}
