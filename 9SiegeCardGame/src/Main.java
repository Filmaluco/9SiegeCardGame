import Controllers.GameController;
import UI.Text;

public class Main {

    public static void main(String[] args) {
        Text menu = new Text(new GameController());
        menu.mainMenu();
    }
}
