package UI.Graphical.DialogBox;

import Assets.Resources;
import UI.Graphical.Util.Constants;
import UI.Graphical.Util.Miscellaneous;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DialogBoxButton extends JLabel implements Constants, Miscellaneous{
    static private BufferedImage dialogBoxButtonImage = null;

    public static BufferedImage getDialogBoxButtonImage() { return dialogBoxButtonImage; }

    static {
        try {
            dialogBoxButtonImage = ImageIO.read(Resources.getResourceFile("DialogBox/DialogBoxButton.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    public DialogBoxButton(String text) {
        super(text);

        Dimension d = new Dimension(DIM_X_DIALOG_BOX_BUTTON,DIM_Y_DIALOG_BOX_BUTTON);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setFont(DIALOG_BOX_FONT);

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getDialogBoxButtonImage(),0,0,this);
    }
}
