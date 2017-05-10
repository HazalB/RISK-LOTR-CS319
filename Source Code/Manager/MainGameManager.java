package Manager;
/**
 * Created by Elena Cina
 * 22 April 2017
 */
import GameMemory.*;

import java.util.ArrayList;

public class MainGameManager extends Manager
{
	private PersistentDataManager persistentDataManager;
	private DeploymentPhaseManager deploymentPhaseManager;
	private MobilityPhaseManager mobilityPhaseManager; 
	private ExecutionPhaseManager executionPhaseManager; 
	private SoundManager soundManager; 
	public MainGameManager() {
	        super(null);
	    }
	Game game = new Game ();
	
	public void executePhases(){
		//first phase
		if (game.getCurPhase() == 1)//means that  deployment phase will be executed
		{
			//gets input from GUI
			deploymentPhaseManager.calculateIncome();
			deploymentPhaseManager.addIncome();
		}
		//second phase		
		if (game.getCurPhase() == 2)//means that mobility phase will be executed
		{
			//mobilityPhaseManager.addOrder(Order order)//gets order from gui
		}
		//third phase
		if (game.getCurPhase() == 3)//execution phase will be executed
		{
			//executes all the orders
			executionPhaseManager.executeOrderList();
		}
	}

	public boolean addArmyUnit(int type, int amount, int provinceId){
		int cost = 0;
		if(type == 0){
			cost = 1;
		}
		else if(type == 1){
			cost = 1;
		}
		else if(type == 2){
			cost = 2;
		}
		else if(type == 3){
			cost = 3;
		}
		else if(type == 4){
			cost = 5;
		}
		else if(type == 5){
			cost = 1;
		}
		else if(type == 6){
			cost = 1;
		}
		else{
			cost = 2;
		}
		if(cost * amount > game.getPlayers().get(game.getCurPlayerId()).getTreasury()){
			deploymentPhaseManager.produceArmyUnit(type, amount, provinceId);
			return true;
		}
		else{
			return false;
		}
	}

	public boolean addOrder(Order order){
		if(order.getPlayer() == order.getProvinceFrom().getOwner()){
			mobilityPhaseManager.addOrder(order);
			return true;
		}
		else{
			return false;
		}
	}
	
	public void endTurn()
	{
		//turn ends when there is no player left on that specific turn
		//compare the id of current player with the id of the last player in players list
		//if it is equal turn ends; else we do nothing her
		if (getCurPhase() == 3){
			game.setCurPlayerId(game.getPlayers().get(0).getId());
			//set current phase to first phase
			game.setCurPhase(1);
			//increment the number of turns
			game.setTurnNo(game.getTurnNo() + 1);
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

	public int convertHtoM(int index){
		if(index > 5){
			return index - 2;
		}
		else{
			return index - 1;
		}
	}

	public int convertMtoH(int index){
		if(index >= 5){
			return index + 2;
		}
		else{
			return index + 1;
		}
	}


	public int getCurPhase(){
		return game.getCurPhase();
	}

	public ArrayList<Integer> getCurPlayerProvinces(){
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < game.getProvinceList().size(); i++){
			indices.add(convertMtoH(game.getProvinceList().get(i).getId()));
		}
		return indices;
	}

	public ArrayList<Integer> getTotalSoldiers(){
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < game.getProvinceList().size(); i++){
			indices.add(game.getProvinceList().get(i).getId());
		}

		ArrayList<Integer> soldiers = new ArrayList<Integer>();
		for(int i = 0; i < 8; i++){
			soldiers.add(0);
		}
		for(int i = 0; i < indices.size(); i++){
			ArrayList<ArmyUnit> units = game.getProvinceList().get(indices.get(i)).getArmy().getUnits();
			for(int j = 0; j < units.size(); j++){
				if(units.get(j) instanceof Archer){
					soldiers.set(0, soldiers.get(0) + 1);
				}
				else if(units.get(j) instanceof Axemen){
					soldiers.set(1, soldiers.get(1) + 1);
				}
				else if(units.get(j) instanceof Cavalry){
					soldiers.set(2, soldiers.get(2) + 1);
				}
				else if(units.get(j) instanceof Mumakil){
					soldiers.set(3, soldiers.get(3) + 1);
				}
				else if(units.get(j) instanceof Nazgul){
					soldiers.set(4, soldiers.get(4) + 1);
				}
				else if(units.get(j) instanceof Spearmen){
					soldiers.set(5, soldiers.get(5) + 1);
				}
				else if(units.get(j) instanceof Swordsmen){
					soldiers.set(6, soldiers.get(6) + 1);
				}
				else if(units.get(j) instanceof WargRider){
					soldiers.set(7, soldiers.get(7) + 1);
				}
			}
		}

		return soldiers;
	}

	public ArrayList<Integer> getSoldiersInProvince(int id_h){
		int index = convertHtoM(id_h);
		ArrayList<Integer> soldiers = new ArrayList<Integer>();
		for(int i = 0; i < 8; i++){
			soldiers.add(0);
		}
		ArrayList<ArmyUnit> units = game.getProvinceList().get(index).getArmy().getUnits();
		for(int j = 0; j < units.size(); j++){
			if(units.get(j) instanceof Archer){
				soldiers.set(0, soldiers.get(0) + 1);
			}
			else if(units.get(j) instanceof Axemen){
				soldiers.set(1, soldiers.get(1) + 1);
			}
			else if(units.get(j) instanceof Cavalry){
				soldiers.set(2, soldiers.get(2) + 1);
			}
			else if(units.get(j) instanceof Mumakil){
				soldiers.set(3, soldiers.get(3) + 1);
			}
			else if(units.get(j) instanceof Nazgul){
				soldiers.set(4, soldiers.get(4) + 1);
			}
			else if(units.get(j) instanceof Spearmen){
				soldiers.set(5, soldiers.get(5) + 1);
			}
			else if(units.get(j) instanceof Swordsmen){
				soldiers.set(6, soldiers.get(6) + 1);
			}
			else if(units.get(j) instanceof WargRider){
				soldiers.set(7, soldiers.get(7) + 1);
			}
		}

		return soldiers;
	}

	public int getIncome(){
		return game.getPlayers().get(game.getCurPlayerId()).getIncome();
	}
	public int getTreasury(){
		return game.getPlayers().get(game.getCurPlayerId()).getTreasury();
	}

	public Province getProvince(int id_h){
		return game.getProvinceList().get(convertHtoM(id_h));
	}

	public Player getCurPlayer(){
		return game.getPlayers().get(game.getCurPlayerId());
	}

	public ArrayList<Integer> getFilledProvinces(){
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < game.getProvinceList().size(); i++){
			if(game.getProvinceList().get(i).getOwner() != null){
				indices.add(convertMtoH(i));
			}
		}
		return indices;
	}
}

