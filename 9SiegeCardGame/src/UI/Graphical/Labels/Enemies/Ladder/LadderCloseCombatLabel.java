package UI.Graphical.Labels.Enemies.Ladder;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Labels.CloseCombatLabel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LadderCloseCombatLabel extends CloseCombatLabel{
    ObservableGame game;
    int id;
    static private BufferedImage ladderCloseCombatImage = null;

    public static BufferedImage getLadderCloseCombatImage() { return ladderCloseCombatImage; }

    static {
        try {
            ladderCloseCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/LadderCloseCombat.png"));
        } catch (IOException e) {
            System.out.println("Error loading Ladder Combat Image");
        }
    }

    public LadderCloseCombatLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getLadderPosition() == id){
            g.drawImage(getLadderCloseCombatImage(),0,0,this);
        }else{
            g.drawImage(getCloseCombatImage(),0,0,this);
        }
    }
}
