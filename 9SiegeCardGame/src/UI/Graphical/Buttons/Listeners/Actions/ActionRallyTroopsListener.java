package UI.Graphical.Buttons.Listeners.Actions;

import Controllers.ObservableGame;
import SiegeCard.Util.Rolls;
import UI.Graphical.DialogBox.DialogBox;
import UI.Graphical.DialogBox.DialogBoxBackground;
import UI.Graphical.DialogBox.DialogBoxFrame;
import UI.Graphical.Dice.DiceDisplay;
import UI.Graphical.SiegeCardGUI;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionRallyTroopsListener implements ActionListener, Miscellaneous{
    ObservableGame game;

    public ActionRallyTroopsListener(ObservableGame game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getActionPoints()>0) {
            game.RallyTroops();
            //TODO: Implement custom dialog box
//            DialogBox dialogBox = new DialogBox(new DialogBoxFrame(), game, DIALOG_BOX_RALLY_TROOPS_TEXT,DIALOG_BOX_OPTION_MORALE, DIALOG_BOX_OPTION_MORALE);
//            dialogBox.setVisible(true);
            int n = JOptionPane.showOptionDialog(
                    new DialogBoxFrame(),
                    DIALOG_BOX_RALLY_TROOPS_TEXT,
                    DIALOG_BOX_RALLY_TROOPS_MENU,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    DIALOG_BOX_RALLY_TROOPS_OPTIONS,
                    DIALOG_BOX_RALLY_TROOPS_OPTIONS[1]);
            //0 is yes, 1 is no
            if (n==0) {
                game.ApplyRules(Rolls.BOOST_RALLY_TROOPS);
                new DiceDisplay(game,Rolls.BOOST_RALLY_TROOPS);
            }
            else if (n==1) {
                game.ApplyRules(Rolls.RALLY_TROOPS);
                new DiceDisplay(game,Rolls.RALLY_TROOPS);
            }
        }
    }
}
