package UI.Graphical.Labels;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MoraleLabel extends JLabel implements Constants{

    static private BufferedImage moraleImage = null;

    public static BufferedImage getMoraleImage() { return moraleImage; }

    static {
        try {
            moraleImage = ImageIO.read(Resources.getResourceFile("Icons/MoraleIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;
    private int amount;

    public MoraleLabel(ObservableGame game, int amount) {
        this.game = game;
        this.amount = amount;
        Dimension d = new Dimension(150,86);

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
        g.drawImage(getMoraleImage(),DIM_X_STATUS_TRACK_BORDER,0,this);
    }
}
