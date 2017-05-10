package Manager;
import GameMemory.*;

/**
 *
 * @author Doga Zeynep Germen
 */
public class BattleManager extends Manager {
    
    private BattleSystem battleSystem;
    
    public BattleManager(Game game) {
        super(game);
        battleSystem = new BattleSystem();
        // player = new Player();
    }
    
    public void executeBattle(Player attacker, Player defender, Army attackerArmy, Army defenderArmy) {
        battleSystem.setAttacker(attacker);
        battleSystem.setDefender(defender);
        battleSystem.setAttackerArmy(attackerArmy);
        battleSystem.setDefenderArmy(defenderArmy);
        battleSystem.simulateBattleLoop();
    }
    
    public Player getWinner() {
        return battleSystem.getWinner();
    }
    
}
