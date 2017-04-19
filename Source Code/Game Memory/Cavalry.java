/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Cavalry extends ArmyUnit {

    public Cavalry(){
        super();
        this.cost = 2;
        this.attackCount = 2;
        this.defenseCount = 2;
        this.attack = 5;
        this.defense = 4;
        this.attackModifier = 0;
        this.defenseModifier = 0;
        this.vulnerability = 0.7;
    }
}
