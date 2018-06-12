package UI.Graphical.Buttons.Actions;

import Assets.Resources;
import Controllers.ObservableGame;
import Controllers.states.ActionArchersAttack;
import Controllers.states.ActionPhase;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.ActionArchersAttackListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ArchersAttackButton extends IconsBaseButton{
    static private BufferedImage archersAttackButtonImage = null, disableArchersAttackButtonImage = null;

    public static BufferedImage getArchersAttackButtonImage() { return archersAttackButtonImage; }
    public static BufferedImage getDisableArchersAttackButtonImage() { return disableArchersAttackButtonImage; }

    static {
        try {
            archersAttackButtonImage = ImageIO.read(Resources.getResourceFile("Icons/ArchersAttackIcon.jpg"));
            disableArchersAttackButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableArchersAttackIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public ArchersAttackButton(ObservableGame game) {
        this.game = game;
        addActionListener(new ActionArchersAttackListener(game));
        setToolTipText("Archers Attack");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canArchersAttack() && game.getActionPoints()>0) {
            g.drawImage(getArchersAttackButtonImage(), 0,0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableArchersAttackButtonImage(),0,0,this);
            setEnabled(false);
        }
    }

}
