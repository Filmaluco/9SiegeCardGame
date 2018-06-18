import Controllers.GameController;
import Controllers.ObservableGame;
import UI.Graphical.SiegeCardGUI;
import UI.Text.SiegeCardUI;

public class Main {

    public static void main(String[] args) {
        //GameController game = new GameController();
        //SiegeCardUI text = new SiegeCardUI(game);
        //text.start();
        ObservableGame game = new ObservableGame();
        new SiegeCardGUI(game);
    }
}
