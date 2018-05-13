package Models;

public class EnemyModel {
    protected int position;
    protected int trackStrength;
    protected boolean status;

    public static final int MAX_ENEMY_TRACK_SLOTS = 4;
    public static final int CLOSE_COMBAT_STRENGTH = 4;

    public EnemyModel() {
        position = MAX_ENEMY_TRACK_SLOTS;
        status = true;
    }

    public int getPosition() { return position; }
    public int getStrength() { return  onCloseCombat() ? 4 : trackStrength; }

    //TODO: Add exception to check if bellow 0 or above MAX
    public void advance(){position = position < 4 ? position : position+1;}
    public void retreat(){position = position > 0 ? position : position-1;}


    public void remove(){status = false;}
    public boolean inGame(){return status;}

    /**
     * Checks if Enemy unit is on Close Combat
     * @return True if on Close Combat
     */
    public boolean onCloseCombat(){return getPosition()==0;}
    public boolean onStartingSpace(){return getPosition()==MAX_ENEMY_TRACK_SLOTS;}


    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < MAX_ENEMY_TRACK_SLOTS+1; i++) {
            if(i==1){
                //Check if enemy is on circle
                s += (i==getPosition()? String.format("(X%-3c",')') : String.format("(%c%-3c",' ',')'));
                continue;
            }
            if(i==getPosition()) {
                s+=String.format("|X%-3c",'|');
                continue;
            }
            s+=String.format("|%c%-3c",' ','|');
        }


        return s;
    }
}
