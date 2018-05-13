package Models.Enemies;

import Models.EnemyModel;

public class LadderModel extends EnemyModel {

    public static final int LADDER_BASE_STRENGHT = 2;

    public LadderModel() {
        super();
        trackStrength = LADDER_BASE_STRENGHT;
    }

    @Override
    public String toString() {
        return String.format("%-15s" + super.toString(), "Ladder:");
    }
}
