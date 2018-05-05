package Models;

public class PlayerModel {


    private String name;
    private PlayerTackerModel tracker;

    //TODO: Implement actionPoints
    //Player action points set by the event
    private int actionPoints;

    public PlayerModel(){
        tracker = new PlayerTackerModel();
        name = null;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean hasName(){return name!=null;}
    
    public int getActionPoints() { return actionPoints; }
    public void setActionPoints(int actionPoints) { this.actionPoints = actionPoints; }

    @Override
    public String toString() {
        String s = "";
        s+=getName()+" Status Track Card \n";
        s+=tracker.toString()+"\n";
        return s;
    }
}
