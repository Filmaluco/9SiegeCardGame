package Models;

import SiegeCard.Util.game_constants;

public class PlayerTackerModel implements game_constants {
    private int wallStrength,
                morale,
                supplies,
                tunnel,
                raidSupplies;

    /**
     * Initial Player Tracker Values
     */
    public PlayerTackerModel() {
        //Initial Status Tracker values
        wallStrength = morale = supplies = MAX_TRACK_SLOTS;
        tunnel = raidSupplies = 0;
    }

    public int getWallStrength() { return wallStrength; }
    public int getMorale() { return morale; }
    public int getSupplies() { return supplies; }
    public int getTunnel() { return tunnel; }
    public int getRaidSupplies() { return raidSupplies; }

}
