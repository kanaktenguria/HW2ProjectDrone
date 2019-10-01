package Communicator;
import FlyBehaviour.FlyBehaviour;
//import ReadMissionFile.ReadFileTemplate;
import Message.Status;
import ReadMissionFile.ReadMissionFile;
import FlyBehaviour.MissionDownUp;
import FlyBehaviour.MissionForwardLeft;
import FlyBehaviour.MissionLeftRotateRight;

import java.net.SocketException;

class Flier implements Runnable{
    private DroneCommunicator droneCommunicator;
    private DroneState droneState;
    private Status status;
    FlyBehaviour flyBehaviour;
    public void setDroneState(DroneState droneState){
        this.droneState= droneState;
    }
    public void initialize(String IPAddress, int senderPort) throws Exception {
        droneCommunicator = new DroneCommunicator(IPAddress, senderPort);
        droneCommunicator.initialize();
        droneState.setInCommandMode(true);

    }

    public void executePreExistingMission(int missionChoice) throws Exception {
        switch (missionChoice){
            case 1:
                MissionDownUp missionDownUp = new MissionDownUp();
                flyBehaviour= missionDownUp;
                break;
            case 2:
                MissionForwardLeft missionForwardLeft= new MissionForwardLeft();
                flyBehaviour=missionForwardLeft;
                break;
            case 3:
                MissionLeftRotateRight missionLeftRotateRight= new MissionLeftRotateRight();
                flyBehaviour=missionLeftRotateRight;
                break;
        }
        flyBehaviour.setDroneCommunicatorAndState(droneCommunicator,droneState);
        flyBehaviour.flyBehaviourTemplate();
    }

    void readFile(ReadMissionFile readMissionFile) throws Exception {
        readMissionFile.readFile(droneCommunicator, droneState);
   }

    @Override
    public void run() {
        DroneCommunicator State = null;
        try {
            State = new DroneCommunicator(8890);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while(true) {
            try {

//            State.initializeFlyer(8890);
                String reply = State.receiveRequest();
                this.status = new Status(reply);
                setStatus(status);
//                System.out.println(reply);

                droneState.updateFlyingInfo(this.status);
//                System.out.println(status.getBatteryPercentage());
//                System.out.println(droneState.getBatteryPercentage());
//                byte[] bytesReceived=droneCommunicator.getBytesReceived();
////                status.getMessageText();
//                status.decode(bytesReceived,0,1024);

//                System.out.println("kanak"+ reply);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStatus(Status status){
        this.status=status;
    }

}
