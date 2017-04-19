/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public abstract class ArmyUnit {
    static int unitCount = 0;
    protected int id;
    protected int cost, attack, defense, attackModifier, defenseModifier, attackCount, defenseCount;
    protected double vulnerability;

    public ArmyUnit(){
        this.id = unitCount++;
    }

    public int getId() {
        return id;
    }

    public double getVulnerability() {
        return vulnerability;
    }

    public int getAttack() {
        return attack;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public int getCost() {
        return cost;
    }

    public int getDefense() {
        return defense;
    }

    public int getDefenseModifier() {
        return defenseModifier;
    }

    public static int getUnitCount() {
        return unitCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setAttackModifier(int attackModifier) {
        this.attackModifier = attackModifier;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDefenseModifier(int defenseModifier) {
        this.defenseModifier = defenseModifier;
    }

    public static void setUnitCount(int unitCount) {
        ArmyUnit.unitCount = unitCount;
    }

    public void setVulnerability(double vulnerability) {
        this.vulnerability = vulnerability;
    }
}
