package Simulator;

import Communicator.DroneCommunicator;

public class CommandHandler {
    public void selectCommand(String reply, DroneCommunicator droneCommunicator) throws Exception {
        String[] keyword=reply.split(" ");

        Boolean correctCommand= false;
        if (keyword[0].equals("command")) {
            System.out.println("Entering command mode.");
            correctCommand=true;
        }
        else if (keyword[0].equals("takeoff")) {
            System.out.println("Drone has taken off.");
            correctCommand=true;
        }
        else if (keyword[0].equals("up")) {
            System.out.println("Drone has moved "+keyword.toString()+"cm");
            correctCommand=true;
        }
        else if (keyword[0].equals("right")) {
            System.out.println("Drone has moved "+keyword+"cm");
            correctCommand=true;
        }
        else if (keyword[0].equals("left")) {
            System.out.println("Drone has moved "+keyword.toString()+"cm");
            correctCommand=true;
        }
        else if (keyword[0].equals("down")) {
            System.out.println("Drone has moved "+keyword.toString()+"cm");
            correctCommand=true;
        }
        else if (keyword[0].equals("back")) {
            System.out.println("Drone has moved "+keyword.toString()+"cm");
            correctCommand=true;
        }
        else if (keyword[0].equals("forward")) {
            System.out.println("Drone has moved "+keyword.toString()+"cm");
            correctCommand=true;
        }
        else if (keyword[0].equals("ccw")) {
            System.out.println("Drone has rotated anti clockwise"+keyword[1]+"degree");
            correctCommand=true;
        }
        else if (keyword[0].equals("cw")) {
            System.out.println("Drone has rotated clockwise"+keyword[1]+"degree");
            correctCommand=true;
        }
        else if (keyword[0].equals("flip")) {
            System.out.println("Drone has moved "+keyword.toString()+"direction");
            correctCommand=true;
        }
        else if (keyword[0].equals("land")) {
            System.out.println("Drone has landed off.");
            correctCommand=true;
        }
        else if (keyword[0].equals("battery?")) {
            System.out.println("Battery query");
            correctCommand=true;
        }
        else {
        System.out.println("Command not recognized");
        }
        if(correctCommand==true){
            droneCommunicator.sendRequest("ok");
        }
        else{
            droneCommunicator.sendRequest("error");
        }
    }
}
