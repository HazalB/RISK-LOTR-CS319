package lotrriskgame;

/**
 *
 * @author Doga Zeynep Germen
 */
public class SoldierProductionManager extends Manager{
    
    private ArmyUnit[] armyUnitArr;
    
    public SoldierProductionManager(Game game) {
        super(game);
    }
    
    public void produceArmyUnitType(int type, int amount) {
        armyUnitArr = new ArmyUnit[amount];
        for (int i = 0; i < amount; i++) {

            armyUnitArr = new ArmyUnit(type);
        }
    }
    
}
