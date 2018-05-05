package Models;

public class PlayerTackerModel {
    private int wallStrength,
                morale,
                supplies,
                tunnel,
                raidSupplies;

    public static final int MAX_PLAYER_TRACK_SLOTS = 4;
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

}
