package Models;

public class PlayerTackerModel {
    private int wallStrength,
                morale,
                supplies,
                tunnel,
                raidSupplies;

    public static final int MAX_PLAYER_TRACK_SLOTS = 4;
    //Used only if we choose to use an array to print status tracks
    public static final int STATUS_TRACKS = 3;
    public static final int MAX_RAIDED_SUPPLIES = 2;
    public static final int TUNEL_SIZE = 2;

    /**
     * Initial Player Tracker Values
     */
    public PlayerTackerModel() {
        //Initial Status Tracker values
        wallStrength = morale = supplies = MAX_PLAYER_TRACK_SLOTS;
        tunnel = raidSupplies = 0;
    }

    //Setters
    public void reduceWallStrength() { wallStrength = wallStrength >= 1 ? wallStrength-1:  wallStrength; }
    public void increaseWallStrength() { wallStrength = wallStrength < 4 ? wallStrength+1:  wallStrength; }

    public void reduceMorale() { morale = morale >= 1 ? morale-1:  morale; }
    public void increaseMorale() { morale = morale < 4 ? morale+1:  morale; }

    public void reduceSupplies() { supplies = supplies >= 1 ? supplies-1:  supplies; }
    public void increaseSupplies() { supplies = supplies < 4 ? supplies+1:  supplies; }

    public void reduceRaidSupplies() { raidSupplies = raidSupplies > 1 ? raidSupplies-1:  raidSupplies; }
    public void increaseRaidSupplies() { raidSupplies = raidSupplies < 2 ? raidSupplies+1:  raidSupplies; }

    //Getters
    public int getWallStrength() { return wallStrength; }
    public int getMorale() { return morale; }
    public int getSupplies() { return supplies; }
    public int getTunnel() { return tunnel; }
    public int getRaidSupplies() { return raidSupplies; }


    private String printPlayerTracker(int position){
        String s="";
        for (int i = MAX_PLAYER_TRACK_SLOTS; i >= 0; i--) {
            if(i==position) {
                s+=String.format("|X%-3c",'|');
                continue;
            }
            s+=String.format("|%d%-3c",i,'|');
        }
        return s;
    }

    @Override
    public String toString() {
        String s="";

        s+=String.format("\n%-15s","Wall Strength:");
        s+="["+getWallStrength()+"]";

        s+=String.format("\n%-15s","Morale:");
        s+="["+getMorale()+"]";

        s+=String.format("\n%-15s","Supplies:");
        s+="["+getSupplies()+"]";

        //TODO: Implement TUNNEL
        s+=String.format("\n%-15s","Tunnel:");
        for (int i = 0; i <= TUNEL_SIZE+1; i++) {
            if(i==getTunnel()){
                s+=String.format("|X%-3c",'|');
                continue;
            }
            if (i==0){
                s+=String.format("|C%-3c",'|');
                continue;
            }
            s+= (i<=TUNEL_SIZE) ? String.format("|T%-3c",'|') : String.format("|E%-3c",'|');
        }


        s+=String.format("\n%-15s","RaidedSupplies:");
        s+="["+getRaidSupplies()+"]";

        return s;
    }


}
