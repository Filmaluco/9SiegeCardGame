package UI.Graphical.Labels.PlayerTracker;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static UI.Graphical.Util.Miscellaneous.SUPPLIES_FONT;

public class SuppliesLabel extends JLabel implements Constants{

    static private BufferedImage suppliesImage = null;

    public static BufferedImage getSuppliesImage() { return suppliesImage; }

    static {
        try {
            suppliesImage = ImageIO.read(Resources.getResourceFile("Icons/SuppliesIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;
    private int amount;

    public SuppliesLabel(ObservableGame game, int amount) {
        this.game = game;
        this.amount = amount;
        Dimension d = new Dimension(DIM_X_STATUS_TRACK,DIM_Y_STATUS_TRACK);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setBorder(new EmptyBorder(5,5,5,5));
        setForeground(Color.WHITE);
        setFont(SUPPLIES_FONT);
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setText(Integer.toString(amount));
        g.drawImage(getSuppliesImage(),DIM_X_STATUS_TRACK_BORDER,DIM_Y_STATUS_TRACK_BORDER,this);
    }
}
