package Models;

public class PlayerTackerModel {
    private int wallStrength,
                morale,
                supplies,
                tunnel,
                raidSupplies;

    public static final int MAX_PLAYER_TRACK_SLOTS = 4;
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

    public int getWallStrength() { return wallStrength; }
    public int getMorale() { return morale; }
    public int getSupplies() { return supplies; }
    public int getTunnel() { return tunnel; }
    public int getRaidSupplies() { return raidSupplies; }

    @Override
    public String toString() {
        String s="";
        //TODO: Simplify add function to print
        s+=String.format("%-15s","Wall Strength:");
        for (int i = MAX_PLAYER_TRACK_SLOTS; i >= 0; i--) {
            if(i==getWallStrength()) {
                s+=String.format("|X%-3c",'|');
                continue;
            }
            s+=String.format("|%d%-3c",i,'|');
        }

        s+=String.format("\n%-15s","Morale:");
        for (int i = MAX_PLAYER_TRACK_SLOTS; i >= 0; i--) {
            if(i==getMorale()) {
                s+=String.format("|X%-3c",'|');
                continue;
            }
            s+=String.format("|%d%-3c",i,'|');
        }

        s+=String.format("\n%-15s","Supplies:");
        for (int i = MAX_PLAYER_TRACK_SLOTS; i >= 0; i--) {
            if(i==getSupplies()) {
                s+=String.format("|X%-3c",'|');
                continue;
            }
            s+=String.format("|%d%-3c",i,'|');
        }

        //TODO: Implement TUNNEL

        s+=String.format("\n%-15s","RaidedSupplies:");
        for (int i = MAX_RAIDED_SUPPLIES; i > 0; i--) {
            if(i==getRaidSupplies()) {
                s+=String.format("|X%-3c",'|');
                continue;
            }
            s+=String.format("|%d%-3c",i,'|');
        }

        return s;
    }
}
