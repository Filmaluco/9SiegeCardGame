package UI.Graphical.Rectangles.Enemies.MouseListeners;

import Controllers.ObservableGame;
import Controllers.states.ActionArchersAttack;
import Controllers.states.ActionBoilingAttack;
import SiegeCard.Util.Rolls;
import UI.Graphical.Dice.DiceDisplay;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static SiegeCard.Util.Rolls.BATTERING_RAM;

public class EnemySelect implements MouseListener {
    ObservableGame game;
    JComponent panel;
    Rolls roll;

    public EnemySelect(JComponent panel, ObservableGame game, Rolls roll) {
        this.game = game;
        this.roll = roll;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (game.getState() instanceof ActionArchersAttack || game.getState() instanceof ActionBoilingAttack){
            game.ApplyRules(roll);
            try {
                new DiceDisplay(game, roll);
            } catch (ArrayIndexOutOfBoundsException g){
                System.out.println("Invalid Option!!");
            }

        }
        panel.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (game.getState() instanceof ActionArchersAttack || game.getState() instanceof ActionBoilingAttack)
            panel.setBorder(BorderFactory.createLineBorder(Color.black,3));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        panel.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
