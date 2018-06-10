package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.CardPhase;
import Controllers.states.GameSetup;
import UI.Graphical.Labels.PlayerInfoLabel;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class PlayerInfoDisplay extends JPanel implements Observer{

    ObservableGame game;
    PlayerInfoLabel playerInfo;
    //Todo: Criar a label e fazer update dela

    public PlayerInfoDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        playerInfo = new PlayerInfoLabel(this.game);

        this.setVisible(!(game.getState() instanceof GameSetup));
    }

    @Override
    public void update(Observable o, Object arg) {
        //Aparece em todos os estados menos no GameSetup
        setVisible(!(game.getState() instanceof GameSetup));
        if (game.getState() instanceof CardPhase){
            game.StartTurn();
        }
    }
}
