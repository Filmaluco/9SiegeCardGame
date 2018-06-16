package UI.Graphical.Buttons.Listeners.Actions;

import Controllers.ObservableGame;
import SiegeCard.Util.Rolls;
import UI.Graphical.Dice.DiceDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCloseCombatAttackListener implements ActionListener{
    ObservableGame game;

    public ActionCloseCombatAttackListener(ObservableGame game) { this.game = game; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getActionPoints()>0){
            game.CloseCombat();
            new DiceDisplay(game,Rolls.CLOSE_COMBAT);
        }
    }
}
