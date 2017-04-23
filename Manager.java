/**
 * Created by Elena Cina
 * 22 April 2017
 */

public abstract class Manager {
    protected Game game;

    public Manager(Game game) {
        this.game = game;
    }
    
    public Game getGame() {
        return game;
    }

    public void setGame (Game game) {
        this.game = game;
    }
    
}

