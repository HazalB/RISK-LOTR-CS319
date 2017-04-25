
public class DeploymentPhaseManager extends Manager{
	
	public DeploymentPhaseManager(Game game)
	{
		super(game);
	}
	
	SoldierProductionManager soldierProductionManager = new SoldierProductionManager();
	
	Player player = new Player();
	
	public int calculateIncome()
	{
		
	}
	public void addIncome()
	{
		player.setIncome(player.getIncome() + calculateIncome());
	}
	public boolean placeArmyUnitOnMap(ArmyUnit unit)
	{
		
	}
	public ArmyUnit[] produceArmyUnit()
	{
		return soldierProductionManager.produceArmyUnitType();
	}
	public int decreaseTreasury()
	{
		
	}
	public boolean soldierProduction()
	{
		
	}

}
