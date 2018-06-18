package UI.Graphical.Rectangles;

import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;
import UI.Graphical.Rectangles.Enemies.BatteringRamGUI;
import UI.Graphical.Rectangles.Enemies.LadderGUI;
import UI.Graphical.Rectangles.Enemies.SiegeTowerGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class EnemyGUI extends JPanel implements Observer, Constants{
    ObservableGame game;
    private LadderGUI ladderGUI;
    private BatteringRamGUI batteringRamGUI;
    private SiegeTowerGUI siegeTowerGUI;

    public EnemyGUI(ObservableGame game) {
        this.game = game;

        Dimension d = new Dimension(DIM_X_ENEMY_GUI, DIM_Y_ENEMY_GUI);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();
        layoutComponents();

        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    private void setupComponents() {
        ladderGUI = new LadderGUI(game);
        batteringRamGUI = new BatteringRamGUI(game);
        siegeTowerGUI = new SiegeTowerGUI(game);
    }

    private void layoutComponents() {
        add(ladderGUI);
        add(batteringRamGUI);
        add(siegeTowerGUI);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
