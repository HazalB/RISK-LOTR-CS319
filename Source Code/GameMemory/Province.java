package GameMemory;

import java.util.ArrayList;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Province extends Region{
    // TODO Constructors need work
    private ArrayList<Integer> neighboringProvinceList;
    private Army army;

    public Province(){
        super();
        neighboringProvinceList = new ArrayList<Integer>();
        army = null;
    }

    public Province(ArrayList<Integer> neighboringProvinceList, Army army){
        super();
        this.neighboringProvinceList = neighboringProvinceList;
        this.army = army;
    }

    public Army getArmy() {
        return army;
    }

    public ArrayList<Integer> getNeighboringProvinceList() {
        return neighboringProvinceList;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public void setNeighboringProvinceList(ArrayList<Integer> neighboringProvinceList) {
        this.neighboringProvinceList = neighboringProvinceList;
    }

    public void addArmyUnit(ArmyUnit unit){
        army.addArmyUnit(unit);
    }

}
