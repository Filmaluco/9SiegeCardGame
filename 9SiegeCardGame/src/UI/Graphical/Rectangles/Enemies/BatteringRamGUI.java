package UI.Graphical.Rectangles.Enemies;

import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;
import UI.Graphical.Labels.Enemies.BatteringRam.BatteringRamCircleCombatLabel;
import UI.Graphical.Labels.Enemies.BatteringRam.BatteringRamCloseCombatLabel;
import UI.Graphical.Labels.Enemies.BatteringRam.BatteringRamCombatLabel;

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

        Dimension d = new Dimension(DIM_X_ENEMY,DIM_Y_ENEMY);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();

        //setLayout(new GridLayout(0,5,5,10));
        setLayout(new FlowLayout(FlowLayout.CENTER,30,0));

    }

    //See if repaint works on components
    private void setupComponents() {
        add(new BatteringRamCloseCombatLabel(game, 0));
        add(new BatteringRamCircleCombatLabel(game,1));
        for (int i = 2; i <= MAX_ENEMY_TRACK_SLOTS ; i++) {
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
