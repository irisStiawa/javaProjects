package com.bank;

public abstract class Konto{
    private int kontoNumber;
    private double kontoCount;
    private Customer customer;

    public Konto(int kontoNumber, double kontoCount, Customer customer) {
        this.kontoNumber = kontoNumber;
        this.kontoCount = kontoCount;
        this.customer = customer;
    }

    public abstract String deposit(int sum);

    public abstract String payOff(int sum);


    public double getKontoCount() {
        return kontoCount;
    }

    protected void setKontoCount(double kontoCount) {
        this.kontoCount = kontoCount;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



}
