/**
 * Created by Elena Cina
 * 22 April 2017
 */

public class ExecutionPhaseManager {

	BattleManager battleManager;
	Player winner; 
	Game game;
	
	public boolean carryOrder (Order order){
		//check what kind of order it is transfer or attack order
		if (order instanceof TransferOrder){
			int a= order.getProvinceFrom().getArmy().getArmySize() - order.getNumberOfSolders();
			int b = order.getProvinceTo().getArmy().getArmySize() + order.getNumberOfSolders();
			order.getProvinceFrom().getArmy().setArmySize(a);
			order.getProvinceTo().getArmy().setArmySize(b);
		}
		if (order instanceof AttackOrder){
			battleManager.executeBattle();
			winner = battleManager.getWinner();
			if (winner.getId() == game.getCurPlayerId())//means that attacker won
			{
				//the loser province loses a unit
				for (int i = 0; i< order.getNumOfSolders()-1; i++){
					if( order.getArmy(i).getVulnerability< order.getArmy(i+1).getVulnerability){
						//remove the unit which has the highest vulnerability 
						order.getArmy() = ArrayUtils.removeElement(order.getArmy(), getArmy(i+1));
						int numUnits = order.getProvinceTo().getArmy().getArmySize() -1;
					}		
				}
				//check if there is left any other unit in the defender province
				if (numUnits == 0){
					//the attacker gets the province of the defender
				}
			}
	}
}

public void executeOrderList(){
		//execute all orders
		for (int i = 0; i< game.getOrderList().length; i++){
			carryOrder(getOrderList()[i]);
		}	
	}
}
