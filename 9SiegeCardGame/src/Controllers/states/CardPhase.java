package Controllers.states;

import Models.GameDataModel;

import static SiegeCard.Util.rolls.CLOSE_COMBAT;

public class CardPhase extends StateAdapter{
    public CardPhase(GameDataModel g) {
        super(g);
    }

    @Override
    public IState StartTurn()  {

        getGame().resetAllActions();
        getGame().Dice = getGame().Deck.draw().applyEvent(getGame());
        if(getGame().needsToCloseCombat()) ActionCloseCombat();

        if(getGame().isGameOver()) return new GameOver(getGame());

        return new ActionPhase(getGame());
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


}
