package lotrriskgame;

/**
 *
 * @author Doga Zeynep Germen
 */
public class DeploymentPhaseManager extends Manager {
    
    private SoldierProductionManager soldierProductionManager;
    private Player player;
    private int treasury;
    private ArmyUnit unit;
    
    public DeploymentPhaseManager() {
        super(game);
        soldierProductionManager = new SoldierProductionManager();
        // It is considered that the initial value for 'treasury' is 1000.
        // We can change it.
        treasury = 1000;
    }

    // We need to get some objects from Game class to fill this method in my
    // opinion. So i couldn't fill it:/
    public int calculateIncome() {
        
    }
    
    public void addIncome() {
        player.setIncome(player.getIncome() + calculateIncome()); 
    }
    
    
    // Isn't that relevant with user interface part:/
    // Thus, I skipped this one.
    public boolean placeArmyUnitOnMap(ArmyUnit unit) {
        // Setting the current army unit as the lastly placed one on map.
        this.unit = unit;
    }
    
    public ArmyUnit[] produceArmyUnit(int type, int amount) {
        return soldierProductionManager.produceArmyUnitType(type, amount);
    }
    
    public int decreaseTreasury() {
        if (soldierProduction()) {
            treasury -= unit.getCost();
        }
    }
    
    public boolean soldierProduction() {
        return treasury >= unit.getCost();
    }
    
}
