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
                        System.out.print("Flip in direction: f,b,r,l->");
                        String direction= scan.next();
                        if(droneState.getBatteryPercentage()<=30){
                            System.out.println("Battery low, Overriding mission.");
                            if(direction.equals("f")){
                                System.out.print("Move x cm forward. Enter x=");
                                int x= scan.nextInt();
                                message = new MoveForward(x);
                                message.doAction(droneCommunicator,droneState);
                            }else if(direction.equals("b")){
                                System.out.print("Move x cm back. Enter x=");
                                int x= scan.nextInt();
                                message = new MoveBackward(x);
                                message.doAction(droneCommunicator,droneState);
                            }else if(direction.equals("l")){
                                System.out.print("Move x cm left. Enter x=");
                                int x= scan.nextInt();
                                message = new MoveLeft(x);
                                message.doAction(droneCommunicator,droneState);
                            }else if(direction.equals("r")){
                                System.out.print("Move x cm right. Enter x=");
                                int x= scan.nextInt();
                                message = new MoveRight(x);
                                message.doAction(droneCommunicator,droneState);
                            }else {
                                System.out.println("Invalid output.");
                            }
                        }
                        else {
                            message = new Flip(direction);
                            message.doAction(droneCommunicator,droneState);
                        }
                    }
                    else if (result[i].equals("cw")) {
                        System.out.print("Rotate x degrees clockwise. Enter x=");
                        int x= scan.nextInt();
                        message = new RotateClockWise(x);
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("ccw")) {
                        System.out.print("Rotate x degrees anti-clockwise. Enter x=");
                        int x= scan.nextInt();
                        message = new RotateAntiClockWise(x);
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("up")) {
                        System.out.print("Move x cm up. Enter x=");
                        int x= scan.nextInt();
                        message = new MoveUp(x);
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("right")) {
                        System.out.print("Move x cm right. Enter x=");
                        int x= scan.nextInt();
                        message = new MoveRight(x);
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("left")) {
                        System.out.print("Move x cm left. Enter x=");
                        int x= scan.nextInt();
                        message = new MoveLeft(x);
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("forward")) {
                        System.out.print("Move x cm forward. Enter x=");
                        int x= scan.nextInt();
                        message = new MoveForward(x);
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("down")) {
                        System.out.print("Move x cm down. Enter x=");
                        int x= scan.nextInt();
                        message = new MoveDown(x);
                        message.doAction(droneCommunicator,droneState);
                    }
                    else if (result[i].equals("back")) {
                        System.out.print("Move x cm back. Enter x=");
                        int x= scan.nextInt();
                        message = new MoveBackward(x);
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
