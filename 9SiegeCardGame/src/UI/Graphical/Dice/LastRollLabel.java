package UI.Graphical.Dice;

import UI.Graphical.Util.Constants;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LastRollLabel extends JLabel implements Constants, Miscellaneous {
    int lastRoll;
    BufferedImage rollImage;

    public LastRollLabel(int lastRoll, BufferedImage rollImage) {
        this.lastRoll = lastRoll;
        this.rollImage = rollImage;

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
        g.drawString(DICE_LAST_ROLL, 0,DIM_DICE_BORDER);
        g.drawImage(rollImage,0,DIM_DICE_BORDER * 2,this);
    }
}
