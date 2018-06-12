package UI.Graphical.Buttons;

import Assets.Resources;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static UI.Graphical.Util.Miscellaneous.TUNNEL_VIEW;

public class TunnelViewButton extends IconsBaseButton {
    static private BufferedImage tunnelViewButtonImage = null;

    public static BufferedImage getTunnelViewButtonImage() { return tunnelViewButtonImage; }

    static {
        try {
            tunnelViewButtonImage = ImageIO.read(Resources.getResourceFile("Icons/TunnelIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    public TunnelViewButton() {
        super.setToolTipText(TUNNEL_VIEW);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getTunnelViewButtonImage(), 0,0, this);
    }
}
