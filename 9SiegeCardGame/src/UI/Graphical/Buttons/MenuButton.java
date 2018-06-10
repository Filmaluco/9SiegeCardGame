package UI.Graphical.Buttons;

import Assets.Resources;
import UI.Graphical.Constants;
import org.w3c.dom.events.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuButton extends JButton implements Constants{

    static private BufferedImage menuButtonImage = null;

    public static BufferedImage getMenuButtonImage() { return menuButtonImage; }

    static {
        try {
            menuButtonImage = ImageIO.read(Resources.getResourceFile("Buttons/CSG_Normal_Button.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    Dimension d;
    public MenuButton(String text) {
        super(text);
        super.setToolTipText(text);
        d = new Dimension(DIM_X_MENU_BUTTON,DIM_Y_MENU_BUTTON);
        super.setMinimumSize(d);
        super.setPreferredSize(d);
        super.setForeground(Color.ORANGE);
        super.setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 40));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getMenuButtonImage(), 0,0, this);
        g.drawString(getText(),DIM_X_MENU_BUTTON/2-DIM_X_MENU_BUTTON_BORDER,DIM_Y_MENU_BUTTON-DIM_Y_MENU_BUTTON_BORDER);
    }
}
