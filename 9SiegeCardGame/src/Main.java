import Controllers.GameController;
import UI.Text.SiegeCardUI;

public class Main {

    public static void main(String[] args) {
        GameController game = new GameController();
        SiegeCardUI text = new SiegeCardUI(game);
        text.start();
    }
}
