package UI.Graphical.Labels.Enemies.SiegeTower;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Labels.CircleCombatLabel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SiegeTowerCircleCombatLabel extends CircleCombatLabel{
    ObservableGame game;
    int id;
    static private BufferedImage siegeTowerCircleCombatImage = null;

    public static BufferedImage getSiegeTowerCircleCombatImage() { return siegeTowerCircleCombatImage; }

    static {
        try {
            siegeTowerCircleCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/SiegeTowerBoilZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Ladder Combat Image");
        }
    }

    public SiegeTowerCircleCombatLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getSiegeTowerPosition() == id){
            g.drawImage(getSiegeTowerCircleCombatImage(),0,0,this);
        }else{
            g.drawImage(getCircleCombatImage(),0,0,this);
        }
    }
}
