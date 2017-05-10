package Manager;
import GameMemory.*;

import java.util.ArrayList;

/**
 *
 * @author Doga Zeynep Germen
 */
public class SoldierProductionManager extends Manager{

    private ArrayList<ArmyUnit> armyUnitArr;
    
    public SoldierProductionManager(Game game) {
        super(game);
        armyUnitArr = new ArrayList<ArmyUnit>();
    }
    
    public void produceArmyUnitType(int type, int amount) {
        for (int i = 0; i < amount; i++) {
            if(type == 0){
                armyUnitArr.add(new Archer());
            }
            else if(type == 1){
                armyUnitArr.add(new Axemen());
            }
            else if(type == 2){
                armyUnitArr.add(new Cavalry());
            }
            else if(type == 3){
                armyUnitArr.add(new Mumakil());
            }
            else if(type == 4){
                armyUnitArr.add(new Nazgul());
            }
            else if(type == 5){
                armyUnitArr.add(new Spearmen());
            }
            else if(type == 6){
                armyUnitArr.add(new Swordsmen());
            }
            else if(type == 7){
                armyUnitArr.add(new WargRider());
            }
        }
    }

    public ArrayList<ArmyUnit> getArmyUnitArr() {
        return armyUnitArr;
    }

    public void setArmyUnitArr(ArrayList<ArmyUnit> armyUnitArr) {
        this.armyUnitArr = armyUnitArr;
    }
}
