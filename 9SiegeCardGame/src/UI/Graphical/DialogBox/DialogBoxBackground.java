package UI.Graphical.DialogBox;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DialogBoxBackground extends JPanel implements Constants{

    static private BufferedImage dialogBoxBackgroundImage = null;

    public static BufferedImage getDialogBoxBackgroundImage() { return dialogBoxBackgroundImage; }

    static {
        try {
            dialogBoxBackgroundImage = ImageIO.read(Resources.getResourceFile("DialogBox/DialogBoxBackground.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }


    public DialogBoxBackground() {
        Dimension d = new Dimension(DIM_X_DIALOG_BOX,DIM_Y_DIALOG_BOX);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getDialogBoxBackgroundImage(),0,0,this);
    }
}
