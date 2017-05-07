import java.util.ArrayList;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Faction {
    static int factionCount = 0;
    private int id;
    private String factionType;
    private ArrayList<String> availableUnitTypes;

    public Faction(String factionType){
        this.id = factionCount++;
        this.factionType = factionType;
        availableUnitTypes = new ArrayList<String>();
        setAvailableUnits();
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
        if(factionType.equals("Rohan")){
            availableUnitTypes.add("Archer");
            availableUnitTypes.add("Cavalry");
            availableUnitTypes.add("Spearmen");
            availableUnitTypes.add("Swordsmen");
        }
        if(factionType.equals("Gondor")){
            availableUnitTypes.add("Archer");
            availableUnitTypes.add("Cavalry");
            availableUnitTypes.add("Spearmen");
            availableUnitTypes.add("Swordsmen");
        }
        if(factionType.equals("Isengard")){
            availableUnitTypes.add("Archer");
            availableUnitTypes.add("WargRider");
            availableUnitTypes.add("Spearmen");
            availableUnitTypes.add("Swordsmen");
        }
        if(factionType.equals("Harad")){
            availableUnitTypes.add("Archer");
            availableUnitTypes.add("Mumakil");
            availableUnitTypes.add("Spearmen");
            availableUnitTypes.add("Swordsmen");
        }
        if(factionType.equals("Mordor")){
            availableUnitTypes.add("Archer");
            availableUnitTypes.add("Nazgul");
            availableUnitTypes.add("Spearmen");
            availableUnitTypes.add("Swordsmen");
        }
        if(factionType.equals("Dwarves")){
            availableUnitTypes.add("Archer");
            availableUnitTypes.add("Axemen");
            availableUnitTypes.add("Spearmen");
        }
        if(factionType.equals("Elves")){
            availableUnitTypes.add("Archer");
            availableUnitTypes.add("Cavalry");
            availableUnitTypes.add("Spearmen");
            availableUnitTypes.add("Swordsmen");
        }
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
