package lotrriskgame;

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
    
    public void executeBattle() {
        battleSystem.insertSoldierIntoBattlefield();
        battleSystem.simulateBattleLoop();
        double attackerValue = battleSystem.calculateAttackerValue();
        double defenderValue = battleSystem.calculateDefenderValue();
        
        // In setWinner(int) method, 1 corresponds attacker's win,
        // 2 defender's win, 0 tie:)
        if (attackerValue > defenderValue) {
            battleSystem.setWinner(1);
        }
        else if (attackerValue < defenderValue) {
            battleSystem.setWinner(2);
        }
        else {
            battleSystem.setWinner(0);
        }
    }
    
    public Player getWinner() {
        battleSystem.getWinner();
    }
    
}
