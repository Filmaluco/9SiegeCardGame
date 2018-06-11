package UI.Graphical.Labels.Enemies.SiegeTower;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Labels.CloseCombatLabel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SiegeTowerCloseCombatLabel extends CloseCombatLabel {
    ObservableGame game;
    int id;
    static private BufferedImage siegeTowerCloseCombatImage = null;

    public static BufferedImage getSiegeTowerCloseCombatImage() { return siegeTowerCloseCombatImage; }

    static {
        try {
            siegeTowerCloseCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/SiegeTowerCloseCombat.png"));
        } catch (IOException e) {
            System.out.println("Error loading Ladder Combat Image");
        }
    }

    public SiegeTowerCloseCombatLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getSiegeTowerPosition() == id){
            g.drawImage(getSiegeTowerCloseCombatImage(),0,0,this);
        }else{
            g.drawImage(getCloseCombatImage(),0,0,this);
        }
    }
}
