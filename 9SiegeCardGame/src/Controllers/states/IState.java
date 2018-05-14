package Controllers.states;

public interface IState {
    IState GameStart();

    IState Menu();

    IState StartTurn();                     // [CardPhase] -> [ActionPhase]
    IState EndTurn();                       // [CardPhase] <- [ActionPhase]

    IState GameWon();
    IState GameOver();
    IState GameSave();
    IState GameExit();

    IState TrackSelectionArchersAttack();               // [ActionPhase] -> [Archers]
    IState TrackSelectionBoilingAttack();               // [ActionPhase] -> [Boiling]
    IState ActionRallyTroops();                         // [ActionPhase] -> [Rally]
    IState ActionTunnelMovement();                      // [ActionPhase] -> [Tunnel]
    IState ActionSupplyRaid();                          // [ActionPhase] -> [Supply]

    IState ActionCloseCombat();                         // [ActionPhase] -> [ActionPhase]
    IState ActionCoupure();                             // [ActionPhase] -> [ActionPhase]
    IState ActionSabotage();                            // [ActionPhase] -> [ActionPhase]
    IState GetAdicionalPoints();                        // [ActionPhase] -> [ActionPhase]

    IState moveIntoTunnel();                            // [Tunnel] -> [Tunnel]
    IState moveInTunnel(int TARGET);                    // [Tunnel] -> [Tunnel]


    IState ApplyRules(int TARGET);                      // [ActionPhase] <- [Action]

    IState getState();
}
