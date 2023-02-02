package com.bank;

public class KreditCard extends Konto{
    private double overdaft;



    public KreditCard(int kontoNumber, double kontoCount, Customer customer, double overdaft) {
        super(kontoNumber, kontoCount, customer);
        this.overdaft = overdaft;

    }

    public  String deposit(int sum){
        this.setKontoCount(this.getKontoCount() + sum);
        return "Einzahlung erfolgreich!!" + " Akuteller Stand: " + this.getKontoCount();
    };

    public  String payOff(int sum){
        if(this.overdaft > (this.getKontoCount()-sum)){

           return "Überziehungsrahmen darf nicht überschritten werden!!! Aktueller Stand: " + this.getKontoCount() + " Überziehungsrahmen: " + this.overdaft;
        } else {
            this.setKontoCount(this.getKontoCount() - sum);
            return "Abbuchung erfolgreich!! Aktueller Stand: " + this.getKontoCount() ;
        }
    };


}
