package at.exe.TexasHoldem;

import java.util.ArrayList;

import static at.exe.TexasHoldem.Const.DECK_MAX_VALUES;

public class Player {
    String name;
    ArrayList<Card> playerCards = new ArrayList<>(DECK_MAX_VALUES);

    protected Player(int number){
        this.name = "player" + String.valueOf(number);

    }


}
