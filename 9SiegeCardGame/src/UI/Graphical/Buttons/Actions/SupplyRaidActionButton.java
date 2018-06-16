package UI.Graphical.Buttons.Actions;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.Actions.ActionSabotageListener;
import UI.Graphical.Buttons.Listeners.Actions.SupplyRaidActionListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static UI.Graphical.Util.Miscellaneous.SABOTAGE_ACTION;

public class SupplyRaidActionButton extends IconsBaseButton {
    static private BufferedImage supplyRaidActionButtonImage = null, disableSupplyRaidActionButtonImage = null;

    public static BufferedImage getSupplyRaidActionButtonImage() { return supplyRaidActionButtonImage; }
    public static BufferedImage getDisableSupplyRaidActionButtonImage() { return disableSupplyRaidActionButtonImage; }

    static {
        try {
            supplyRaidActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/SupplyRaidIcon.jpg"));
            disableSupplyRaidActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableSupplyRaidIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public SupplyRaidActionButton(ObservableGame game) {
        this.game = game;
        addActionListener(new SupplyRaidActionListener(game));
        setToolTipText("Supply Raid Action");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canSupplyRaid() && game.getActionPoints()>0) {
            g.drawImage(getSupplyRaidActionButtonImage(), 0,0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableSupplyRaidActionButtonImage(),0,0,this);
            setEnabled(false);
        }
    }
}
