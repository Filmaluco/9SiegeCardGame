package UI.Graphical;

import Controllers.ObservableGame;
import UI.Graphical.Containers.EnemyTrackDisplay;
import UI.Graphical.Containers.MenuDisplay;
import UI.Graphical.Containers.PlayerInfoDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SiegeCardPanel extends JPanel implements Observer {
    private ObservableGame game;

    private MenuDisplay menuDisplay;
    private EnemyTrackDisplay enemyTrackDisplay;
    private PlayerInfoDisplay playerInfoDisplay;

    public SiegeCardPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setupComponents();
        setupLayout();

        update(game, null);
    }



    private void setupComponents() {
        menuDisplay = new MenuDisplay(game);
        enemyTrackDisplay = new EnemyTrackDisplay(game);
        playerInfoDisplay = new PlayerInfoDisplay(game);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        add(menuDisplay, BorderLayout.PAGE_END);
        add(enemyTrackDisplay, BorderLayout.CENTER);
        add(playerInfoDisplay, BorderLayout.PAGE_START);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
