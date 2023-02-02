package at.exe.TexasHoldem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static at.exe.TexasHoldem.Const.PLAYER_MAX_VALUES;
import static java.util.Arrays.asList;

public abstract class Analyzer {

    ArrayList<Player> players  = new ArrayList<>(PLAYER_MAX_VALUES);
    CardSet gameCardSet = new CardSet();
    Board gameBoard;

    protected void firstCheck(Player player){
        String famCard1 = player.playerCards.get(0).family;
        String valCard1 = player.playerCards.get(0).value;
        String famCard2 = player.playerCards.get(1).family;
        String valCard2 = player.playerCards.get(1).value;

        if(valCard1.equals(valCard2)){
            System.out.printf("%S hat ein Pärchen :)\n", player.name);
        } else if(famCard1.equals(famCard2)){
            System.out.printf("%S hat zwei Karten in %s :) \n", player.name, famCard1);
        } else {
            System.out.printf("%S hat zwei komplett verschiedene Karten!! \n", player.name);
        }

    }

    public void endCheck(){

        ArrayList<String> ArrayCardValue = new ArrayList<>();
        ArrayList<String> ArrayCardFamily = new ArrayList<>();

        for(Card BoardNumbers: gameBoard.boardCards) {
            ArrayCardValue.add(BoardNumbers.value);
            ArrayCardFamily.add(BoardNumbers.family);
        }

        for(Player player: players){

            for(int i = 0; i <= 1; i++){
                ArrayCardValue.add(player.playerCards.get(i).value);
                ArrayCardFamily.add(player.playerCards.get(i).family);
            }


            for(String elem: ArrayCardFamily){
                System.out.print(elem + ", ");
            }

            System.out.print("\n");

            for(String elem: ArrayCardValue){
                System.out.print(elem + ", ");
            }

            System.out.print("\n");

            analyzingValue(ArrayCardValue, player);

            analyzingFamily(ArrayCardFamily, player);

            if(analyzingStreet(ArrayCardValue)) {
                System.out.printf("%S hat eine Straße!!", player);
            }

//            if(testAnalyzingStreet()){
//                System.out.println("Street function ist working!!");
//            }


            for(int i=0; i<=1; i++) {
                ArrayCardValue.remove(5);
                ArrayCardFamily.remove(5);
            }
        }

        System.out.println("Game quit, try again!! ☻");

    }

    public void analyzingValue(ArrayList<String> value, Player player){
        for(String elem : value){
            int count = Collections.frequency(value, elem);

            if(count == 3){
                System.out.printf("%S hat Drillinge !!! \n", player.name);
                break;
            } else if(count == 4){
                System.out.printf("%S hat einen Poker !!! \n", player.name);
                break;
            }
        }
    }

    public void analyzingFamily(ArrayList<String> family, Player player){
        for(String elem : family) {
            int count = Collections.frequency(family, elem);

            if(count == 5){
                System.out.printf("%S hat samt Board 5 Karten der Farbe: %s!!! \n", player.name, elem);

                break;
            }
        }
    }

    public boolean analyzingStreet(ArrayList<String> value){
        String[] street = {"T", "B", "D", "K", "A"};
        boolean res = false;

        for(String elem: street){
            int count = Collections.frequency(value, elem);

            if(count >= 1){
                res = true;
            } else {
                res = false;
                break;
            }
        }

        return res;
    }

    protected boolean testAnalyzingStreet(){
        ArrayList<String> value = new ArrayList<>();
        value.add("T");
        value.add("D");
        value.add("K");
        value.add("K");
        value.add("B");
        value.add("3");
        value.add("A");

        String[] street = {"T", "B", "D", "K", "A"};
        boolean res = false;

        for(String elem: street){
            int count = Collections.frequency(value, elem);

            if(count >= 1){
                res = true;
                System.out.println(res);
            } else {
                res = false;
                System.out.println(res);
                break;
            }
        }

        return res;
    }

}
