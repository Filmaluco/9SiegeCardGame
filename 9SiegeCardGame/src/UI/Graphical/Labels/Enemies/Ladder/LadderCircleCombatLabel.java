package UI.Graphical.Labels.Enemies.Ladder;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Labels.CircleCombatLabel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LadderCircleCombatLabel extends CircleCombatLabel{
    ObservableGame game;
    int id;
    static private BufferedImage ladderCircleCombatImage = null;

    public static BufferedImage getLadderCircleCombatImage() { return ladderCircleCombatImage; }

    static {
        try {
            ladderCircleCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/LadderBoilZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Ladder Combat Image");
        }
    }

    public LadderCircleCombatLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getLadderPosition() == id){
            g.drawImage(getLadderCircleCombatImage(),0,0,this);
        }else{
            g.drawImage(getCircleCombatImage(),0,0,this);
        }
    }
}
