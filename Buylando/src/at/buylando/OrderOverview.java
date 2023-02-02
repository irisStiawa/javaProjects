package at.buylando;

import at.buylando.matcher.MatchLastOrders;

import java.io.File;
import java.util.ArrayList;

public class OrderOverview {
    private File orderFile= new File("."+ File.separator +"orders.txt");
    private ArrayList<Order> ordersList = new ArrayList<>();



    public OrderOverview() {
    }

    public File getOrderFile() {
        return orderFile;
    }

    public void setOrderFile(File orderFile) {
        this.orderFile = orderFile;
    }

    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(ArrayList<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public void setOrder(Order order){
        this.ordersList.add(order);
    }

    public ArrayList<Order> ordersFromYear(String year){
        ArrayList<Order> ordersList = new ArrayList<>();

        for(Order o : this.ordersList){
            if(o.getOrderDate().getYear().equals(year)){
                ordersList.add(o);
            }
        }
        return ordersList;
    }

    public ArrayList<Order> ordersLastTwoWeeks() {
        ArrayList<Order> list = new ArrayList<>();
        MatchLastOrders matcher = new MatchLastOrders();

        for(Order o : this.ordersList){
            if(matcher.match(o)){
                list.add(o);
            }
        }
    return list;
    }

    public float sumOfDressPrices() {
       float sum = 0;

        for(Order o : this.ordersList){
            if(o.getArticle().getTyp().equals("Kleidung")){
               sum += o.getArticle().getPrice();
            }
        }
        return sum;
    }


    public int procentOfNike() {
        float completeSum = 0;
        float nikeSum = 0;

        for(Order o : this.ordersList){
            completeSum += o.getArticle().getPrice();
        }

        for(Order o : this.ordersList){
            if (o.getArticle().getBrand().equals("Nike")) {
                nikeSum += o.getArticle().getPrice();
            }
        }

       return (int) ((nikeSum*100)/completeSum);
    }
}
