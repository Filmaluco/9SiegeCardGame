package Models;

public class EnemyModel {
    protected int position;
    protected int trackStrength;

    public static final int MAX_ENEMY_TRACK_SLOTS = 4;
    public static final int CLOSE_COMBAT_STRENGTH = 4;

    public EnemyModel() {
        position = MAX_ENEMY_TRACK_SLOTS;
    }

    public int getPosition() { return position; }
    public int getTrackStrength() { return trackStrength; }

    //TODO: Add exception to check if bellow 0 or above MAX
    public void incrementPosition(){this.position+=1;}
    public void decrementPosition(){this.position-=1;}

    /**
     * Checks if Enemy unit is on Close Combat
     * @return True if on Close Combat
     */
    public boolean onCloseCombat(){return getPosition()==0;}
    //TODO:If enemy onCloseCombat strength equals 4
}
