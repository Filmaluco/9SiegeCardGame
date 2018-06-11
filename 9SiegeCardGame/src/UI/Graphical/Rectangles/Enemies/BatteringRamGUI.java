package UI.Graphical.Rectangles.Enemies;

import Controllers.ObservableGame;
import UI.Graphical.Constants;
import UI.Graphical.Labels.Enemies.BatteringRam.BatteringRamCircleCombatLabel;
import UI.Graphical.Labels.Enemies.BatteringRam.BatteringRamCombatLabel;
import UI.Graphical.Labels.Enemies.Ladder.LadderCircleCombatLabel;
import UI.Graphical.Labels.Enemies.Ladder.LadderCombatLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import static Models.EnemyModel.MAX_ENEMY_TRACK_SLOTS;

public class BatteringRamGUI extends JPanel implements Observer, Constants{
    ObservableGame game;

    public BatteringRamGUI(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(500,100);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();

        setLayout(new GridLayout(0,4,5,10));
    }

    //See if repaint works on components
    private void setupComponents() {
        for (int i = 1; i <= MAX_ENEMY_TRACK_SLOTS ; i++) {
            if (i==1)
                add(new BatteringRamCircleCombatLabel(game,i));
            else
                add(new BatteringRamCombatLabel(game,i));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO: Test to check if it is necessary
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //g.drawImage(getLadderImage(),DIM_X_COMBAT_LABEL * ladderPosition,0,this);
    }
}
