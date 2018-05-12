package Models;

public class GameDataModel {

    //is it worth having protected? because I want to acess their functions
    public EnemyTrackerModel EnemyTracker;
    public PlayerModel Player;
    public DiceModel Dice;
    //todo: implement deck ... (make it a collection)

    private int currentDay,
                currentTurn;

    static final int LAST_DAY = 3;
    static final int LAST_TURN = 7;

    //TODO: Change Constructor
    public GameDataModel() {
        Player = new PlayerModel();
        EnemyTracker = new EnemyTrackerModel();
        currentDay = 1;
        currentTurn = 1;
    }

    public EnemyTrackerModel getEnemyTracker() { return EnemyTracker; }
    public PlayerModel getPlayer() { return Player; }
    public DiceModel getDice() { return Dice; }
    public int getCurrentDay() { return currentDay; }
    public int getCurrentTurn() { return currentTurn; }

    @Override
    public String toString() {
        String s="";
        s+=EnemyTracker.toString()+"\n";
        s+=Player.toString()+"\n";
        s+="Day: " + "[" + getCurrentDay() + "]" + " Turn: " + "[" + getCurrentTurn() + "]" + " Action Points: " + "[" + Player.getActionPoints() + "]\n1";
        s+="Card:\n";
        //s+="Name: " + Deck[currentDay].getName;
        //s+="Effect: " + Deck[currentDay].getDesc;
        return s;
    }
}