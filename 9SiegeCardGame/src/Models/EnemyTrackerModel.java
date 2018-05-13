package Models;

import Models.Enemies.BatteringRamModel;
import Models.Enemies.LadderModel;
import Models.Enemies.SiegeTowerModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int getTrebuchetCount() { return currentTrebuchets; }
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


    @Override
    public String toString() {
        String s="";
        s+="Enemy Track Card \n";

        s+=batteringRam + "\n" + ladder + "\n" + siegeTower + "\n";

        s+="Trebuchet Count: [";
        s+= getTrebuchetCount() == 0 ? "Disabled" : getTrebuchetCount() + "]\n";
        return s;
    }
}
