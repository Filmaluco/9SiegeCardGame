package UI.Graphical.Rectangles.Enemies;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Constants;
import UI.Graphical.Labels.CircleCombatLabel;
import UI.Graphical.Labels.Enemies.Ladder.LadderCircleCombatLabel;
import UI.Graphical.Labels.Enemies.Ladder.LadderCloseCombatLabel;
import UI.Graphical.Labels.Enemies.Ladder.LadderCombatLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import static Models.EnemyModel.MAX_ENEMY_TRACK_SLOTS;



public class LadderGUI extends JPanel implements Observer, Constants{

    ObservableGame game;

    public LadderGUI(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(600,100);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();

        //setLayout(new GridLayout(0,4,5,10));
        setLayout(new FlowLayout(FlowLayout.LEFT,30,0));
    }

    //See if repaint works on components
    private void setupComponents() {
        add(new LadderCloseCombatLabel(game,0));
        add(new LadderCircleCombatLabel(game,1));
        for (int i = 2; i <= MAX_ENEMY_TRACK_SLOTS ; i++) {
            add(new LadderCombatLabel(game,i));
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
