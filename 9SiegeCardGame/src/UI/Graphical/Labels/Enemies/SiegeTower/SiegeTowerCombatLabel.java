package UI.Graphical.Labels.Enemies.SiegeTower;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Labels.CombatLabel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SiegeTowerCombatLabel extends CombatLabel{
    ObservableGame game;
    int id;
    static private BufferedImage siegeTowerCombatImage = null;

    public static BufferedImage getSiegeTowerCombatImage() { return siegeTowerCombatImage; }

    static {
        try {
            siegeTowerCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/SiegeTowerNormalAttackZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Ladder Combat Image");
        }
    }

    public SiegeTowerCombatLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getSiegeTowerPosition() == id){
            g.drawImage(getSiegeTowerCombatImage(),0,0,this);
        }else{
            g.drawImage(getCombatImage(),0,0,this);
        }
    }
}
