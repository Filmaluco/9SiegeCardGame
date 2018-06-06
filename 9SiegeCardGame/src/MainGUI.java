import Controllers.GameController;
import Controllers.ObservableGame;
import UI.Graphical.SiegeCardGUI;
import UI.Text.SiegeCardUI;

public class MainGUI {

    public static void main(String[] args) {
        ObservableGame game = new ObservableGame();
        SiegeCardGUI gui = new SiegeCardGUI(game);
    }
}
