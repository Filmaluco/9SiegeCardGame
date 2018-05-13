package Controllers.states;

import Models.GameDataModel;

public class CardPhase extends StateAdapter{
    public CardPhase(GameDataModel g) {
        super(g);
    }

    @Override
    public IState StartTurn()  {

        getGame().Dice = getGame().Deck.draw().applyEvent(getGame());
        //TODO: if one advances to close combat lose morale

        if(getGame().isGameOver()) return new GameOver(getGame());

        return new ActionPhase(getGame());
    }




}
