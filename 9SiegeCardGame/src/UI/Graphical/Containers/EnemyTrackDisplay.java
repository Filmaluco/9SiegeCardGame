package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.ActionPhase;


import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class EnemyTrackDisplay extends JPanel implements Observer{
    ObservableGame game;

    public EnemyTrackDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setSize(new Dimension(100,100));
        this.setVisible(game.getState() instanceof ActionPhase);
        //setBackground(Color.green);

    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof ActionPhase);
    }
}
