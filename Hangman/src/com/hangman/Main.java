package com.hangman;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));


        System.out.print("Gib das Lösungswort ein: ");
        String word = scanner.nextLine();

        Game game = new Game(word);
    }
}
