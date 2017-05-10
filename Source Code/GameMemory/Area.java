package GameMemory;
/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Area extends Region {
    private Bonus bonus;

    public Area(Bonus bonus){
        this.bonus = bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public Bonus getBonus() {
        return bonus;
    }
}
