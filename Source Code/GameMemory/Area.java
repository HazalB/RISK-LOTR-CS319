package GameMemory;

import java.util.ArrayList;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Area extends Region {
    private Bonus bonus;
    private ArrayList<Integer> provinceIds;

    public Area(Bonus bonus){
        this.bonus = bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public ArrayList<Integer> getProvinceIds() {
        return provinceIds;
    }

    public void setProvinceIds(ArrayList<Integer> provinceIds) {
        this.provinceIds = provinceIds;
    }
}
