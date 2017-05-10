package GameMemory;
/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Bonus {
    private int incomeBonus;
    // TODO Implement other types of bonuses

    public Bonus(){
        incomeBonus = 0;
    }

    public Bonus(int incomeBonus){
        this.incomeBonus = incomeBonus;
    }

    public int getIncomeBonus() {
        return incomeBonus;
    }

    public void setIncomeBonus(int incomeBonus) {
        this.incomeBonus = incomeBonus;
    }
}
