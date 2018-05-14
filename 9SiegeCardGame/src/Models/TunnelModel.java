package Models;

import java.io.Serializable;

public class TunnelModel implements Serializable{

    private int raidedSupplies;
    private boolean castle;
    private boolean enemy;
    private boolean[] tunnel;

    private boolean directionCastleEnemy;
    private boolean directionEnemyCastle;

    public static final int MAX_RAIDED_SUPPLIES = 2;
    public static final int TUNEL_SIZE = 2;

    public TunnelModel(){
        raidedSupplies = 0;
        castle = true;
        enemy = false;
        tunnel = new boolean[TUNEL_SIZE];
        directionCastleEnemy = true;
        directionEnemyCastle = false;
    }


    public void reduceRaidedSupplies() { raidedSupplies = raidedSupplies > 0 ? raidedSupplies-1:  raidedSupplies; }
    public void increaseRaidedSupplies() { raidedSupplies = raidedSupplies < MAX_RAIDED_SUPPLIES ? raidedSupplies+1:  raidedSupplies; }
    public void setRaidedSupplies(int nr){ raidedSupplies = nr;}

    public int getRaidedSupplies() { return raidedSupplies; }

    public boolean inCastle(){ return castle; }
    public boolean inEnemyLine(){ return enemy; }
    public int inTunnel(){
        for(int i = 0; i < tunnel.length; i++){
            if(tunnel[i]) return i+1;
        }
        return 0;
    }

    public boolean moveToTunnel() {
        if(castle){
            directionCastleEnemy = true;
            directionEnemyCastle = false;
            castle = false;
            tunnel[0] = true;
            return true;
        }else if(enemy){
            directionCastleEnemy = false;
            directionEnemyCastle = true;
            enemy = false;
            tunnel[TUNEL_SIZE-1] = true;
            return true;
        }

        return false;
    }

    private void moveRight(){
        if(directionCastleEnemy){
            if(castle){
                castle = false;
                tunnel[0] = true;
            }else if(tunnel[TUNEL_SIZE]){
                tunnel[TUNEL_SIZE] = false;
                enemy = true;
            }else{
                for (int i = 0; i < TUNEL_SIZE-1 ; i++){
                    if(tunnel[i]){
                        tunnel[i]=false;
                        tunnel[i+1] = true;
                    }
                }
            }

        }
    }

    private void moveLeft(){
        if(directionEnemyCastle){
            if(enemy){
                enemy = false;
                tunnel[TUNEL_SIZE] = true;
            }else if(tunnel[0]){
                tunnel[0] = false;
                castle = true;
            }else{
                for (int i = TUNEL_SIZE-1; i > 0 ; i--){
                    if(tunnel[i]){
                        tunnel[i]=false;
                        tunnel[i-1] = true;
                    }
                }
            }

        }
    }

    public boolean freeMovement(){
        int pos = inTunnel();
        if(pos == 0) return false;
        if(directionEnemyCastle) moveLeft();
        if(directionCastleEnemy) moveRight();
        return true;
    }

    public int fastMovement() {
        if(inTunnel()==0)return 0;
        if(directionEnemyCastle){
            directionEnemyCastle = false;
            directionCastleEnemy = true;
            tunnel[inTunnel()-1] = false;
            castle = true;
            return raidedSupplies;
        }
        if(directionCastleEnemy){
            directionEnemyCastle = true;
            directionCastleEnemy = false;
            tunnel[inTunnel()-1] = false;
            enemy = true;
        }
        return 0;
    }

    public int autoMovement(){
        if(!inEnemyLine()){
            directionCastleEnemy = true;
            directionEnemyCastle = false;
            castle = true;
            tunnel[inTunnel()-1]=false;
        }
        return raidedSupplies;
    }

    public void capture(){
        raidedSupplies = 0;
        castle = true;
        enemy = false;
        tunnel = new boolean[TUNEL_SIZE];
        directionCastleEnemy = true;
        directionEnemyCastle = false;
    }

    @Override
    public String toString() {
        String s="";
        s+=String.format("\n%-15s","Tunnel:");

        s+= (castle) ? String.format("|X%-3c",'|') : String.format("|C%-3c",'|');

        for (boolean aTunnel : tunnel) s += (aTunnel) ? String.format("|X%-3c", '|') : String.format("| %-3c", '|');

        s+= (enemy) ? String.format("|X%-3c",'|') : String.format("|E%-3c",'|');

        s+=String.format("\n%-15s","RaidedSupplies:");
        s+="["+raidedSupplies+"]";

        return s;
    }
}
