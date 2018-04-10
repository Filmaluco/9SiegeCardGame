package SiegeCard.Util;

public class Dice {



    private boolean morale = false,
                    supplies = false,
                    sabotage= false,
                    raid = false,
                    circle = false,
                    batteringRam = false,
                    coupure = false,
                    closeCombate = false,
                    siegeTower = false,
                    ladder = false;


    public Dice(String target, int modifier){
        target = target.toUpperCase();

    }
}
