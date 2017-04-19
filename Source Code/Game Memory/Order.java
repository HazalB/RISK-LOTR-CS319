/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public abstract class Order {
    protected Province provinceFrom, provinceTo;
    protected Army army;

    public Order(){
        provinceFrom = null;
        provinceTo = null;
        army = null;
    }

    public Order(Province from, Province to, Army army){
        this.provinceFrom = from;
        this.provinceTo = to;
        this.army = army;
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
}
