package Controllers;

import Controllers.states.IState;
import Models.GameDataModel;
import SiegeCard.Util.Constants;
import SiegeCard.Util.Rolls;

import java.util.Observable;

public class ObservableGame extends Observable {
    GameController gameData;

    public ObservableGame() { gameData = new GameController(); }

    public GameController getGameController() { return gameData; }

    public void setGameController(GameController gameData) {
        this.gameData = gameData;

        setChanged();
        notifyObservers();
    }

    public IState getState() { return gameData.getState(); }

    //------------------------------ Methods that enable accessing the data/status of the game ----------------------------

    //PlayerTracker methods
    public boolean hasInitialConfig() { return gameData.hasInitialConfig(); }
    public void setInitialConfig(String player_name) { gameData.setInitialConfig(player_name); }
    public String getPlayerName() { return gameData.getPlayerName(); }

    public int getActionPoints() { return gameData.getActionPoints(); }
    public int getCurrentTurn() { return gameData.getCurrentTurn(); }
    public int getCurrentDay() { return gameData.getCurrentDay(); }

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

    public int getTrebuchetCount() { return gameData.getTrebuchetCount(); }
    public int getLadderPosition() { return gameData.getLadderPosition(); }
    public int getBatteringRamPosition() { return gameData.getBatteringRamPosition(); }
    public int getSiegeTowerPosition() { return gameData.getSiegeTowerPosition(); }

    public boolean batteringRamInGame() { return gameData.batteringRamInGame(); }
    public boolean ladderInGame() { return gameData.ladderInGame(); }
    public boolean siegeTowerInGame() { return gameData.siegeTowerInGame(); }

    //Dice methods
    public int getLastRoll() { return gameData.getLastRoll(); }

    //Deck methods
    public int getLastCardID() { return gameData.getLastCardID(); }
    public int getNumberCards() { return gameData.getNumberCards(); }
    public int[] getCardIDS() { return gameData.getCardIDS(); }

    //PlayerTracker tracker methods
    public int getMorale() { return gameData.getMorale(); }
    public int getSupplies() { return gameData.getSupplies(); }
    public int getWallStrenght() { return gameData.getWallStrenght(); }
    public int getRaidedSupplies() { return gameData.getRaidedSupplies(); }

    public int getTunnelPosition() { return gameData.getTunnelPosition(); }
    public boolean isOnEnemyLines() { return gameData.isOnEnemyLines(); }
    public boolean isOnCastle() { return gameData.isOnCastle(); }

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
    public void Sabotage() {
        gameData.Sabotage();
        setChanged();
        notifyObservers();
    }
    public void SupplyRaid() {
        gameData.SupplyRaid();
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
