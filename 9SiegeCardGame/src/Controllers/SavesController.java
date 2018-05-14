package Controllers;

import Models.GameDataModel;

import java.io.*;

public class SavesController {

    private boolean cache;
    private GameController savedGame;

    public SavesController(){}

    public  GameController loadGame(String name) throws IOException, ClassNotFoundException {

        GameController savedGame;

        ObjectInputStream in = null;

        String filename = name + ".bin";

        try{

            in = new ObjectInputStream(new FileInputStream(filename));
            savedGame = (GameController) in.readObject();

        } finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) { }
            }
        }

        return savedGame;
    }




    public boolean saveGame(GameController game,String name){

        ObjectOutputStream out = null;

        String filename = name + ".bin";

        try {
            out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(game);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {}
            }
        }
    }

    public boolean checkFile(String file){
        //Todo: implement
        return false;
    }



}
