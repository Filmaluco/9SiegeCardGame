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

    public void Start() {
        gameData.Start();
        setChanged();
        notifyObservers();
    }
    public void Exit() {
        gameData.Exit();
        setChanged();
        notifyObservers();
    }
    public void Menu() {
        gameData.Menu();
        setChanged();
        notifyObservers();
    }

    public void ArchersAttack() {
        gameData.ArchersAttack();
        setChanged();
        notifyObservers();
    }
    public void BoilingAttack() {
        gameData.BoilingAttack();
        setChanged();
        notifyObservers();
    }
    public void CloseCombat() {
        gameData.CloseCombat();
        setChanged();
        notifyObservers();
    }
    public void RallyTroops() {
        gameData.RallyTroops();
        setChanged();
        notifyObservers();
    }
    public void Coupure() {
        gameData.Coupure();
        setChanged();
        notifyObservers();
    }
    public void Adicional() {
        gameData.Adicional();
        setChanged();
        notifyObservers();
    }
    public void Tunel() {
        gameData.Tunel();
        setChanged();
        notifyObservers();
    }
    public void MoveInTunnel(Constants target) {
        gameData.MoveInTunnel(target);
        setChanged();
        notifyObservers();
    }
    public void MoveIntoTunnel() {
        gameData.MoveIntoTunnel();
        setChanged();
        notifyObservers();
    }

    public void ApplyRules(Rolls target) {
        gameData.ApplyRules(target);
        setChanged();
        notifyObservers();
    }
    public void ApplyRules(Constants target) {
        gameData.ApplyRules(target);
        setChanged();
        notifyObservers();
    }

    public void StartTurn() {
        gameData.StartTurn();
        setChanged();
        notifyObservers();
    }
    public void EndTurn() {
        gameData.EndTurn();
        setChanged();
        notifyObservers();
    }
}
