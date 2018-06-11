import Controllers.GameController;
import Controllers.ObservableGame;
import UI.Graphical.SiegeCardGUI;
import UI.Text.SiegeCardUI;

public class Main {

    public static void main(String[] args) {
        ObservableGame game = new ObservableGame();
        new SiegeCardGUI(game);
    }
}
