package UI.Graphical.Labels.Enemies.Ladder;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Labels.CloseCombatLabel;
import UI.Graphical.Labels.CombatLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LadderCombatLabel extends CombatLabel{
    ObservableGame game;
    int id;
    static private BufferedImage ladderCombatImage = null;

    public static BufferedImage getLadderCombatImage() { return ladderCombatImage; }

    static {
        try {
            ladderCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/LadderNormalAttackZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Ladder Combat Image");
        }
    }

    public LadderCombatLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getLadderPosition() == id){
            g.drawImage(getLadderCombatImage(),0,0,this);
        }else{
            g.drawImage(getCombatImage(),0,0,this);
        }
    }
}
