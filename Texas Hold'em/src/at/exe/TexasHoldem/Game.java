package at.exe.TexasHoldem;

import java.util.ArrayList;
import java.util.Random;

public class Game extends Analyzer {


    public Game(int numbOfPlayer){
        this.createPlayers(numbOfPlayer);
        this.gameBoard = this.createBoard();

    }

    protected Board createBoard() {
        Board gameBoard = new Board();
        return gameBoard;
    }

    protected ArrayList<Player> createPlayers(int numbOfPlayer) {

        for(int i = 1; i <= numbOfPlayer; i++){
            Player newPlayer = new Player(i);
            players.add(newPlayer);
        }
        return players;
    }

    public void gameStart(){
        System.out.println("Game starts!! All players get 2 cards...");
        this.firstCardsGiven();
        for (Player gamer: players){
            this.firstCheck(gamer);
        }
    }

    protected void firstCardsGiven() {

        for(Player gamer : players){
            for(int i = 0; i <= 1; i++){
                int cardNumb = this.randNumb();
                Card givenCard = gameCardSet.cards.get(cardNumb);
                gamer.playerCards.add(givenCard);
                gameCardSet.cards.remove(cardNumb);
            }
            System.out.println(gamer.playerCards.get(0));
            System.out.println(gamer.playerCards.get(1));
        }

    }

    protected int randNumb(){
        Random rn = new Random();
        int rand = rn.nextInt(gameCardSet.cards.size());
        return rand;
    }

    public void cardForBoard(){
        int rnCard = this.randNumb();
        Card newCard = gameCardSet.cards.get(rnCard);
        gameCardSet.cards.remove(rnCard);
        gameBoard.setBordCard(newCard);
        System.out.println(newCard);

    }

}
