package GameMemory;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Army {
    private ArrayList<ArmyUnit> units;
    private int armySize;

    public Army(){
        units = new ArrayList<ArmyUnit>();
        armySize = 0;
    }

    public Army(ArrayList<ArmyUnit> units){
        this.units = units;
        armySize = units.size();
    }

    public void addArmyUnit(ArmyUnit unit){
        units.add(unit);
        armySize++;
    }

    public void setArmySize(int armySize) {
        this.armySize = armySize;
    }

    public ArmyUnit removeArmyUnit(){
        ArmyUnit removed = units.remove(armySize - 1);
        armySize--;
        return removed;
    }

    public ArrayList<ArmyUnit> getUnits() {
        return units;
    }

    public int getArmySize() {
        return armySize;
    }

    public void setUnits(ArrayList<ArmyUnit> units) {
        this.units = units;
        armySize = units.size();
    }
}
