package Models;

import SiegeCard.Util.constants;

public class GameDataModel implements constants {

    //is it worth having protected? because I want to acess their functions
    public EnemyTrackerModel EnemyTracker;
    public PlayerModel Player;
    public DiceModel Dice;
    public DeckModel Deck;

    private int currentDay,
                currentTurn;

    //TODO: Change Constructor
    public GameDataModel() {
        Player = new PlayerModel();
        EnemyTracker = new EnemyTrackerModel();
        Deck = new DeckModel();
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
        Dice = Deck.Draw().applyEvent(this);
        String s="";
        s+=EnemyTracker.toString()+"\n";
        s+=Player.toString()+"\n";
        s+="Day: " + "[" + getCurrentDay() + "]" + " Turn: " + "[" + getCurrentTurn() + "]" + " Action Points: " + "[" + Player.getActionPoints() + "]\n";
        s+="Card:\n";
        s+="Name: " + Deck.getLastCardName() + "\n";
        s+="Effect: \n" + Deck.getLastCardDescription() + "\n";
        return s;
    }
}