package at.exe.TexasHoldem;

import java.util.ArrayList;

import static at.exe.TexasHoldem.Const.DECK_MAX_VALUES;

public class CardSet {
    ArrayList<Card> cards = new ArrayList<>(DECK_MAX_VALUES);
    String[] CardType = {"♥", "♦", "♠", "♣"};
    String[] CardNumber = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};

    protected CardSet(){
        this.createCardSet();

    }

    protected ArrayList<Card> createCardSet(){

        for(String type: CardType){
            for(String numb : CardNumber){
                Card newCard = new Card(type, numb);
                cards.add(newCard);
            }
        }

       return cards;
    }

}
