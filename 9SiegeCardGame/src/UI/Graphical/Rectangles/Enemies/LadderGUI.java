package UI.Graphical.Rectangles.Enemies;

import Controllers.ObservableGame;
import SiegeCard.Util.Rolls;
import UI.Graphical.Rectangles.Enemies.MouseListeners.EnemySelect;
import UI.Graphical.Util.Constants;
import UI.Graphical.Labels.Enemies.Ladder.LadderCircleCombatLabel;
import UI.Graphical.Labels.Enemies.Ladder.LadderCloseCombatLabel;
import UI.Graphical.Labels.Enemies.Ladder.LadderCombatLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import static Models.EnemyModel.MAX_ENEMY_TRACK_SLOTS;



public class LadderGUI extends JPanel implements Observer, Constants{

    ObservableGame game;

    public LadderGUI(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(DIM_X_ENEMY,DIM_Y_ENEMY);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();

        //setLayout(new GridLayout(0,4,5,10));
        setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
    }

    //See if repaint works on components
    private void setupComponents() {
        addMouseListener(new EnemySelect(this,game, Rolls.LADDER));

        add(new LadderCloseCombatLabel(game,0));
        add(new LadderCircleCombatLabel(game,1));
        for (int i = 2; i <= MAX_ENEMY_TRACK_SLOTS ; i++) {
            add(new LadderCombatLabel(game,i));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (!(game.ladderInGame()))
            setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //g.drawImage(getLadderImage(),DIM_X_COMBAT_LABEL * ladderPosition,0,this);
    }
}
