package at.buylando;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class BuyLando {
    OurCustomers customers = new OurCustomers();
    OrderOverview buyLandoOrders = new OrderOverview();
    OurArticles articles = new OurArticles();


    public BuyLando() {
    }

    public void createOrdersByFile(){
        String line;

        try(var in = new BufferedReader(new FileReader(buyLandoOrders.getOrderFile()))){

            while((line = in.readLine()) != null){
                String[] splitLine = line.split(";");
                String[] splitDate = splitLine[8].split("\\.");

                String price = splitLine[3].replace(",", ".");
                String rating = splitLine[4].replace(",", ".");
                Article article;
                Customer customer;
                Date date = new Date(splitDate[0], splitDate[1], splitDate[2]);




                if(articles.isArticleExisting(splitLine[2], splitLine[1], splitLine[0], Float.parseFloat(price), Float.parseFloat(rating))){
                    article = articles.getArticle(splitLine[2], splitLine[1], splitLine[0], Float.parseFloat(price), Float.parseFloat(rating));
                } else{
                    article = new Article(splitLine[2], splitLine[1], splitLine[0], Float.parseFloat(price), Float.parseFloat(rating));
                    articles.setArticle(article);
                }



                if(customers.isCustomerExisting(splitLine[5], splitLine[6], splitLine[7])) {
                    customer = customers.getCustomer(splitLine[5], splitLine[6], splitLine[7]);
                } else{
                    customer = new Customer(splitLine[5], splitLine[6], splitLine[7]);
                    customers.setCustomer(customer);
                }

                Order order = new Order(customer, splitLine[9], date, article);
                this.buyLandoOrders.setOrder(order);

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void printAllOrders(){
        for(Order o : this.buyLandoOrders.getOrdersList()){
            System.out.println(o.printAbleOrder() + "\n");

        }
    }

    public void printOrdersByFirstName(String name){
        System.out.println("Orders by " + name + ":");
        for(Order o : this.buyLandoOrders.getOrdersList()){
            if(o.getCustomer().getFirstname().equals(name)){
                System.out.println(o.printAbleOrder() + "\n");
            }

        }
    }

    public void printPopularArticles(){
        ArrayList<Article> list = this.articles.popularArticles();
        System.out.println("popular Articles");
        for(Article a : list){
            System.out.println(a.printAbleArticle());
        }
        System.out.println("\n");
    }

    public void printOrdersFromYear(String year){
        System.out.println("Articles of " + year + ":");
        for(Order o : this.buyLandoOrders.ordersFromYear(year)){
            System.out.println(o.printAbleOrder());
        }
        System.out.println("\n");
    }

    public void printMostExpensiveAtricles(){
        System.out.println("Most Expensice Articles:");
        for(Article o : this.articles.mostExpensiveArticles()){
            System.out.println(o.printAbleArticle());
        }
        System.out.println("\n");
    }

    public void printOrdersLastTwoWeeks(){
        System.out.println("Orders Last Two Weeks:");
        for(Order o : this.buyLandoOrders.ordersLastTwoWeeks()){
            System.out.println(o.printAbleOrder());
        }
        System.out.println("\n");

    }

    public void printSumOfDressPrices() {
        System.out.println("Dress Prices: ");
        System.out.println(this.buyLandoOrders.sumOfDressPrices() + " €");
        System.out.println("\n");
    }

    public void printProcentOfNike() {
        System.out.println("Procent of Nike: ");
        System.out.println(this.buyLandoOrders.procentOfNike() + "%");
        System.out.println("\n");
    }

    public void doAll(){
        createOrdersByFile();
        printAllOrders();
        printOrdersByFirstName("Martin");
        printPopularArticles();
        printOrdersFromYear("2022");
        printMostExpensiveAtricles();
        printOrdersLastTwoWeeks();
        printSumOfDressPrices();
        printProcentOfNike();



    }

}
