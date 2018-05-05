package Models.Enemies;

import Models.EnemyModel;

public class SiegeTowerModel extends EnemyModel {

    public static final int SIEGE_TOWER_BASE_STRENGHT = 4;

    public SiegeTowerModel() {
        super();
        trackStrength = SIEGE_TOWER_BASE_STRENGHT;
    }

    @Override
    public String toString() {
        return String.format("%-15s" + super.toString(),"Siege Tower:");
    }
}
