/**
 * Created by Elena Cina
 * 22 April 2017
 */

public class ExecutionPhaseManager extends Order{

	BattleManager battleManager;
	Player winner; 
	Game game;
	Order order;
	public boolean carryOrder (Order order){
		//check what kind of order it is transfer or attack order
		//if it is transfer order
		if (order instanceof TransferOrder)
		{ 
			int a= order.getProvinceFrom().getArmy().getArmySize() - order.getNumberOfSolders(); //substract the number of solders sent from current armynumber
			int b = order.getProvinceTo().getArmy().getArmySize() + order.getNumberOfSolders();//add that number of solders to the army of the province where they are going
			order.getProvinceFrom().getArmy().setArmySize(a);
			order.getProvinceTo().getArmy().setArmySize(b);
		}
		//if is AttackOrder
		if (order instanceof AttackOrder)
		{
			battleManager.executeBattle(); //call executeBattle form battle Manager class
			winner = battleManager.getWinner(); //get the winner
			//check if attacker won the battle by comparing its id with winners id
			if (winner.getId() == order.getProvinceFrom().getOwner().getOwnerId())
			{
				//the loser province loses a unit
				for (int i = 0; i< order.getNumOfSolders()-1; i++)
				{
					//compare vulnerability of the units
					if( order.getArmy(i).getVulnerability< order.getArmy(i+1).getVulnerability)
					{
						//remove the unit which has the highest vulnerability 
						order.getArmy() = ArrayUtils.removeElement(order.getArmy(), getArmy(i+1));
						int numUnits = order.getProvinceTo().getArmy().getArmySize() -1;
					}		
				}
				//check if there is left any other unit in the defender province
				if (numUnits == 0)//it means no other unit in this province
				{
					//the attacker gets the province of the defender
					//set the owner of the provinceTo to the owner of province from
					order.provinceTo().setOwner(order.provinceFrom.getOwner());
				}
			}
		}
	}

	public void executeOrderList()
	{
		//execute all orders, BUT IN RANDOM ORDER
		for (int i = 0; i< game.getOrderList().length; i++)
		{
			carryOrder(getOrderList()[i]);
		}	
	}
}
