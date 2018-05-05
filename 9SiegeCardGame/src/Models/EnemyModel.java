package Models;

import SiegeCard.Util.game_constants;

public class EnemyModel implements game_constants {
    protected int position;
    protected int trackStrength;

    public EnemyModel() {
        position = MAX_TRACK_SLOTS;
    }

    public int getPosition() { return position; }
    public int getTrackStrength() { return trackStrength; }

    public void incrementPosition(){this.position+=1;}
    public void decrementPosition(){this.position+=1;}

    /**
     * Checks if Enemy unit is on Close Combat
     * @return True if on Close Combat
     */
    public boolean onCloseCombat(){return getPosition()==0;}
    //TODO:If enemy onCloseCombat strength equals 4
}
