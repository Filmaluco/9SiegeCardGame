package UI.Graphical.Labels;

import Controllers.ObservableGame;
import UI.Graphical.Constants;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoLabel extends JLabel implements Constants{
    ObservableGame game;
    String playerName;
    private int actionPoints;
    private int day;
    private int turn;

    public PlayerInfoLabel(ObservableGame game) {
        this.game = game;

        Dimension d = new Dimension(DIM_X_PLAYERINFO, DIM_Y_PLAYERINFO);
        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setForeground(Color.ORANGE);
        setFont(new Font("Arial", Font.PLAIN, 25));
    }

    public void setInfo(String playerName, int actionPoints, int day, int turn){
        this.playerName = playerName;
        this.actionPoints = actionPoints;
        this.day = day;
        this.turn = turn;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(playerName, DIM_X_PLAYERINFO/10, DIM_Y_PLAYERINFO/2);
        g.drawString("ACTION POINTS: " + actionPoints, DIM_X_PLAYERINFO/3, DIM_Y_PLAYERINFO/2);
        g.drawString("DAY: " + day + " TURN: " + turn, DIM_X_PLAYERINFO - DIM_X_PLAYERINFO/3, DIM_Y_PLAYERINFO/2);
    }
}
