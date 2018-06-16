package UI.Graphical.Buttons.Actions.TunnelMovement;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.Actions.ActionArchersAttackListener;
import UI.Graphical.Buttons.Listeners.Actions.TunnelListeners.FreeTunnelMovementListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FreeTunnelMovementButton extends IconsBaseButton {
    static private BufferedImage freeTunnelMovementButton = null, disableFreeTunnelMovementButtonImage = null;

    public static BufferedImage getFreeTunnelMovementButton() { return freeTunnelMovementButton; }
    public static BufferedImage getDisableFreeTunnelMovementButtonImage() { return disableFreeTunnelMovementButtonImage; }

    static {
        try {
            freeTunnelMovementButton = ImageIO.read(Resources.getResourceFile("Icons/FreeTunnelMovement.jpg"));
            disableFreeTunnelMovementButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableFreeTunnelMovement.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public FreeTunnelMovementButton(ObservableGame game) {
        this.game = game;
        addActionListener(new FreeTunnelMovementListener(game));
        setToolTipText("Free Tunnel Movement");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canUseFreeMovement() && game.getActionPoints()>0) {
            g.drawImage(getFreeTunnelMovementButton(), 0,0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableFreeTunnelMovementButtonImage(),0,0,this);
            setEnabled(false);
        }
    }
}
