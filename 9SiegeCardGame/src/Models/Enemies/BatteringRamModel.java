package Models.Enemies;

import Models.EnemyModel;

public class BatteringRamModel extends EnemyModel {

    public static final int BATTERING_RAM_BASE_STRENGHT = 2;

    public BatteringRamModel() {
        super();
        trackStrength = BATTERING_RAM_BASE_STRENGHT;
    }

    @Override
    public String toString() {
        return String.format("%-15s" + super.toString(), "Battering Ram:") ;
    }
}
