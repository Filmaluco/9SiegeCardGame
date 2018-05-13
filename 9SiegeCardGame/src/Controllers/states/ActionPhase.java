package Controllers.states;

import Models.GameDataModel;

public class ActionPhase extends StateAdapter {

    public ActionPhase(GameDataModel g) { super(g); }

    @Override
    public IState EndTurn()  {

        getGame().nextTurn();

        if(getGame().lostTurn()) return new GameOver(getGame());
        if(getGame().isGameWon()) return new GameWon(getGame());


        if(getGame().hasToChangeDay()){
            //TODO: check Tunnel and EnemyLine (diferent enemy line check change paraments this one does not require roll)
            getGame().Player.tracker.reduceSupplies();
            getGame().nextDay();
            getGame().Deck.reShuffle();
        }else {
            //TODO: Check EnemyLine
        }

        return new CardPhase(getGame());
    }

}
