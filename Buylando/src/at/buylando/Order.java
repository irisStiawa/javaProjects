package at.buylando;

import java.util.ArrayList;

public class Order {
    public static int nextOrderID = 1;
    private int orderID;
    private Customer customer;
    private String paymentState;
    private Date orderDate;
    private Article article;

    public Order(Customer customer, String paymentState, Date orderDate, Article article) {
        this.orderID = nextOrderID++;
        this.customer = customer;
        this.paymentState = paymentState;
        this.orderDate = orderDate;
        this.article = article;
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String printAbleOrder(){

        return orderID + " CustumerID: "+ customer.getCustomerID() + " " + customer.getFirstname() + " " + customer.getLastname() + ", bestellt am: " + orderDate.toString() + "\n\t" + article.printAbleArticle();
    }
}
