package FlyBehaviour;
import Message.*;
import Communicator.DroneCommunicator;

public class MissionDownUpRotate extends FlyBehaviour {
    private DroneCommunicator droneCommunicator;
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

//    public void setDroneCommunicator(){
//    super.setDroneCommunicator(DroneCommunicator droneCommunicator);
//    }
    @Override
    public void droneTakeoff() {

    }

    @Override
    public void doMission() throws Exception {

    }

    @Override
    public void droneLand() {

    }
}
