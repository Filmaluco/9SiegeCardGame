package Controllers.states;

import Models.GameDataModel;
import SiegeCard.Util.Constants;


public class ActionTunnelMovement extends StateAdapter{
    public ActionTunnelMovement(GameDataModel g) { super(g); }

    @Override
    public IState ApplyRules(Constants TARGET){
        return new ActionPhase(getGame());
    }


    @Override
    public IState moveIntoTunnel(){
        if(canMoveIntoTunnel()){
          getGame().moveToTunnel();
        }
        return this;
    }

    public boolean canMoveIntoTunnel(){
        return getGame().canUseTunnelMovemnt() && getGame().Player.getActionPoints() > 0
                && (getGame().Player.tracker.inEnemyLine() || getGame().Player.tracker.inCastle());
    }

    @Override
    public IState moveInTunnel(Constants TARGET){
        if(canMoveInTunnel()){

            switch (TARGET){
                case FREE_MOVEMENT: getGame().freeMovement(); break;
                case FAST_MOVEMENT: getGame().fastMovement(); break;
                case AUTO_MOVMENT: getGame().autoMovement(); break;
            }

        }
        return this;
    }

    public boolean canMoveInTunnel(){
        return getGame().canUseTunnelMovemnt() && getGame().Player.tracker.inTunnel();
    }

    public boolean canUseFreeMovement(){
        return !getGame().hasUsedTunnelMovement();
    }

    public boolean canUseFastMovement(){
        return getGame().canUseTunnelMovemnt() && getGame().Player.getActionPoints() > 0;
    }

}
