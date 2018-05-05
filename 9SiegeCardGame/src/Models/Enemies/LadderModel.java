package Models.Enemies;

import Models.EnemyModel;

public class LadderModel extends EnemyModel {

    public static final int LADDER_BASE_STRENGHT = 3;

    public LadderModel() {
        super();
        trackStrength = LADDER_BASE_STRENGHT;
    }
}
