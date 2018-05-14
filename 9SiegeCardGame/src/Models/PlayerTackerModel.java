package Models;

public class PlayerTackerModel {
    private int wallStrength,
                morale,
                supplies;

    private TunnelModel tunnel;

    public static final int MAX_PLAYER_TRACK_SLOTS = 4;
    //Used only if we choose to use an array to print status tracks
    public static final int STATUS_TRACKS = 3;

    /**
     * Initial Player Tracker Values
     */
    public PlayerTackerModel() {
        //Initial Status Tracker values
        wallStrength = morale = supplies = MAX_PLAYER_TRACK_SLOTS;
        tunnel = new TunnelModel();

    }

    //Tunnel
    public boolean moveToTunnel(){
        return tunnel.moveToTunnel();
    }

    public boolean freeMovement(){
        return tunnel.freeMovement();
    }

    public void fastMovement(){
        addSupplies(tunnel.fastMovement());
    }

    public void autoMovement(){
        addSupplies(tunnel.autoMovement());
    }

    public void capture(){
        tunnel.capture();
    }

    public boolean inEnemyLine(){
        return tunnel.inEnemyLine();
    }

    //Setters
    public void reduceWallStrength() { wallStrength = wallStrength >= 1 ? wallStrength-1:  wallStrength; }
    public void increaseWallStrength() { wallStrength = wallStrength < 4 ? wallStrength+1:  wallStrength; }

    public void reduceMorale() { morale = morale >= 1 ? morale-1:  morale; }
    public void increaseMorale() { morale = morale < 4 ? morale+1:  morale; }

    public void reduceSupplies() { supplies = supplies >= 1 ? supplies-1:  supplies; }
    public void increaseSupplies() { supplies = supplies < 4 ? supplies+1:  supplies; }
    public void setSupplies(int nr){supplies = nr > 2 || nr < 0 ? supplies: nr;}
    public void addSupplies(int nr){supplies = supplies+nr > 2 ? 2 : supplies+nr;}


    //Getters
    public int getWallStrength() { return wallStrength; }
    public int getMorale() { return morale; }
    public int getSupplies() { return supplies; }


    public int getLostAttributes(){
        return (getWallStrength() == 0 ? 1 : 0) + (getMorale() == 0 ? 1 : 0) + (getSupplies() == 0 ? 1 : 0);
    }


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
        s+=tunnel;

        return s;
    }


}
