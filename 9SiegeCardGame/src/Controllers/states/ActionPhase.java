package Controllers.states;

import Models.GameDataModel;

import static SiegeCard.Util.rolls.CLOSE_COMBAT;

public class ActionPhase extends StateAdapter {

    public ActionPhase(GameDataModel g) { super(g); }

    @Override
    public IState EndTurn()  {

        getGame().nextTurn();

        if(getGame().lostTurn()) return new GameOver(getGame());
        if(getGame().isGameWon()) return new GameWon(getGame());


        if(getGame().hasToChangeDay()){
            //TODO: check Tunnel and EnemyLine (different enemy line check change parameters this one does not require roll)
            getGame().Player.tracker.reduceSupplies();
            getGame().nextDay();
            getGame().Deck.reShuffle();
        }else {
            //TODO: Check EnemyLine (different enemy line check change parameters this one requires roll)
        }

        //TODO: check if enemies can damage walL

        return new CardPhase(getGame());
    }

    @Override
    public IState TrackSelectionArchersAttack(){
        return getGame().canArchersAttack() ? new ActionArchersAttack(getGame()): this;
    }

    @Override
    public IState TrackSelectionBoilingAttack(){
        return getGame().canBoilAttack() ? new ActionBoilingAttack(getGame()): this;
    }

    @Override
    public IState ActionCloseCombat(){
        getGame().Player.removeActionPoint();
        if(getGame().EnemyTracker.batteringRam.onCloseCombat()) { //Target is on Close Combat
            if (getGame().Dice.roll(CLOSE_COMBAT) > getGame().EnemyTracker.batteringRam.getStrength())
                getGame().EnemyTracker.batteringRam.retreat();
        }else if(getGame().EnemyTracker.ladder.onCloseCombat()) { //Target is on Close Combat
            if (getGame().Dice.roll(CLOSE_COMBAT) > getGame().EnemyTracker.ladder.getStrength())
                getGame().EnemyTracker.ladder.retreat();
        }else{
            if (getGame().Dice.roll(CLOSE_COMBAT) > getGame().EnemyTracker.siegeTower.getStrength())
                getGame().EnemyTracker.siegeTower.retreat();
        }

        if(getGame().Dice.getLastRoll() == 1) getGame().Player.tracker.reduceMorale();

        return this;
    }

    @Override
    public IState GameExit() { return new GameExit(getGame()); }
}
