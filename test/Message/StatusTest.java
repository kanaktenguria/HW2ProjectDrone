package Message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {
    Status testStatus= new Status(0,0,1,10,10,10,5,50,40,80,29,15.2,56,25.5,25.5,25.5);
    @Test
    public void testGetter(){
        assertEquals(testStatus.getMessageType(),"status");
        assertEquals(testStatus.getBatteryPercentage(),29);
        assertEquals(testStatus.getAccelerationX(),25.5);
        assertEquals(testStatus.getAccelerationY(),25.5);
        assertEquals(testStatus.getAccelerationZ(),25.5);
        assertEquals(testStatus.getBarometerMeasurement(),15.2);
        assertEquals(testStatus.getFlightDistance(),40);
        assertEquals(testStatus.getMotorTime(),56);
        assertEquals(testStatus.getHeight(),80);
        assertEquals(testStatus.getLowTemperature(),5);
        assertEquals(testStatus.getSpeedX(),10);
        assertEquals(testStatus.getSpeedY(),10);
        assertEquals(testStatus.getSpeedZ(),10);
        assertEquals(testStatus.getYaw(),1);
        assertEquals(testStatus.getPitch(),0);
        assertEquals(testStatus.getRoll(),0);
        assertEquals(testStatus.getHighTemperature(),50);
    }
}