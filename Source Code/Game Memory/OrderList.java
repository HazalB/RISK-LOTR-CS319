import java.util.ArrayList;

/**
 * Created by Mirac Vuslat Basaran on 18-Apr-17.
 */
public class OrderList {
    private ArrayList<Order> orders;

    public OrderList(){
        orders = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public Order removeOrder(){
        return orders.remove(orders.size() - 1);
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
