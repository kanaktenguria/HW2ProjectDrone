package Common;

import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroneStateTest {
    DroneState testDroneState = new DroneState();
    @Test
    void testGetterSetterInCommandMode() {
        testDroneState.setInCommandMode(true);
        assertEquals(true, testDroneState.isInCommandMode());
    }

    @Test
    void testGetSetHasTakenOff() {
        testDroneState.setInCommandMode(true);
        testDroneState.setHasTakenOff(true);
        assertEquals(true, testDroneState.hasTakenOff());
    }

    @Test
    void testUpdateFlyingInfoAndGetter() {
        Status testStatus= new Status(0,0,1,10,10,10,5,50,40,80,29,15.2,56,25.5,25.5,25.5);
        testDroneState.setInCommandMode(true);
        testDroneState.setHasTakenOff(true);
        testDroneState.updateFlyingInfo(testStatus);
        assertEquals(testStatus.getBatteryPercentage(), testDroneState.getBatteryPercentage());
        assertEquals(testStatus.getAccelerationX(), testDroneState.getAccelerationX());
        assertEquals(testStatus.getAccelerationY(), testDroneState.getAccelerationY());
        assertEquals(testStatus.getAccelerationZ(), testDroneState.getAccelerationZ());
        assertEquals(testStatus.getBarometerMeasurement(), testDroneState.getBarometerMeasurement());
        assertEquals(testStatus.getFlightDistance(), testDroneState.getFlightDistance());
        assertEquals(testStatus.getMotorTime(), testDroneState.getMotorTime());
        assertEquals(testStatus.getHeight(), testDroneState.getHeight());
        assertEquals(testStatus.getLowTemperature(), testDroneState.getLowTemperature());
        assertEquals(testStatus.getSpeedX(), testDroneState.getSpeedX());
        assertEquals(testStatus.getSpeedY(), testDroneState.getSpeedY());
        assertEquals(testStatus.getSpeedZ(), testDroneState.getSpeedZ());
        assertEquals(testStatus.getYaw(), testDroneState.getYaw());
        assertEquals(testStatus.getPitch(), testDroneState.getPitch());
        assertEquals(testStatus.getRoll(), testDroneState.getRoll());
        assertEquals(testStatus.getHighTemperature(), testDroneState.getHighTemperature());
    }

    @Test
    void testMove() {
        testDroneState.setInCommandMode(true);
        testDroneState.setHasTakenOff(true);
        testDroneState.move(0,0,10);
        testDroneState.move(10,10,0);
        assertEquals(10,testDroneState.getPositionX());
        assertEquals(10,testDroneState.getPositionY());
        assertEquals(10,testDroneState.getPositionZ());
    }

}