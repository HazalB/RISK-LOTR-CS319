import java.util.ArrayList;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class Game {
    private int numPlayers, curPlayerId, turnNo, curPhase;
    private ArrayList<Player> players;
    private ArrayList<Integer> loserPlayerIds;
    private ArrayList<Province> provinceList;
    private OrderList orderList;
    private ArrayList<Area> areaList;

    public ArrayList<Area> getAreaList() {
        return areaList;
    }

    public ArrayList<Integer> getLoserPlayerIds() {
        return loserPlayerIds;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Province> getProvinceList() {
        return provinceList;
    }

    public int getCurPhase() {
        return curPhase;
    }

    public int getCurPlayerId() {
        return curPlayerId;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public int getTurnNo() {
        return turnNo;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setAreaList(ArrayList<Area> areaList) {
        this.areaList = areaList;
    }

    public void setCurPhase(int curPhase) {
        this.curPhase = curPhase;
    }

    public void setCurPlayerId(int curPlayerId) {
        this.curPlayerId = curPlayerId;
    }

    public void setLoserPlayerIds(ArrayList<Integer> loserPlayerIds) {
        this.loserPlayerIds = loserPlayerIds;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setProvinceList(ArrayList<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public void setTurnNo(int turnNo) {
        this.turnNo = turnNo;
    }
}
