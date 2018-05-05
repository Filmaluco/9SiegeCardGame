package Models;

public class GameDataModel {

    //is it worth having protected? because I want to acess their functions
    public EnemyTrackerModel EnemyTracker;
    public PlayerModel Player;
    public DiceModel Dice;
    //todo: implement deck ... (make it a collection)
    private int currDay;
    private int currTurn;

    //TODO: Change Constructor
    public GameDataModel() {
        Player = new PlayerModel();
        currDay = 1;
        currTurn = 1;
    }
}
