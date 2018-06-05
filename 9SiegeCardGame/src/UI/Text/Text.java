package UI.Text;

import Controllers.GameController;
import Controllers.states.*;
import SiegeCard.Util.str_values;

public class Text implements str_values{

    private GameController game;
    private MainMenu mainMenu;
    private PlayMenu playMenu;
    private ArchersAttackMenu archersAttackMenu;
    private BoilAttackMenu boilAttackMenu;
    private RallyTroopsMenu rallyTroopsMenu;
    private AdicionalPointMenu adicionalPointMenu;
    private CardPhaseMenu cardPhaseMenu;
    private TunelMovementMenu tunelMovementMenu;
    private GameMenus gameMenus;

    public Text(GameController gameController){
        this.game=gameController;
        mainMenu = new MainMenu(this.game);
        playMenu = new PlayMenu();
        archersAttackMenu = new ArchersAttackMenu();
        boilAttackMenu = new BoilAttackMenu();
        cardPhaseMenu = new CardPhaseMenu();
        tunelMovementMenu = new TunelMovementMenu();
        rallyTroopsMenu = new RallyTroopsMenu();
        adicionalPointMenu = new AdicionalPointMenu();
        gameMenus = new GameMenus();
    }

    public void start(){
        while (!(game.getState()instanceof GameExit)) {
            //TODO: Implement other states!!
            if (game.getState() instanceof GameSetup) {
                game = mainMenu.menu(game);
            } else if (game.getState() instanceof ActionPhase) {
                playMenu.menu(game);
            } else if (game.getState() instanceof CardPhase) {
                cardPhaseMenu.menu(game);
            } else if (game.getState() instanceof ActionArchersAttack) {
                archersAttackMenu.menu(game);
            } else if (game.getState() instanceof ActionBoilingAttack) {
                boilAttackMenu.menu(game);
            } else if (game.getState() instanceof ActionRallyTroops){
                rallyTroopsMenu.menu(game);
            } else if (game.getState() instanceof ActionAdicionalPoint){
                adicionalPointMenu.menu(game);
            } else if (game.getState() instanceof ActionTunnelMovement) {
                tunelMovementMenu.menu(game);
            }else if (game.getState() instanceof GameOver){
                game = gameMenus.overMenu(game);
            } else if (game.getState() instanceof GameWon){
                game = gameMenus.wonMenu(game);
            }
        }
    }
}
