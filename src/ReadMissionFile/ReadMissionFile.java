package ReadMissionFile;

import Common.DroneCommunicator;
import Common.DroneState;
import Action.*;
import Message.Status;

import java.util.Scanner;

public abstract class ReadMissionFile {
//    public abstract void readFile(DroneCommunicator droneCommunicator) throws Exception;
    Status status;
    public abstract void readFile(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception;
//    public void setStatus(Status status){
//        this.status=status;
//    }

    public Action[] executeMission(DroneCommunicator droneCommunicator, String[] result, DroneState droneState) throws Exception {

        Scanner scan= new Scanner(System.in);
            Action actionArray[]= new Action[result.length];

            for (int i = 0; i < result.length; i++) {

                    if(result[i].equals("battery?")){
                        actionArray[i]= new Battery();
                    }
                    else if (result[i].equals("takeoff")) {
                        actionArray[i] = new TakeOff();
                    }
                    else if (result[i].equals("flip")) {
                        actionArray[i] = new Flip();
                    }
                    else if (result[i].equals("cw")) {
                        actionArray[i] = new RotateClockWise();
                    }
                    else if (result[i].equals("ccw")) {
                        actionArray[i] = new RotateAntiClockWise();
                    }
                    else if (result[i].equals("up")) {
                        actionArray[i] = new MoveUp();
                    }
                    else if (result[i].equals("right")) {
                        actionArray[i] = new MoveRight();
                    }
                    else if (result[i].equals("left")) {
                        actionArray[i] = new MoveLeft();
                    }
                    else if (result[i].equals("forward")) {
                        actionArray[i] = new MoveForward();
                    }
                    else if (result[i].equals("down")) {
                        actionArray[i] = new MoveDown();
                    }
                    else if (result[i].equals("back")) {
                        actionArray[i] = new MoveBackward();
                    }
                    else if (result[i].equals("land")) {
                        actionArray[i] = new Land();
                    }
                }
            return actionArray;
         }

}
