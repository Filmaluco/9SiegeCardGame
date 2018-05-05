package Models;

public class GameDataModel {

    //is it worth having protected? because I want to acess their functions
    public EnemyTrackerModel EnemyTracker;
    public PlayerModel Player;
    public DiceModel Dice;
    //todo: implement deck ... (make it a collection)
    public static final int LAST_DAY = 3;
    public static final int LAST_TURN = 7;

    private int currentDay;
    private int currentTurn;

    //TODO: Change Constructor
    public GameDataModel() {
        Player = new PlayerModel();
        currentDay = 1;
        currentTurn = 1;
    }
}
