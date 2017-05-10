package GameMemory;
/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Archer extends ArmyUnit{

    public Archer(){
        super();
        this.cost = 1;
        this.attackCount = 1;
        this.defenseCount = 1;
        this.attack = 3;
        this.defense = 7;
        this.attackModifier = 0;
        this.defenseModifier = 0;
        this.vulnerability = 1;
    }
}
