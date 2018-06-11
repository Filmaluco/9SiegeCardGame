package UI.Graphical.Labels.Enemies.BatteringRam;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Labels.CircleCombatLabel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BatteringRamCircleCombatLabel extends CircleCombatLabel{
    ObservableGame game;
    int id;
    static private BufferedImage batteringRamCircleCombatImage = null;

    public static BufferedImage getBatteringRamCircleCombatImage() { return batteringRamCircleCombatImage; }

    static {
        try {
            batteringRamCircleCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/BatteringRamBoilZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Ladder Combat Image");
        }
    }

    public BatteringRamCircleCombatLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getBatteringRamPosition() == id){
            g.drawImage(getBatteringRamCircleCombatImage(),0,0,this);
        }else{
            g.drawImage(getCircleCombatImage(),0,0,this);
        }
    }
}
