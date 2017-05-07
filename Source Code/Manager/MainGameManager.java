/**
 * Created by Elena Cina
 * 22 April 2017
 */

public class MainGameManager extends Manager 
{
	private PersistentDataManager persistentDataManager;
	private DeploymentDataManager deploymentDataManager; 
	private MobilityPhaseManager mobilityPhaseManager; 
	private ExecutionPhaseManager executionPhaseManager; 
	private SoundManager soundManager; 
	public MainGameManager() {
	        super(null);
	    }
	Game game = new Game ();
	
	public void executePhases(){
		//first phase
		if (game.getCurPhase==1)//means that  deployment phase will be executed
		{
			//gets input from GUI
			deploymentDateManager.calculateIncome();
			deploymentDateManager.addIncome();
			deploymentDateManager.placeArmyUnitOnMap(ArmyUnit army);
			deploymentDateManager.produceArmyUnit();
			deploymentDateManager.decreaseTreasury();
			deploymentDateManager.soldierProduction();
		}
		//second phase		
		if (game.getCurPhase==2)//means that mobility phase will be executed
		{
			mobilityPhaseManager.addOrder(Order order)//gets order from gui
		}
		//third phase
		if (game.getCurPhase==3)//execution phase will be executed
		{
			//executes all the orders
			executionPhaseManager.executeOrderList();
		}
	}
	
	public void endTurn()
	{
		//turn ends when there is no player left on that specific turn
		//compare the id of current player with the id of the last player in players list
		//if it is equal turn ends; else we do nothing her
		if (game.getCurPlayerId()== game.getPlayers(game.NumPlayers()-1))
		{
			//set current phase to first phase
			game.setCurPhase(1);
			//increment the number of turns
			game.getTurnNo = game.getTurnNo+1; 	
		}
	}
	
	public void initializeGame()
	{//starts a new game
		//sets all game instances to what the player specifies
		//we get the input from gui
		game.setNumPlayers(numPlayers);//gets parameter from gui
		game.setPlayers(players); //from gui
		game.setCurPhase(1);
		game.setCurPlayerId(curPlayerId);
		game.setTurnNo(turnNo);
		game.setOrderList(orderList);
		game.setLoserPlayerIds(loserPlayerIds);
		game.setProvinceList(provinceList);
	}
	
	public void getPermanentGameData()
	{
		int income = deploymentDataManager.calculateIncom();
		vector<vector<string>> unitInfo = persistentDataManager.getArmyUnitInfo();
		vector<vector<string>> factionInfo = persistentDataManager.getFactionInfo();
		vector <string> provinceInfo = persistentDataManager.getProvinceInfo();
		vector<vector<string>> areaInfo	= persistentDataManager.getAreaInfo();
		
	}
	
	public void playSound(){
		soundManager.playBSound();
		
	}
	
	public void updateScreen(){
		//there should be a sreenManager 
	}
}
