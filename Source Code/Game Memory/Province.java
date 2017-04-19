import java.util.ArrayList;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Province {
    // TODO AddArmy Method
    // TODO neighboring Provinces
    private ArrayList<Province> neighboringProvinceList;
    private Army army;

    public Province(){
        neighboringProvinceList = new ArrayList<Province>();
        army = null;
    }

    public Province(ArrayList<Province> neighboringProvinceList, Army army){
        this.neighboringProvinceList = neighboringProvinceList;
        this.army = army;
    }

    public Army getArmy() {
        return army;
    }

    public ArrayList<Province> getNeighboringProvinceList() {
        return neighboringProvinceList;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public void setNeighboringProvinceList(ArrayList<Province> neighboringProvinceList) {
        this.neighboringProvinceList = neighboringProvinceList;
    }
}
