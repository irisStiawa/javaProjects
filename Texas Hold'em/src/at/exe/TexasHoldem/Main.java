package at.exe.TexasHoldem;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        System.out.print("Spieleranzahl: ");
        int check = scanner.nextInt();

        if (check == 1 || check == 2 || check == 3 || check == 4){
            Game newGame = new Game(check);
            newGame.gameStart();

            for(int i = 0; i<5; i++) {
                newGame.cardForBoard();
            }

            newGame.endCheck();
        } else {
            System.out.println("Es dürfen maximal vier Spieler teilnehmen!!");
        }









    }
}
