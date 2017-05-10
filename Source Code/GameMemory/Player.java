package GameMemory;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Player {
    private String username;
    private int id, treasury, income;
    private Faction faction;
    static int playerCount = 0;

    public Player(String username, String factionName){
        this.username = username;
        this.id = playerCount++;
        this.treasury = 0;
        this.income = 0;
        this.faction = new Faction(factionName);
    }

    public String getUsername(){
        return username;
    }

    public Faction getFaction() {
        return faction;
    }

    public int getId() {
        return id;
    }

    public int getIncome() {
        return income;
    }

    public int getTreasury() {
        return treasury;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public static void setPlayerCount(int playerCount) {
        Player.playerCount = playerCount;
    }

    public void setTreasury(int treasury) {
        this.treasury = treasury;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
