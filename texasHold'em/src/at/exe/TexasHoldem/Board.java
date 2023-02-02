package at.exe.TexasHoldem;

import java.util.ArrayList;

import static at.exe.TexasHoldem.Const.DECK_MAX_VALUES;

public class Board {
    ArrayList<Card> boardCards = new ArrayList<>(DECK_MAX_VALUES);


    protected void setBordCard(Card newCard){
        boardCards.add(newCard);

    }

    protected Card getBoardCard (int numb) {
        return boardCards.get(numb);
    }

}
