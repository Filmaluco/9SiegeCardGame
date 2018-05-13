package Models;

import Models.Enemies.BatteringRamModel;
import Models.Enemies.LadderModel;
import Models.Enemies.SiegeTowerModel;

public class EnemyTrackerModel {
    //TODO: Make a list of enemies, add Trebuchet Count
    public static final int MAX_TREBUCHET = 3;
    private int currentTrebuchets;


    public BatteringRamModel batteringRam;
    public LadderModel ladder;
    public SiegeTowerModel siegeTower;

    public EnemyTrackerModel() {
        currentTrebuchets = MAX_TREBUCHET;
        batteringRam = new BatteringRamModel();
        ladder = new LadderModel();
        siegeTower = new SiegeTowerModel();

    }

    public int getTrebuchets() { return currentTrebuchets; }
    public boolean hasTrebuchets(){ return currentTrebuchets > 0;}
    public int addTrebuchet(){ return currentTrebuchets = currentTrebuchets < 3 ? currentTrebuchets+1 : currentTrebuchets;}

    public void moveSlowest(){
        int nr_enemies = 3;
        boolean[] slowest = new boolean[nr_enemies]; //they start at false
        int more_slow = 0;

        if(batteringRam.position >= more_slow) { more_slow = batteringRam.position; }
        if(ladder.position >= more_slow) { more_slow = ladder.position; }
        if(siegeTower.position >= more_slow) { more_slow = siegeTower.position; }

        int i = 0;
        if(batteringRam.position == more_slow) {slowest[i] = true;} i++;
        if(ladder.position == more_slow) {slowest[i] = true;} i++;
        if(siegeTower.position == more_slow) {slowest[i] = true;};

        i = 0;
        if(slowest[i]){batteringRam.advance();} i++;
        if(slowest[i]){ladder.advance();} i++;
        if(slowest[i]){siegeTower.advance();}
    }

    public int getCloseCombatEnemies(){
        return (batteringRam.onCloseCombat() ? 1 : 0) + (ladder.onCloseCombat() ? 1 : 0) + (siegeTower.onCloseCombat() ? 1 : 0);
    }


    @Override
    public String toString() {
        String s="";
        s+="Enemy Track Card \n";

        s+=batteringRam + "\n" + ladder + "\n";
        s+= siegeTower.inGame() ? siegeTower : "";

        s+="\nTrebuchet Count: [";
        s+= getTrebuchets() == 0 ? "Disabled" : getTrebuchets() + "]\n";
        return s;
    }
}
