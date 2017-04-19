import java.util.ArrayList;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Faction {
    // TODO Setters
    static int factionCount = 0;
    private int id;
    private String factionType;
    private ArrayList<String> availableUnitTypes;

    public Faction(String factionType){
        this.id = factionCount++;
        this.factionType = factionType;
        availableUnitTypes = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getAvailableUnitTypes() {
        return availableUnitTypes;
    }

    public static int getFactionCount() {
        return factionCount;
    }

    public String getFactionType() {
        return factionType;
    }

    private void setAvailableUnits(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailableUnitTypes(ArrayList<String> availableUnitTypes) {
        this.availableUnitTypes = availableUnitTypes;
    }

    public static void setFactionCount(int factionCount) {
        Faction.factionCount = factionCount;
    }

    public void setFactionType(String factionType) {
        this.factionType = factionType;
    }
}
