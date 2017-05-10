package Manager;
/**
 * Created by Elena Cina
 * 22 April 2017
 */
import GameMemory.*;
public class MobilityPhaseManager extends Manager{

	public MobilityPhaseManager(Game game){
		super(game);
	}

	public void addOrder(Order order)//gets the input from GUI
	{
		game.getOrderList().addOrder(order);
	}
}


