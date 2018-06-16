package UI.Graphical.Dice;

import Assets.Resources;
import Controllers.ObservableGame;
import SiegeCard.Util.Rolls;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class DiceDisplay extends JDialog implements Constants {
    ObservableGame game;
    Rolls target;
    int rollNeeded;
    int lastRoll;

    private LastRollLabel lastRollLabel;
    private RollNeededLabel rollNeededLabel;
    private RollStatusLabel rollStatusLabel;

    public static ArrayList<BufferedImage> diceImages;

    static {
        diceImages = new ArrayList<>();
        try {
            for (int i = 1; i <= 6; i++) {
                diceImages.add(ImageIO.read(Resources.getResourceFile("Dice/Dice"+i+".png")));
            }
        } catch (IOException e) {
            System.out.println("Error loading Dice Images");
        }
    }

    public DiceDisplay(ObservableGame game, Rolls target) {
        this.game = game;
        this.target = target;
        setLocationRelativeTo(null);

        Dimension d = new Dimension(DIM_X_DICE,DIM_Y_DICE);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setupComponents();
        layoutComponents();

        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Dice");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setupComponents() {
        setRollNeeded(target);
        lastRoll = game.getLastRoll();
        rollNeededLabel = new RollNeededLabel(rollNeeded, diceImages.get(rollNeeded-1));
        lastRollLabel = new LastRollLabel(lastRoll, diceImages.get(lastRoll-1));
        rollStatusLabel = new RollStatusLabel(lastRoll, rollNeeded);
    }

    private void layoutComponents() {
        setBackground(Color.lightGray);
        setVisible(true);
        setLayout(new GridLayout(3,0));
        add(rollNeededLabel);
        add(lastRollLabel);
        add(rollStatusLabel);
    }

    private void setRollNeeded(Rolls target) {
        switch (target){
            case BATTERING_RAM: rollNeeded = game.batteringRamStrength(); break;
            case LADDER: rollNeeded = game.ladderStrength(); break;
            case SIEGE_TOWER: rollNeeded = game.siegeTowerStrength(); break;
            case CLOSE_COMBAT: rollNeeded = 4; break;
            case RALLY_TROOPS: rollNeeded = 4; break;
            case BOOST_RALLY_TROOPS: rollNeeded = 3; break;
            case COUPURE_ROLL: rollNeeded = 4; break;
            case SUPPLY_RAID_ROLL: rollNeeded = 2; break;
            case SABOTAGE_ROLL: rollNeeded = 4; break;
            default: return;
        }
    }
}
