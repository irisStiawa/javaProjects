package com.bank;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Customer iris = new Customer("Iris", "Stiawa", new Date(10, 06, 1994));
        System.out.println (iris.getPerson());
        System.out.println (iris.getDate().isLeapYear());


        GiroKonto kontoGiro = new GiroKonto(1, 20, iris);
        KreditCard kontoKredit = new KreditCard(1, 50, iris, -200);

        iris.setKonto(kontoGiro);
        iris.setKonto(kontoKredit);


        System.out.println(iris.getKontoList());
        System.out.println("Iris gesamtes Kapital beträgt: " + iris.getCapital() + "€");

        ArrayList<Konto> myKontos= iris.getKontos();
        System.out.println(myKontos.get(0).payOff(10));
        System.out.println(myKontos.get(0).deposit(300));

        System.out.println(myKontos.get(1).payOff(200));
        System.out.println(myKontos.get(1).deposit(300));



        CustomKontoType getGiros = new CustomKontoType("GiroKonto");
        ArrayList<Konto> matchedGiros = filter(iris.getKontos(), getGiros);
        printList(matchedGiros, "Giro");

        CustomKontoType getKredits = new CustomKontoType("KreditCard");
        ArrayList<Konto> matchedKredits = filter(iris.getKontos(), getKredits);
        printList(matchedKredits, "Kredit");

    }

    public static ArrayList<Konto> filter(ArrayList<Konto> myKontos, Matcher<Konto> matcher){
        ArrayList<Konto> filtered = new ArrayList<Konto>();

        for(Konto konto: myKontos) {
            if (matcher.match(konto)) {
                filtered.add(konto);
            }
        }

        return filtered;
    }

    public static void printList(ArrayList<Konto> myFilterd, String type){
        for (Konto konto: myFilterd){
            System.out.print("Kontotype: " + type + " Count: " + konto.getKontoCount()+ "€\n");
        }
    }


}
