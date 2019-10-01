package ReadMissionFile;

import Communicator.DroneCommunicator;
import Communicator.DroneState;
import Message.*;

import java.util.Scanner;

public abstract class ReadMissionFile {
//    public abstract void readFile(DroneCommunicator droneCommunicator) throws Exception;
    Status status;
    public abstract void readFile(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception;
//    public void setStatus(Status status){
//        this.status=status;
//    }

    public void executeMission(DroneCommunicator droneCommunicator, String[] result, DroneState droneState) throws Exception {
        Message message;
        Scanner scan= new Scanner(System.in);
//        Thread.sleep(5000);
//        System.out.println(droneState.getBatteryPercentage());


            for (int i = 0; i < result.length; i++) {
                if(droneState.getBatteryPercentage()<=10 || droneState.getHighTemperature()>=70){
                    System.out.println("Either Battery low or High temperature. Mission aborted");
                    if(droneState.hasTakenOff()==true){
                        System.out.println("Drone is landing.");
                        message = new Land();
                        message.doAction(droneCommunicator,droneState);
                    }
                    break;
                }
                else{
                    System.out.println(result[i]);
                    if(result[i].equals("battery?")){
                        message= new Battery();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("takeoff")) {
                        droneState.setHasTakenOff(true);
                        message = new TakeOff();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("flip")) {

                        if(droneState.getBatteryPercentage()<=30){
                            System.out.println("Battery low, Overriding mission.");
//                            if(direction.equals("f")){
                                message = new MoveForward();
                                message.doAction(droneCommunicator,droneState);
//                            }else if(direction.equals("b")){
//                                message = new MoveBackward();
//                                message.doAction(droneCommunicator,droneState);
//                            }else if(direction.equals("l")){
//                                message = new MoveLeft();
//                                message.doAction(droneCommunicator,droneState);
//                            }else if(direction.equals("r")){
//                                message = new MoveRight();
//                                message.doAction(droneCommunicator,droneState);
//                            }else {
//                                System.out.println("Invalid output.");
//                            }
                        }
                        else {
                            message = new Flip();
                            message.doAction(droneCommunicator,droneState);
                        }
                    }
                    else if (result[i].equals("cw")) {

                        message = new RotateClockWise();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("ccw")) {

                        message = new RotateAntiClockWise();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("up")) {

                        message = new MoveUp();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("right")) {

                        message = new MoveRight();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("left")) {

                        message = new MoveLeft();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("forward")) {

                        message = new MoveForward();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("down")) {

                        message = new MoveDown();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("back")) {

                        message = new MoveBackward();
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("land")) {
                        message = new Land();
                        message.doAction(droneCommunicator,droneState);
                    }
                }
             }
         }

}
