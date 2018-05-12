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

    //TODO: Implementar sem lista e separado?? Lista talvez seja pouco intuitivo de aceder
    private List<EnemyModel> enemies;

    public EnemyTrackerModel() {
        currentTrebuchets = MAX_TREBUCHET;
        enemies = new ArrayList<>();

        //Initial enemies
        enemies.add(new LadderModel());
        enemies.add(new BatteringRamModel());
        enemies.add(new SiegeTowerModel());

    }

    public int getTrebuchetCount() { return currentTrebuchets; }

    public int getTotalEnemies(){return enemies.size();}

    @Override
    public String toString() {
        String s="";
        s+="Enemy Track Card \n";
        for (int i = 0; i < getTotalEnemies(); i++) {
            s+=enemies.get(i)+"\n";
        }
        s+="Trebuchet Count: " + getTrebuchetCount() + "\n";
        return s;
    }
}
