package at.exe.TexasHoldem;

public final class Card {
    String family;
    String value;

    protected Card(String family, String value){
        this.family = family;
        this.value = value;
    }

    @Override
    public String toString() {
        return value+family;
    }
}
