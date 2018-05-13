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
