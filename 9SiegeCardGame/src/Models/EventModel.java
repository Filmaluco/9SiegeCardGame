package Models;

public abstract class EventModel {

    protected int eventID;

    protected String eventName,
                     eventDescription;

    protected int eventActionPoints;

    protected boolean   ladderMovement = false,
                        batteringRamMovement = false,
                        siegeTowerMovement = false,
                        slowestUnitMovement = false;

    boolean hasMovement(){
        return (ladderMovement && batteringRamMovement && siegeTowerMovement && slowestUnitMovement);
    }

    public abstract DiceModel applyEvent(GameDataModel data);

    public String getName() {
        return eventName;
    }

    public String getDescription() {
        return eventDescription;
    }

    public int getActionPoints() {
        return eventActionPoints;
    }
}
