package at.buylando;

import java.util.ArrayList;

public class OurCustomers {
    private ArrayList<Customer> customerList = new ArrayList<>();

    public OurCustomers(){

    }

    public OurCustomers(ArrayList<Customer> customers){
        this.customerList = customers;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }


    public void setCustomer(Customer customer) {
        this.customerList.add(customer);
    }

    public Customer getCustomer(String firstname, String lastname, String gender){
        for(Customer c : this.customerList){
            if(c.getFirstname().equals(firstname) && c.getLastname().equals(lastname) && c.getGender().equals(gender)){
                return c;
            }
        }

        return null;
    }

    public boolean isCustomerExisting(String firstname, String lastname, String gender){

        for(Customer c : this.customerList){
            if(c.getFirstname().equals(firstname) && c.getLastname().equals(lastname) && c.getGender().equals(gender)){
                return true;
            }
        }

        return false;
    }


}
