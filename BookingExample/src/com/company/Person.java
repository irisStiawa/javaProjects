package com.company;

public class Person {
    private String Vorname;
    private String Nachname;
    private Datum datum;

    public Person(String vorname, String nachname, Datum datum) {
        Vorname = vorname;
        Nachname = nachname;
        this.datum = datum;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public Datum getDatum() {
        return datum;
    }

    public void setDatum(Datum datum) {
        this.datum = datum;
    }
}
