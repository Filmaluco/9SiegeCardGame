package Models;

public class TunnelModel {

    private int raidedSupplies;
    private boolean castle;
    private boolean enemy;
    private boolean[] tunnel;

    public static final int MAX_RAIDED_SUPPLIES = 2;
    public static final int TUNEL_SIZE = 2;

    public TunnelModel(){
        raidedSupplies = 0;
        castle = true;
        enemy = false;
        tunnel = new boolean[TUNEL_SIZE];
    }


    public void reduceRaidedSupplies() { raidedSupplies = raidedSupplies > 1 ? raidedSupplies-1:  raidedSupplies; }
    public void increaseRaidedSupplies() { raidedSupplies = raidedSupplies < 2 ? raidedSupplies+1:  raidedSupplies; }

    public int getRaidedSupplies() { return raidedSupplies; }

    @Override
    public String toString() {
        String s="";
        //TODO: Implement TUNNEL
        s+=String.format("\n%-15s","Tunnel:");

        s+= (castle) ? String.format("|X%-3c",'|') : String.format("|C%-3c",'|');

        for (boolean aTunnel : tunnel) s += (aTunnel) ? String.format("|X%-3c", '|') : String.format("| %-3c", '|');

        s+= (enemy) ? String.format("|X%-3c",'|') : String.format("|E%-3c",'|');

        s+=String.format("\n%-15s","RaidedSupplies:");
        s+="["+raidedSupplies+"]";

        return s;
    }
}
