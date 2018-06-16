package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.ActionPhase;
import Controllers.states.GameSetup;
import UI.Graphical.Rectangles.CardGUI;
import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class DeckDisplay extends JPanel implements Observer, Constants{

    ObservableGame game;
    private CardGUI cardsImages;
    private int[] deck;
    private int currentDay;

    public DeckDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        cardsImages = new CardGUI();
        deck = game.getCardIDS();
        currentDay = 1;

        Dimension d = new Dimension(DIM_X_DECK_DISPLAY,DIM_Y_DECK_DISPLAY);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        this.setVisible(game.getState() instanceof ActionPhase);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i=0; i<game.getCurrentTurn(); i++){
            g.drawImage(cardsImages.getCardImageID(deck[i]),DIM_X_CARD_SIZE/2*i,0,this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (currentDay != game.getCurrentDay()){
            currentDay=game.getCurrentDay();
            deck=game.getCardIDS();
            repaint();
        }
        setVisible(!(game.getState() instanceof GameSetup));
    }
}
