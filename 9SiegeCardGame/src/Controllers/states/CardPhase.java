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
        getGame().CloseAttack();
        return this;
    }


}
