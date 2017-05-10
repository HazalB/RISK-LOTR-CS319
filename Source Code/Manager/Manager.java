package Manager;
/**
 * Created by Elena Cina
 * 22 April 2017
 */
import GameMemory.*;

public abstract class Manager extends Game {
    protected Game game;
    
    //constructor
    public Manager(Game game) {
        this.game = game;
    }
    //getter for game object
    public Game getGame() {
        return game;
    }
    //setter for game object
    public void setGame (Game game) {
        this.game = game;
    }  
}

