package UI.Graphical.Labels.Enemies.BatteringRam;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Labels.CombatLabel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BatteringRamCombatLabel extends CombatLabel {
    ObservableGame game;
    int id;
    static private BufferedImage batteringRamCombatImage = null;

    public static BufferedImage getBatteringRamCombatImage() { return batteringRamCombatImage; }

    static {
        try {
            batteringRamCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/BatteringRamNormalAttackZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Ladder Combat Image");
        }
    }

    public BatteringRamCombatLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getBatteringRamPosition() == id){
            g.drawImage(getBatteringRamCombatImage(),0,0,this);
        }else{
            g.drawImage(getCombatImage(),0,0,this);
        }
    }
}
