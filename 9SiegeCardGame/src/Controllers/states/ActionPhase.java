package Controllers.states;

import Models.GameDataModel;

import static SiegeCard.Util.Rolls.COUPURE_ROLL;

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
        if(getGame().canCloseCombat()) getGame().CloseAttack();
        return this;
    }

    @Override
    public  IState ActionRallyTroops(){
        if(getGame().Player.getActionPoints() == 0) return this;
        return new ActionRallyTroops(getGame());
    }

    @Override
    public IState GetAdicionalPoints(){
        //TODO: Convert into State reduce with target
        if(getGame().canGetAdicionalPoint()){
            return new ActionAdicionalPoint(getGame());
        }
        return this;
    }

    @Override
    public IState ActionCoupure(){
        if(getGame().canCoupure()){
            if(getGame().Dice.roll(COUPURE_ROLL) > 4){
                getGame().Player.tracker.increaseWallStrength();
            }
         getGame().Player.removeActionPoint();
        }
        return this;
    }

    @Override
    public IState ActionTunnelMovement(){
        if(getGame().canUseTunnelMovemnt()){
            return new ActionTunnelMovement(getGame());
        }
        return this;
    }

    @Override
    public IState ActionSabotage(){
        if(getGame().canSabotage()){
            getGame().Player.removeActionPoint();
            getGame().sabotage();
        }
        return this;
    }

    @Override
    public IState ActionSupplyRaid(){
        if(getGame().canSupplyRaid()){
            getGame().Player.removeActionPoint();
            getGame().SupplyRaid();
        }
        return this;
    }

    @Override
    public IState GameExit() { return new GameExit(getGame()); }
}
