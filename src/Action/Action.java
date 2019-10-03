package Action;
import Common.DroneCommunicator;
import Common.DroneState;

public abstract class Action {
    public abstract void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception;

    public abstract String getMessageType();

    protected String getMessageText() { return getMessageType(); }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), getMessageText());
    }

}
