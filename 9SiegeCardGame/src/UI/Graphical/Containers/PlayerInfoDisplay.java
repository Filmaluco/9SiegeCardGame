package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.CardPhase;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class PlayerInfoDisplay extends JPanel implements Observer{

    ObservableGame game;
    //Todo: Criar a label e fazer update dela

    public PlayerInfoDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (game.getState() instanceof CardPhase){
            game.StartTurn();
        }
    }
}
