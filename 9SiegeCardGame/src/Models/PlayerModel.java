package Models;

public class PlayerModel {


    private String name;
    private PlayerTackerModel tracker;

    public PlayerModel(){
        tracker = new PlayerTackerModel();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean hasName(){ return name!=null;}




}
