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


    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < MAX_ENEMY_TRACK_SLOTS+1; i++) {
            if(i==1){
                //Check if enemy is on circle
                s += (i==getPosition()? String.format("(X%-3c",')') : String.format("(%d%-3c",i,')'));
                continue;
            }
            if(i==getPosition()) {
                s+=String.format("|X%-3c",'|');
                continue;
            }
            s+=String.format("|%d%-3c",i,'|');
        }
        return s;
    }
}
