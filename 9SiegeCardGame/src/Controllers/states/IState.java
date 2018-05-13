package Controllers.states;

public interface IState {
    IState GameStart();

    IState StartTurn();                     // [CardPhase] -> [ActionPhase]
    IState EndTurn();                       // [CardPhase] <- [ActionPhase]

    IState GameWon();
    IState GameOver();
    IState GameSave();
    IState GameExit();

    IState TrackSelectionArchersAttack();   // [ActionPhase] -> [Archers]
    IState TrackSelectionBoilingAttack();   // [ActionPhase] -> [Boiling]
    IState ActionRallyTroops();             // [ActionPhase] -> [Rally]
    IState ActionTrunnelMovement();         // [ActionPhase] -> [Tunnel]
    IState ActionSupplyRaid();              // [ActionPhase] -> [Supply]

    IState ApplyRules();                    // [ActionPhase] <- [Action]

    IState getState();
}
