package ReadMissionFile;

import Communicator.DroneCommunicator;
import Message.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public abstract class ReadMissionFile {
//    public abstract void readFile(DroneCommunicator droneCommunicator) throws Exception;

    public abstract void readFile(DroneCommunicator droneCommunicator) throws Exception;

    public void executeMission(DroneCommunicator droneCommunicator, String[] result) throws Exception {
        Message message;
        Scanner scan= new Scanner(System.in);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            if(result[i].equals("battery?")){
                message= new Battery();
                message.doAction(droneCommunicator);
//                String battery= new Battery().getBattery();
//                System.out.println("Battery percentage= "+battery);
            }
            else if (result[i].equals("takeoff")) {
                message = new TakeOff();
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("flip")) {
                System.out.print("Flip in direction: f,b,r,l->");
                String direction= scan.next();
                message = new Flip(direction);
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("cw")) {
                System.out.print("Rotate x degrees clockwise. Enter x=");
                int x= scan.nextInt();
                message = new RotateClockWise(x);
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("ccw")) {
                System.out.print("Rotate x degrees anti-clockwise. Enter x=");
                int x= scan.nextInt();
                message = new RotateAntiClockWise(x);
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("up")) {
                System.out.print("Move x cm up. Enter x=");
                int x= scan.nextInt();
                message = new MoveUp(x);
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("right")) {
                System.out.print("Move x cm right. Enter x=");
                int x= scan.nextInt();
                message = new MoveRight(x);
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("left")) {
                System.out.print("Move x cm left. Enter x=");
                int x= scan.nextInt();
                message = new MoveLeft(x);
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("forward")) {
                System.out.print("Move x cm forward. Enter x=");
                int x= scan.nextInt();
                message = new MoveForward(x);
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("down")) {
                System.out.print("Move x cm down. Enter x=");
                int x= scan.nextInt();
                message = new MoveDown(x);
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("back")) {
                System.out.print("Move x cm back. Enter x=");
                int x= scan.nextInt();
                message = new MoveBackward(x);
                message.doAction(droneCommunicator);
            }
            else if (result[i].equals("land")) {
                message = new Land();
                message.doAction(droneCommunicator);
            }
        }
    }

}
