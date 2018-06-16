package UI.Graphical.Buttons;

import Assets.Resources;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static UI.Graphical.Util.Miscellaneous.*;

public class EnemyTrackerViewButton extends IconsBaseButton {
    static private BufferedImage enemyTrackerViewImage = null;

    public static BufferedImage getEnemyTrackerViewImage() { return enemyTrackerViewImage; }

    static {
        try {
            enemyTrackerViewImage = ImageIO.read(Resources.getResourceFile("Icons/NormalTrackerIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    public EnemyTrackerViewButton() {
        super.setToolTipText(ENEMY_TRACKER_VIEW);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getEnemyTrackerViewImage(), 0,0, this);
    }

}
