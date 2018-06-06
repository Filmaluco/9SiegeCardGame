package UI.Graphical;

import Controllers.ObservableGame;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SiegeCardGUI extends JFrame implements Observer, Constants{

    ObservableGame game;
    SiegeCardPanel siegeCardPanel;

    public SiegeCardGUI(ObservableGame game) {
        super("9SiegeCardGame");

        this.game = game;
        game.addObserver(this);

        Container cp = getContentPane();

        siegeCardPanel = new SiegeCardPanel(game);
        cp.add(siegeCardPanel, BorderLayout.CENTER);

        setSize(DIM_X_FRAME,DIM_Y_FRAME);
        setMinimumSize(new Dimension(DIM_X_FRAME, DIM_Y_FRAME));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

    @Override
    public void update(Observable o, Object arg) { repaint(); }
}
