package Message;
import Communicator.*;

import java.nio.charset.StandardCharsets;

public abstract class Message {
//    Socket socket;
//    public Message(Socket socket){
//        this.socket = socket;
//
//    }

    public abstract void doAction(DroneCommunicator droneCommunicator) throws Exception;

//    public static Message missionAction(String[] read){
//
//        return null;
//    }

}
