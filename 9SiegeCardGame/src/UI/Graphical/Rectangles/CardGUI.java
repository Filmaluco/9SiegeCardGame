package UI.Graphical.Rectangles;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class CardGUI extends JPanel implements Constants{

    ObservableGame game;

    public static ArrayList<BufferedImage> cardsImages;

    static {
        cardsImages = new ArrayList<>();
        try {
            for (int i = 1; i <= NUMBER_OF_CARDS; i++) {
                cardsImages.add(ImageIO.read(Resources.getResourceFile("Cartas/Carta"+i+"Resize.jpg")));
            }
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }


    public CardGUI() {
        Dimension d = new Dimension(DIM_X_CARD_SIZE, DIM_Y_CARD_SIZE);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);
    }

    public Image getCardImageID(int id) {
        return cardsImages.get(id-1);
    }
}
