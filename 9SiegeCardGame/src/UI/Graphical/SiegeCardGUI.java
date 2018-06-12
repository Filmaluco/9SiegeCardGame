package UI.Graphical;

import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class SiegeCardGUI extends JFrame implements Observer, Constants {

    ObservableGame game;
    private SiegeCardPanel siegeCardPanel;

    public SiegeCardGUI(ObservableGame game) {
        super("9SiegeCardGame");

        this.game = game;
        game.addObserver(this);

        siegeCardPanel = new SiegeCardPanel(game);
        add(siegeCardPanel);

        setSize(DIM_X_FRAME,DIM_Y_FRAME);
        setResizable(false);
        //setMinimumSize(new Dimension(DIM_X_FRAME, DIM_Y_FRAME));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
