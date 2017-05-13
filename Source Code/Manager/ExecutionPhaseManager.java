package Manager;
/**
 * Created by Elena Cina
 * 22 April 2017
 */
import GameMemory.*;

import java.util.ArrayList;
import java.util.Random;

public class ExecutionPhaseManager extends Manager{

	BattleManager battleManager;
	Order order;
	public ExecutionPhaseManager(Game game){
		super(game);
	}
	public boolean carryOrder (Order order, ArrayList<Integer> execChanges){
		// If the order is valid
		if(order.getPlayer() == order.getProvinceFrom().getOwner()){
			//check what kind of order it is transfer or attack order
			//if it is transfer order
			if (order instanceof TransferOrder)
			{
				for(int i = order.getArmy().getArmySize() - 1; i >= 0; i++){
					order.getProvinceTo().getArmy().addArmyUnit(order.getArmy().removeArmyUnit());
				}
			}
			//if is AttackOrder
			if (order instanceof AttackOrder)
			{
				battleManager.executeBattle(order.getPlayer(), order.getProvinceTo().getOwner(),
						order.getArmy(), order.getProvinceTo().getArmy()); //call executeBattle form battle Manager class
				Player winner = battleManager.getWinner(); //get the winner
				//check if attacker won the battle by comparing its id with winners id
				if (winner.getId() == order.getProvinceFrom().getOwner().getId())
				{
					//the attacker gets the province of the defender
					//set the owner of the provinceTo to the owner of province from
					order.getProvinceTo().setOwner(order.getProvinceFrom().getOwner());
					execChanges.add(order.getProvinceTo().getId());
				}
			}

			return true;
		}
		else{
			return false;
		}
	}

	public void executeOrderList(ArrayList<Integer> execChanges)
	{
		Random rand = new Random();
		//execute all orders, BUT IN RANDOM ORDER
		while(game.getOrderList().getOrders().size() != 0){
			int index;
			index = rand.nextInt(game.getOrderList().getOrders().size());
			carryOrder(getOrderList().getOrders().get(index), execChanges);
		}

	}
}
