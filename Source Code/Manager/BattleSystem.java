package Manager;
import java.util.ArrayList;
import java.util.Random;
import GameMemory.*;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class BattleSystem {
    // TODO Implement methods
    private Player attacker, defender;
    private Army defenderArmy, attackerArmy;
    private double attackerTacticalAdvantage, defenderTacticalAdvantage;
    private Player winner;
    private ArrayList<ArmyUnit> battlefieldAttacker;
    private ArrayList<ArmyUnit> battlefieldDefender;
    private int bfAttackerSize, bfDefenderSize;

    public BattleSystem(){

    }

    public void insertSoldiersIntoBattleField(){
        if(bfAttackerSize < 5){
            for(int i = 0; i < attackerArmy.getArmySize(); i++){

            }
        }

    }

    public void looseSoldier(Player loser){
        Random rand = new Random();
        int destroy = -1;
        int minVulnerabilityIndex = 0;
        double minVulnerability = battlefieldAttacker.get(0).getVulnerability();
        if(loser == attacker){
            for(int i = 0;i < bfAttackerSize && destroy == -1; i++){
                if(battlefieldAttacker.get(i).getVulnerability() < minVulnerability){
                    minVulnerability = battlefieldAttacker.get(i).getVulnerability();
                    minVulnerabilityIndex = i;
                }
                if(rand.nextDouble() > battlefieldAttacker.get(i).getVulnerability()){
                    //Destroy i'th soldier
                    destroy = i;
                }
            }

            if(destroy == -1){
                destroy = minVulnerabilityIndex;
            }
            battlefieldAttacker.remove(destroy);
        }
        else{
            for(int i = 0;i < bfDefenderSize && destroy == -1; i++){
                if(battlefieldDefender.get(i).getVulnerability() < minVulnerability){
                    minVulnerability = battlefieldDefender.get(i).getVulnerability();
                    minVulnerabilityIndex = i;
                }
                if(rand.nextDouble() > battlefieldDefender.get(i).getVulnerability()){
                    //Destroy i'th soldier
                    destroy = i;
                }
            }

            if(destroy == -1){
                destroy = minVulnerabilityIndex;
            }
            battlefieldDefender.remove(destroy);
        }
    }

    public void simulateBattleLoop(){
        /*
        combat_width: 5
        1) Each side of the battle places less x number of armies on the battle, x <= combat_width.
        2) Each side rolls seperate dice for the armies, then sums them.
        3) Multiply the sum by tactical_advantage, which is calculated by the composition of the armies vs. composition of the enemy.
        4) The side who has the lesser sum loses.
        5) The loser looses one if its armies, it is a weighted random.
        6) If the loser has a reserve, put that reserve back on the battlefield.
        7) Repeat 1-6 until one side has 0 armies left.
        */

        // Check if a side has no soldiers
        if(attackerArmy.getArmySize() == 0 && bfAttackerSize == 0){
            winner = defender;
            for(int i = 0; i < bfDefenderSize; i++){
                defenderArmy.getUnits().add(battlefieldDefender.get(i));
            }
        }
        else if(defenderArmy.getArmySize() == 0 && bfDefenderSize == 0){
            winner = attacker;
            for(int i = 0; i < bfAttackerSize; i++){
                defenderArmy.getUnits().add(battlefieldDefender.get(i));
            }
        }
        else {
            // 1
            insertSoldiersIntoBattleField();

            // 2 - 3
            calculateTacticalAdvantages();
            double attackerValue = calculateAttackerValue();
            double defenderValue = calculateDefenderValue();

            // 4
            Player loser;
            // Attacker wins this round
            if (attackerValue > defenderValue) {
                loser = defender;
            }
            // Defender wins this round
            else {
                loser = attacker;
            }

            // 5
            looseSoldier(loser);

            // 6-7
            simulateBattleLoop();
        }
    }

    public double calculateAttackerValue(){
        double value = 0;
        for(int i = 0; i < bfAttackerSize; i++){
            int unitAttack = 0;
            Random rand = new Random();
            for(int j = 0; j < battlefieldAttacker.get(i).getAttackCount(); j++)
            {
                unitAttack += rand.nextInt(battlefieldAttacker.get(i).getAttack()) + 1;
            }
            unitAttack += battlefieldAttacker.get(i).getAttackModifier();
            value += unitAttack;
        }
        value *= attackerTacticalAdvantage;
        return value;
    }

    public double calculateDefenderValue(){
        double value = 0;
        for(int i = 0; i < bfDefenderSize; i++){
            int unitAttack = 0;
            Random rand = new Random();
            for(int j = 0; j < battlefieldDefender.get(i).getAttackCount(); j++)
            {
                unitAttack += rand.nextInt(battlefieldDefender.get(i).getAttack()) + 1;
            }
            unitAttack += battlefieldDefender.get(i).getAttackModifier();
            value += unitAttack;
        }
        value *= defenderTacticalAdvantage;
        return value;
    }


    public void calculateTacticalAdvantages(){
        // Calculates tactical advantage for both defender and attacker
        defenderTacticalAdvantage = 1;
        attackerTacticalAdvantage = 1;

        // 1) No Swr-Spr-Axe Penalty: -20%. Incurred when you have no Inf, Axe or Spr units.
        boolean no_swe_spr_axe = true;
        for(int i = 0; i < bfAttackerSize; i++){
            if(battlefieldAttacker.get(i) instanceof Swordsmen ||
                    battlefieldAttacker.get(i) instanceof Spearmen ||
                    battlefieldAttacker.get(i) instanceof Axemen){
                no_swe_spr_axe = false;
            }
        }
        if(no_swe_spr_axe){
            attackerTacticalAdvantage = attackerTacticalAdvantage - 0.2;
        }
        no_swe_spr_axe = true;
        for(int i = 0; i < bfDefenderSize; i++){
            if(battlefieldDefender.get(i) instanceof Swordsmen ||
                    battlefieldDefender.get(i) instanceof Spearmen ||
                    battlefieldDefender.get(i) instanceof Axemen){
                no_swe_spr_axe = false;
            }
        }
        if(no_swe_spr_axe){
            defenderTacticalAdvantage = defenderTacticalAdvantage - 0.2;
        }

        // 2) Missile Bonus: +5%. Incurred when you have at least one archer.
        boolean archer_bonus = false;
        for(int i = 0; i < bfAttackerSize; i++){
            if(battlefieldAttacker.get(i) instanceof Archer){
                archer_bonus = true;
            }
        }
        if(archer_bonus){
            attackerTacticalAdvantage = attackerTacticalAdvantage + 0.05;
        }
        archer_bonus = false;
        for(int i = 0; i < bfDefenderSize; i++){
            if(battlefieldDefender.get(i) instanceof Archer){
                archer_bonus = true;
            }
        }
        if(archer_bonus){
            defenderTacticalAdvantage = defenderTacticalAdvantage - 0.2;
        }

        // 3) Cav vs. Swo-Axe-Arch: +%15
        boolean attacker_has_cav = false;
        boolean attacker_has_inf = false;
        boolean defender_has_cav = false;
        boolean defender_has_inf = false;
        for(int i = 0; i < bfAttackerSize; i++){
            if(battlefieldAttacker.get(i) instanceof Cavalry ||
                    battlefieldAttacker.get(i) instanceof WargRider){
                attacker_has_cav = true;
            }
            if(battlefieldAttacker.get(i) instanceof Swordsmen ||
                    battlefieldAttacker.get(i) instanceof Spearmen ||
                    battlefieldAttacker.get(i) instanceof Axemen){
                attacker_has_inf = true;
            }
        }

        for(int i = 0; i < bfDefenderSize; i++){
            if(battlefieldDefender.get(i) instanceof Cavalry ||
                    battlefieldDefender.get(i) instanceof WargRider){
                defender_has_cav = true;
            }
            if(battlefieldDefender.get(i) instanceof Swordsmen ||
                    battlefieldDefender.get(i) instanceof Spearmen ||
                    battlefieldDefender.get(i) instanceof Axemen){
                defender_has_inf = true;
            }
        }

        if(attacker_has_cav && defender_has_inf){
            attackerTacticalAdvantage = attackerTacticalAdvantage + 0.15;
        }
        if(defender_has_cav && attacker_has_inf){
            defenderTacticalAdvantage = defenderTacticalAdvantage + 0.15;
        }

        // 4) Spr vs. Cav: +15%
        boolean attacker_has_spr = false;
        boolean defender_has_spr = false;
        for(int i = 0; i < bfAttackerSize; i++){
            if(battlefieldAttacker.get(i) instanceof Spearmen){
                attacker_has_spr = true;
            }
        }
        for(int i = 0; i < bfDefenderSize; i++){
            if(battlefieldDefender.get(i) instanceof Spearmen){
                defender_has_spr = true;
            }
        }

        if(attacker_has_cav && defender_has_spr){
            defenderTacticalAdvantage = defenderTacticalAdvantage + 0.15;
        }
        if(defender_has_cav && attacker_has_spr){
            attackerTacticalAdvantage = attackerTacticalAdvantage + 0.15;
        }

        // 5) Nazgul Bonus: +20%
        boolean attacker_has_nzl = false;
        boolean defender_has_nzl = false;
        for(int i = 0; i < bfAttackerSize; i++){
            if(battlefieldAttacker.get(i) instanceof Nazgul){
                attacker_has_nzl = true;
            }
        }
        for(int i = 0; i < bfDefenderSize; i++){
            if(battlefieldDefender.get(i) instanceof Nazgul){
                defender_has_nzl = true;
            }
        }

        if(defender_has_nzl){
            defenderTacticalAdvantage = defenderTacticalAdvantage + 0.2;
        }
        if(attacker_has_nzl){
            attackerTacticalAdvantage = attackerTacticalAdvantage + 0.2;
        }

        // 6) Mumakil Bonus: +10%
        boolean attacker_has_mml = false;
        boolean defender_has_mml = false;
        for(int i = 0; i < bfAttackerSize; i++){
            if(battlefieldAttacker.get(i) instanceof Mumakil){
                attacker_has_mml = true;
            }
        }
        for(int i = 0; i < bfDefenderSize; i++){
            if(battlefieldDefender.get(i) instanceof Mumakil){
                defender_has_mml = true;
            }
        }

        if(defender_has_mml){
            defenderTacticalAdvantage = defenderTacticalAdvantage + 0.2;
        }
        if(attacker_has_mml){
            attackerTacticalAdvantage = attackerTacticalAdvantage + 0.2;
        }

        // 7) No Cav Bonus: +10%
        if(defender.getFaction().getFactionType().equals("Rohan") && !defender_has_cav){
            defenderTacticalAdvantage = defenderTacticalAdvantage - 0.1;
        }
        if(attacker.getFaction().getFactionType().equals("Rohan") && !attacker_has_cav){
            attackerTacticalAdvantage = attackerTacticalAdvantage - 0.1;
        }

        // 6) Elven Archer Bonus: +5%
        boolean attacker_has_arc = false;
        boolean defender_has_arc = false;
        for(int i = 0; i < bfAttackerSize; i++){
            if(battlefieldAttacker.get(i) instanceof Archer){
                attacker_has_arc = true;
            }
        }
        for(int i = 0; i < defenderArmy.getArmySize(); i++){
            if(battlefieldDefender.get(i) instanceof Archer){
                defender_has_arc = true;
            }
        }

        if(defender.getFaction().getFactionType().equals("Elves") && defender_has_arc){
            defenderTacticalAdvantage = defenderTacticalAdvantage + 0.05;
        }
        if(defender.getFaction().getFactionType().equals("Elves") && attacker_has_arc){
            attackerTacticalAdvantage = attackerTacticalAdvantage + 0.05;
        }

    }

    public Army getAttackerArmy() {
        return attackerArmy;
    }

    public Army getDefenderArmy() {
        return defenderArmy;
    }

    public ArrayList<ArmyUnit> getBattlefieldAttacker() {
        return battlefieldAttacker;
    }

    public ArrayList<ArmyUnit> getBattlefieldDefender() {
        return battlefieldDefender;
    }

    public double getAttackerTacticalAdvantage() {
        return attackerTacticalAdvantage;
    }

    public double getDefenderTacticalAdvantage() {
        return defenderTacticalAdvantage;
    }

    public Player getAttacker() {
        return attacker;
    }

    public Player getDefender() {
        return defender;
    }

    public Player getWinner() {
        return winner;
    }

    public void setAttacker(Player attacker) {
        this.attacker = attacker;
    }

    public void setAttackerArmy(Army attackerArmy) {
        this.attackerArmy = attackerArmy;
    }

    public void setAttackerTacticalAdvantage(double attackerTacticalAdvantage) {
        this.attackerTacticalAdvantage = attackerTacticalAdvantage;
    }

    public void setBattlefieldAttacker(ArrayList<ArmyUnit> battlefieldAttacker) {
        this.battlefieldAttacker = battlefieldAttacker;
    }

    public void setDefender(Player defender) {
        this.defender = defender;
    }

    public void setDefenderArmy(Army defenderArmy) {
        this.defenderArmy = defenderArmy;
    }

    public void setDefenderTacticalAdvantage(double defenderTacticalAdvantage) {
        this.defenderTacticalAdvantage = defenderTacticalAdvantage;
    }

    public void setBattlefieldDefender(ArrayList<ArmyUnit> getBattlefieldDefender) {
        this.battlefieldDefender = getBattlefieldDefender;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
