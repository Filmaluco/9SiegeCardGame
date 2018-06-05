import Controllers.GameController;
import UI.Text.Text;

public class Main {

    public static void main(String[] args) {
        GameController game = new GameController();
        Text text = new Text(game);
        text.start();
    }
}
