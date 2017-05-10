package Manager;
import GameMemory.*;
/**
 *
 * @author Doga Zeynep Germen
 */
public class DeploymentPhaseManager extends Manager {
    
    private SoldierProductionManager soldierProductionManager;
    private Player player;
    private ArmyUnit unit;
    
    public DeploymentPhaseManager(Game game) {
        super(game);
        soldierProductionManager = new SoldierProductionManager(game);
        // It is considered that the initial value for 'treasury' is 10.
        // We can change it.
        player = game.getPlayers().get(game.getCurPlayerId());
    }

    // We need to get some objects from Game class to fill this method in my
    // opinion. So i couldn't fill it:/
    public int calculateIncome() {
        int newIncome = 0;
        for(int i = 0; i < game.getProvinceList().size(); i++){
            if(game.getProvinceList().get(i).getOwner() == player){
                newIncome++;
            }
        }
        for(int i = 0; i < game.getAreaList().size(); i++){
            if(game.getAreaList().get(i).getOwner() == player){
                newIncome += game.getAreaList().get(i).getBonus().getIncomeBonus();
            }
        }

        player.setIncome(newIncome);
        return newIncome;
    }
    
    public void addIncome() {
        player.setTreasury(player.getTreasury() + player.getIncome());
    }


    // Isn't that relevant with user interface part:/
    // Thus, I skipped this one.
    /*public boolean placeArmyUnitOnMap(ArmyUnit unit) {
        // Setting the current army unit as the lastly placed one on map.
        this.unit = unit;
    }*/
    
    public boolean produceArmyUnit(int type, int amount, int provinceId) {
        soldierProductionManager.produceArmyUnitType(type, amount);
        for(int i = 0; i < amount; i++){
            decreaseTreasury(soldierProductionManager.getArmyUnitArr().get((0)).getCost());
        }
        for(int i = 0; i < soldierProductionManager.getArmyUnitArr().size(); i++){
                game.getProvinceList().get(provinceId).getArmy().addArmyUnit(soldierProductionManager.getArmyUnitArr().get(i));
        }
        return true;
    }
    
    public void decreaseTreasury(int cost) {
       player.setTreasury(player.getTreasury() - cost);
    }
    
    /* boolean soldierProduction() {
        return treasury >= unit.getCost();
    }*/
    
}
