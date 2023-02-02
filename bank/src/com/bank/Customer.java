package com.bank;

import java.util.ArrayList;


public class Customer extends Person{
    private int customerID;
    private ArrayList<Konto> kontoList = new ArrayList<Konto>();

    public Customer(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public Customer(String firstname, String lastname, Date date) {
        super(firstname, lastname, date);
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getKontoList() {

        String myKontos="";

        for(Konto konto : this.kontoList){

            if(konto.getClass().getSimpleName().equals("GiroKonto")){

                myKontos += "Kredit: " + konto.getKontoCount() + "€\n";
            } else {

                myKontos +=  "Giro: " + konto.getKontoCount() + "€\n";
            }
        }
        return myKontos;

    }

    public void setKonto(Konto konto){
        this.kontoList.add(konto);
    }


    public double getCapital(){
        double capital = 0;
        for(Konto konto : this.kontoList){
            capital += konto.getKontoCount();

        }
        return capital;
    }

    public ArrayList<Konto> getKontos(){
        return this.kontoList;
    }



}
