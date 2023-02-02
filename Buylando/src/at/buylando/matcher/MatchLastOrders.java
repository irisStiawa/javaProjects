package at.buylando.matcher;


import at.buylando.Date;
import at.buylando.Order;


public class MatchLastOrders implements Matcher<Order>{
    
        private int dateToMatch;

        public MatchLastOrders() {
            java.util.Date date = java.util.Calendar.getInstance().getTime();
            long ddiff = 14 * 24 * 60 * 60 * 1000;
            long twoWeeksAgo = date.getTime() - ddiff;
            date = new java.util.Date(twoWeeksAgo);
            String[] dateFormat= date.toLocaleString().split("\\.");
            this.dateToMatch = Integer.parseInt(dateFormat[2].substring(0,4))* 10000 +  Integer.parseInt(dateFormat[1])* 100 +  Integer.parseInt(dateFormat[0]);
        }

        @Override
        public boolean match(Order o) {
            Date orderTime = o.getOrderDate();

            return  (Integer.parseInt(orderTime.getYear())*10000 + Integer.parseInt(orderTime.getMonth())*100 + Integer.parseInt(orderTime.getDay())) > dateToMatch;
        }

}
