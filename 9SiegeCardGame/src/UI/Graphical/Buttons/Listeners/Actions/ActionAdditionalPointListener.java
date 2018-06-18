package UI.Graphical.Buttons.Listeners.Actions;

import Controllers.ObservableGame;
import SiegeCard.Util.Constants;
import SiegeCard.Util.Rolls;
import UI.Graphical.DialogBox.DialogBoxFrame;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionAdditionalPointListener implements ActionListener, Miscellaneous{
    ObservableGame game;

    public ActionAdditionalPointListener(ObservableGame game) { this.game = game; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getActionPoints()>0)
            game.Adicional();

        int n = JOptionPane.showOptionDialog(
                new DialogBoxFrame(),
                DIALOG_BOX_ADDITIONAL_POINT_TEXT,
                DIALOG_BOX_ADDITIONAL_POINT_MENU,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                DIALOG_BOX_ADDITIONAL_POINT_OPTIONS,
                DIALOG_BOX_ADDITIONAL_POINT_OPTIONS[0]);
        //0 is Supply, 1 is Morale
        if (n==0) game.ApplyRules(Constants.SUPPLY);
        else if (n==1) game.ApplyRules(Constants.MORALE);
    }
}
