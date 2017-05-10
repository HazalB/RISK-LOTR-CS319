package GameMemory;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public abstract class Order {
    protected Province provinceFrom, provinceTo;
    protected Army army;
    protected Player player;

    public Order(){
        provinceFrom = null;
        provinceTo = null;
        army = null;
        player = null;
    }

    public Player getPlayer() {
        return player;
    }

    public Order(Province from, Province to, Army army, Player player){
        this.provinceFrom = from;
        this.provinceTo = to;
        this.army = army;
        this.player = player;
    }

    public Army getArmy() {
        return army;
    }

    public Province getProvinceFrom() {
        return provinceFrom;
    }

    public Province getProvinceTo() {
        return provinceTo;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setProvinceFrom(Province provinceFrom) {
        this.provinceFrom = provinceFrom;
    }

    public void setProvinceTo(Province provinceTo) {
        this.provinceTo = provinceTo;
    }
}
