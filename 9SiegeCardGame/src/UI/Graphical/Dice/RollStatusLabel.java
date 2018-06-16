package UI.Graphical.Dice;

import UI.Graphical.Util.Constants;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RollStatusLabel extends JLabel implements Constants, Miscellaneous {
    int lastRoll;
    int rollNeeded;

    public RollStatusLabel(int lastRoll, int rollNeeded) {
        this.lastRoll = lastRoll;
        this.rollNeeded = rollNeeded;

        Dimension d = new Dimension(DIM_X_DICE_LABEL, DIM_Y_DICE_LABEL);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(DICE_FONT);
        if (lastRoll>rollNeeded) {
            setForeground(Color.green);
            g.drawString(DICE_WON_ROLL, 0,DIM_DICE_BORDER);
        } else {
            setForeground(Color.red);
            g.drawString(DICE_LOST_ROLL, 0,DIM_DICE_BORDER);
        }
    }
}
