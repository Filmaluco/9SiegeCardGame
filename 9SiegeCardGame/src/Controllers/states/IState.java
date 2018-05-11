package Controllers.states;

public interface IState {
    IState GameSetup();

    IState lineCheck();
    IState updateBoard();

    IState archersAttack();
    IState boilingAttack();
    IState Coupure();
    IState RallyTroops();
    IState TunnelMovement();
    IState SupplyRaid();
    IState Sabotage();


    IState getState();
}
