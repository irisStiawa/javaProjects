package com.bank;

public class GiroKonto extends Konto{


    public GiroKonto(int kontoNumber, double kontoCount, Customer customer) {
        super(kontoNumber, kontoCount, customer);

    }


    public  String deposit(int sum){
        this.setKontoCount(this.getKontoCount() + sum);

        return "Einzahlung erfolgreich!!" + " Akuteller Stand: " + this.getKontoCount();

    };

    public  String payOff(int sum){
        if(this.getKontoCount()>sum){
            this.setKontoCount(this.getKontoCount() - sum);

            return "Abbuchung erfolgreich!!" + " Akuteller Stand: " + this.getKontoCount();
        } else {

            return "Konto darf nicht überzogen werden!!!" + " Akuteller Stand: " + this.getKontoCount();
        }

    };


}
