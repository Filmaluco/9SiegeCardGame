package Controllers;

import Controllers.states.IState;
import Models.GameDataModel;
import SiegeCard.Util.Constants;
import SiegeCard.Util.Rolls;

import java.util.Observable;

public class ObservableGame extends Observable {
    GameController gameData;

    public ObservableGame() { gameData = new GameController(); }

    public GameDataModel getGameData() { return gameData.getGameData(); }

    public IState getState() { return gameData.getState(); }

    //------------------------------ Methods that enable accessing the data/status of the game ----------------------------

    //Player methods
    public boolean hasInitialConfig() { return gameData.hasInitialConfig(); }
    public void setInitialConfig(String player_name) { gameData.setInitialConfig(player_name); }
    public String getPlayerName() { return gameData.getPlayerName(); }

    //Can menu options methods
    public boolean canArchersAttack() { return gameData.canArchersAttack(); }
    public boolean canBoilAttack() { return gameData.canBoilAttack(); }
    public boolean canCloseCombat() { return gameData.canCloseCombat(); }
    public boolean canCoupure() { return gameData.canCoupure(); }
    public boolean canRallyTroops() { return gameData.canRallyTroops(); }
    public boolean canUseTunnelMovemnt() { return gameData.canUseTunnelMovemnt(); }
    public boolean canSupplyRaid() { return gameData.canSupplyRaid(); }
    public boolean canSabotage() { return gameData.canSabotage(); }
    public boolean canGetAdicionalPoint() { return gameData.canGetAdicionalPoint(); }

    //Tunel movement specific can methods
    public boolean canMoveInTunnel() { return gameData.canMoveInTunnel(); }
    public boolean canMoveIntoTunnel() { return gameData.canMoveIntoTunnel(); }
    public boolean canUseFreeMovement() { return gameData.canUseFreeMovement(); }
    public boolean canUseFastMovement() { return gameData.canUseFastMovement(); }

    //Enemy tracker methods
    public boolean batteringRamOnStartingSpace() { return gameData.batteringRamOnStartingSpace(); }
    public boolean ladderOnStartingSpace() { return gameData.ladderOnStartingSpace(); }
    public boolean siegeTowerOnStartingSpace() { return gameData.siegeTowerOnStartingSpace(); }

    public boolean batteringRamOnCircleSpace() { return gameData.batteringRamOnCircleSpace(); }
    public boolean ladderOnCircleSpace() { return gameData.ladderOnCircleSpace(); }
    public boolean siegeTowerOnCircleSpace() { return gameData.siegeTowerOnCircleSpace(); }

    public int batteringRamStrength() { return gameData.batteringRamStrength(); }
    public int ladderStrength() { return gameData.ladderStrength(); }
    public int siegeTowerStrength() { return gameData.siegeTowerStrength(); }

    //Dice methods
    public int getLastRoll() { return gameData.getLastRoll(); }

    //Player tracker methods
    public int getMorale() { return gameData.getMorale(); }
    public int getSupplies() { return gameData.getSupplies(); }
    public int getWallStrenght() { return gameData.getWallStrenght(); }

    //--------------------- Methods that trigger events/actions in the finite state machine  -----------------------

    public void Start() { gameData.Start(); }
    public void Exit() { gameData.Exit(); }
    public void Menu() { gameData.Menu(); }

    public void ArchersAttack() { gameData.ArchersAttack(); }
    public void BoilingAttack() { gameData.BoilingAttack(); }
    public void CloseCombat() { gameData.CloseCombat(); }
    public void RallyTroops() { gameData.RallyTroops(); }
    public void Coupure() { gameData.Coupure(); }
    public void Adicional() { gameData.Adicional(); }
    public void Tunel() { gameData.Tunel(); }
    public void MoveInTunnel(Constants target) { gameData.MoveInTunnel(target); }
    public void MoveIntoTunnel() { gameData.MoveIntoTunnel(); }

    public void ApplyRules(Rolls target) { gameData.ApplyRules(target); }
    public void ApplyRules(Constants target) { gameData.ApplyRules(target); }

    public void StartTurn() { gameData.StartTurn(); }
    public void EndTurn() { gameData.EndTurn(); }
}
