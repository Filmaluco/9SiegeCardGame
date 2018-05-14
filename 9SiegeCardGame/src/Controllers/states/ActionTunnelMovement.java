package Controllers.states;

import Models.GameDataModel;
import SiegeCard.Util.*;

import static SiegeCard.Util.constants.*;

public class ActionTunnelMovement extends StateAdapter{
    public ActionTunnelMovement(GameDataModel g) { super(g); }

    @Override
    public IState ApplyRules(int TARGET){
        return new ActionPhase(getGame());
    }


    @Override
    public IState moveIntoTunnel(){
        if(canMoveIntoTunnel()){
          getGame().Player.tracker.moveToTunnel();
        }
        return this;
    }

    public boolean canMoveIntoTunnel(){
        return getGame().canUseTunnelMovemnt() && getGame().Player.getActionPoints() > 0
                && (getGame().Player.tracker.inEnemyLine() || getGame().Player.tracker.inCastle());
    }

    @Override
    public IState moveInTunnel(int TARGET){
        if(canMoveInTunnel()){

            switch (TARGET){
                case FREE_MOVEMENT: getGame().Player.tracker.freeMovement();
                case FAST_MOVEMENT: getGame().Player.tracker.fastMovement();
                case AUTO_MOVMENT: getGame().Player.tracker.autoMovement();
            }

        }
        return this;
    }

    public boolean canMoveInTunnel(){
        return getGame().canUseTunnelMovemnt() && getGame().Player.tracker.inTunnel();
    }

}
