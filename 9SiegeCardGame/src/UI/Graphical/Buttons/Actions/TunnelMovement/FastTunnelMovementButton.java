package UI.Graphical.Buttons.Actions.TunnelMovement;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.Actions.ActionArchersAttackListener;
import UI.Graphical.Buttons.Listeners.Actions.TunnelListeners.FastTunnelMovementListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FastTunnelMovementButton extends IconsBaseButton {
    static private BufferedImage fastTunnelMovementButton = null, disableFastTunnelMovementButtonImage = null;

    public static BufferedImage getFastTunnelMovementButton() { return fastTunnelMovementButton; }
    public static BufferedImage getDisableFastTunnelMovementButtonImage() { return disableFastTunnelMovementButtonImage; }

    static {
        try {
            fastTunnelMovementButton = ImageIO.read(Resources.getResourceFile("Icons/FastTunnelMovement.jpg"));
            disableFastTunnelMovementButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableFastTunnelMovement.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public FastTunnelMovementButton(ObservableGame game) {
        this.game = game;
        addActionListener(new FastTunnelMovementListener(game));
        setToolTipText("Fast Tunnel Movement");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canUseFastMovement() && game.getActionPoints()>0) {
            g.drawImage(getFastTunnelMovementButton(), 0,0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableFastTunnelMovementButtonImage(),0,0,this);
            setEnabled(false);
        }
    }
}
