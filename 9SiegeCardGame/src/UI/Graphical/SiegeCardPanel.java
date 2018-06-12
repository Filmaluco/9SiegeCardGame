package UI.Graphical;

import Controllers.ObservableGame;
import Controllers.states.GameSetup;
import UI.Graphical.Containers.MainMenuDisplay;
import UI.Graphical.Util.Constants;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SiegeCardPanel extends JPanel implements Observer, Constants, Miscellaneous {
    private ObservableGame game;

    private MainMenuDisplay mainMenuDisplay;
    private SiegeCardGamePanel siegeCardGamePanel;

    public SiegeCardPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setLayout(new CardLayout());

        setupComponents();

        setSize(DIM_X_FRAME,DIM_Y_FRAME);
    }

    private void setupComponents() {
        siegeCardGamePanel = new SiegeCardGamePanel(game);
        mainMenuDisplay = new MainMenuDisplay(game);
        add(mainMenuDisplay, MAIN_MENU);
        add(siegeCardGamePanel, GAME);
    }


    @Override
    public void update(Observable o, Object arg) {
        CardLayout cl = (CardLayout)(this.getLayout());
        if (game.getState() instanceof GameSetup){
            cl.show(this, MAIN_MENU);
        }else{
            cl.show(this, GAME);
        }
    }
}
