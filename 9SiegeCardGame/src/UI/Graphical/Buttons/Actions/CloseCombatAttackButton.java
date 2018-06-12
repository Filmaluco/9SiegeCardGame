package UI.Graphical.Buttons.Actions;

import Assets.Resources;
import Controllers.ObservableGame;
import Controllers.states.ActionArchersAttack;
import Controllers.states.ActionPhase;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.ActionCloseCombatAttackListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class CloseCombatAttackButton extends IconsBaseButton{
    static private BufferedImage closeCombatAttackButtonImage = null, disableCloseCombatAttackButtonImage = null;

    public static BufferedImage getCloseCombatAttackButtonImage() { return closeCombatAttackButtonImage; }
    public static BufferedImage getDisableCloseCombatAttackButtonImage() { return disableCloseCombatAttackButtonImage; }

    static {
        try {
            closeCombatAttackButtonImage = ImageIO.read(Resources.getResourceFile("Icons/CloseCombatIcon.jpg"));
            disableCloseCombatAttackButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableCloseCombatIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public CloseCombatAttackButton(ObservableGame game) {
        this.game = game;
        addActionListener(new ActionCloseCombatAttackListener(game));
        setToolTipText("Close Combat Attack");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canCloseCombat() && game.getActionPoints()>0) {
            g.drawImage(getCloseCombatAttackButtonImage(), 0,0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableCloseCombatAttackButtonImage(),0,0,this);
            setEnabled(false);
        }
    }

}
