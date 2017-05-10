package GameMemory;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class WargRider extends ArmyUnit {

    public WargRider(){
        super();
        this.cost = 2;
        this.attackCount = 3;
        this.defenseCount = 2;
        this.attack = 3;
        this.defense = 4;
        this.attackModifier = 1;
        this.defenseModifier = 0;
        this.vulnerability = 0.8;
    }
}
