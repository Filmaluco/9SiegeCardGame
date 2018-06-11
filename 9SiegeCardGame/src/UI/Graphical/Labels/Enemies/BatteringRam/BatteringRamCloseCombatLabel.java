package UI.Graphical.Labels.Enemies.BatteringRam;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Labels.CloseCombatLabel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BatteringRamCloseCombatLabel extends CloseCombatLabel {
    ObservableGame game;
    int id;
    static private BufferedImage batteringRamCloseCombatImage = null;

    public static BufferedImage getBatteringRamCloseCombatImage() { return batteringRamCloseCombatImage; }

    static {
        try {
            batteringRamCloseCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/BatteringRamCloseCombat.png"));
        } catch (IOException e) {
            System.out.println("Error loading Ladder Combat Image");
        }
    }

    public BatteringRamCloseCombatLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getBatteringRamPosition() == id){
            g.drawImage(getBatteringRamCloseCombatImage(),0,0,this);
        }else{
            g.drawImage(getCloseCombatImage(),0,0,this);
        }
    }
}
