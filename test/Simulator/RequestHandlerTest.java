package Simulator;

import Common.DroneCommunicator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestHandlerTest {
    @Test
    public void testRequestHandler() throws Exception {
        DroneCommunicator droneCommunicator= new DroneCommunicator("127.0.0.1",8787);
        RequestHandler requestHandler= new RequestHandler();
        requestHandler.selectCommand("takeoff",droneCommunicator);
        assertTrue(requestHandler.getCorrectCommand());
    }
}