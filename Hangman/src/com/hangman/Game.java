package com.hangman;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    ArrayList<String> result = new ArrayList<String>();
    String[] hangman = {"   _____", "    |/  |", "    |   O", "    |  `|´", "    |   ^","____|_____"};
    int stringSize;
    int letterCompare = 0;
    int countOfMan = -1;
    String noMan = "Nothing hangs here :)";
    Scanner scan = new Scanner(new InputStreamReader(System.in));
    ArrayList<String> state = new ArrayList<String>();;

    public Game(String result){

        for(String elem : result.split("")){
            this.result.add(elem);
            this.state.add( "_ ");
        }

        this.stringSize = this.result.size();
        this.scanning();
    }

    public void scanning(){
        boolean res = false;

        if(this.result.size() >= -1) {
            System.out.print("\nRate einen Buchstaben: ");
            String letter = this.scan.nextLine();

            for (int x = 0; x < this.result.size(); x++) {
                if (this.result.get(x).equals(letter)) {
                    this.result.set(x, "");
                    this.letterCompare++;
                    this.state.set(x, letter + ' ');
                    res = true;
                    System.out.print("Match!\n");
                    break;
                }
            }

            if (res == false) {
                countOfMan++;
            }

            this.res();
        }
    }

    public void res(){
        for(int x = 0; x <this.state.size(); x++){
            System.out.print(this.state.get(x));
        }

        System.out.print('\n');

        if(this.countOfMan == -1){
            System.out.print(this.noMan);
        } else {


            for(int i = 0; i<=this.countOfMan; i++){
                System.out.print(this.hangman[i]+'\n');
            }
        }

        if(this.countOfMan == this.hangman.length-1){
            System.out.print("You Lose :(!!!");

        } else if(this.countOfMan < this.hangman.length){
            if(this.stringSize > this.letterCompare){
                this.scanning();
            } else {
                System.out.print("You Win :D!!!");
            }
        }
    }
}
