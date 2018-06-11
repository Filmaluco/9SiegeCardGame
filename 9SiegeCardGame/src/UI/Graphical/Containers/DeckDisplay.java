package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.ActionPhase;
import UI.Graphical.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class DeckDisplay extends JPanel implements Observer, Constants{

    ObservableGame game;

    public DeckDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(700,250);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setBackground(Color.lightGray);

        this.setVisible(game.getState() instanceof ActionPhase);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof ActionPhase);
    }
}
