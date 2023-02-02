package com.bank;

public class CustomKontoType implements Matcher<Konto> {
    String type;

    public CustomKontoType(String type){
        this.type = type;
    }

    @Override
    public boolean match(Konto konto){
        return konto.getClass().getSimpleName().equals(this.type);
    }
}
