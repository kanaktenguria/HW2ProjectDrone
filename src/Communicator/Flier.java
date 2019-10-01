package Communicator;
import FlyBehaviour.FlyBehaviour;
//import ReadMissionFile.ReadFileTemplate;
import Message.Message;
import Message.Status;
import ReadMissionFile.ReadMissionFile;

import java.io.IOException;
import java.net.SocketException;

class Flier implements Runnable{
    private DroneCommunicator droneCommunicator;
    private DroneState droneState;
    private Status status;

    public void setDroneState(DroneState droneState){
        this.droneState= droneState;
    }
    public void initialize(String IPAddress, int senderPort) throws Exception {
        droneCommunicator = new DroneCommunicator(IPAddress, senderPort);
        droneCommunicator.initialize();
        droneState.setInCommandMode(true);

    }

//    void droneTakeoff(FlyBehaviour flyBehaviour) throws Exception {
//        flyBehaviour.droneTakeoff(droneCommunicator);
//    }
//    void doMission(FlyBehaviour flyBehaviour) throws Exception {
//        flyBehaviour.doMission(droneCommunicator);
//    }

    void readFile(ReadMissionFile readMissionFile) throws Exception {
//        System.out.println("Battery="+ status.getBatteryPercentage() );


//        System.out.println(droneState.getBatteryPercentage());
        readMissionFile.readFile(droneCommunicator, droneState);
        
//        Message message= Message.missionAction(result);

    }
//
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
//    void getState() throws Exception{
//
//    }
}
