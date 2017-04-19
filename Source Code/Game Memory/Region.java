/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public abstract class Region {
    protected String name;
    protected int id;
    protected Player owner;

    public Region(){
        this.name = "";
        this.id = 0;
        this.owner = null;
    }

    public Region(String name, int id, Player owner){
        this.name = name;
        this.owner = owner;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Player getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

}
