package at.pairofdice;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PairOfDice {
    public int die1;
    public int die2;
    public int round = 0;
    ArrayList<Student> students = new ArrayList<Student>();
    Scanner scan = new Scanner(new InputStreamReader(System.in));

    public PairOfDice(){

    }

    public void gameStart(){

        System.out.print("Player 1: ");
        String player1 = this.scan.nextLine();

        Student newPlayer1 = new Student(player1, 1);
        this.students.add(newPlayer1);

        System.out.print("Player 2: ");
        String player2 = this.scan.nextLine();

        Student newPlayer2 = new Student(player2, 1);
        this.students.add(newPlayer2);


        this.round();
    }


    public void roll(Student stud){
        Random rn = new Random();
        die1 = rn.nextInt(6)+1;
        die2 = rn.nextInt(6)+1;
        System.out.println("erster Würfel: " + die1);
        System.out.println("zweiter Würfel: " + die2);

        if( die1 == die2){
            System.out.println(stud.getName() + ": Gratulation du hast ein Paar!");
            System.exit(0);
        } else {
            System.out.println(stud.getName() + ": Leider kein Paar!");

        }
        System.out.print("Tippe n so das der nächste würfelt: ");
        String next = scan.nextLine();
    }

    public void round(){
        this.round++;
        System.out.println("Runde " + this.round + ":");
        for (Student stud : this.students){
            this.roll(stud);
        }

        this.round();
    }



}
