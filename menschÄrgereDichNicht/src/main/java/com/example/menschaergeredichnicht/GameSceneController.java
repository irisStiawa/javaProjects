package com.example.menschaergeredichnicht;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


import java.nio.file.Path;
import java.util.HashMap;


import static com.example.menschaergeredichnicht.Game.players;
import static java.nio.file.Files.newInputStream;


public class GameSceneController {
    @FXML
    private StackPane homeR1;
    @FXML
    private StackPane homeR2;
    @FXML
    private StackPane homeR3;
    @FXML
    private StackPane homeR4;
    @FXML
    private StackPane f13;
    @FXML
    private StackPane f14;
    @FXML
    private StackPane f15;
    @FXML
    private StackPane f16;
    @FXML
    private StackPane f17;
    @FXML
    private StackPane f22;
    @FXML
    private StackPane f18;
    @FXML
    private StackPane f21;
    @FXML
    private StackPane f20;
    @FXML
    private StackPane f19;
    @FXML
    private StackPane homeY3;
    @FXML
    private StackPane f34;
    @FXML
    private StackPane f33;
    @FXML
    private StackPane f32;
    @FXML
    private StackPane f31;
    @FXML
    private StackPane f30;
    @FXML
    private StackPane f29;
    @FXML
    private StackPane f28;
    @FXML
    private StackPane f27;
    @FXML
    private StackPane f26;
    @FXML
    private StackPane f25;
    @FXML
    private StackPane f24;
    @FXML
    private StackPane f23;
    @FXML
    private StackPane f35;
    @FXML
    private StackPane f36;
    @FXML
    private StackPane f37;
    @FXML
    private StackPane f38;
    @FXML
    private StackPane f39;
    @FXML
    private StackPane f40;
    @FXML
    private StackPane f1;
    @FXML
    private StackPane f2;
    @FXML
    private StackPane f3;
    @FXML
    private StackPane f4;
    @FXML
    private StackPane f5;
    @FXML
    private StackPane f6;
    @FXML
    private StackPane f8;
    @FXML
    private StackPane f9;
    @FXML
    private StackPane f10;
    @FXML
    private StackPane f11;
    @FXML
    private StackPane f12;
    @FXML
    private StackPane r3;
    @FXML
    private StackPane r2;
    @FXML
    private StackPane r1;
    @FXML
    private StackPane b4;
    @FXML
    private StackPane b3;
    @FXML
    private StackPane b2;
    @FXML
    private StackPane b1;
    @FXML
    private StackPane homeB4;
    @FXML
    private StackPane homeB3;
    @FXML
    private StackPane homeB2;
    @FXML
    private StackPane homeB1;
    @FXML
    private StackPane homeG2;
    @FXML
    private StackPane homeG1;
    @FXML
    private StackPane homeG4;
    @FXML
    private StackPane homeG3;
    @FXML
    private StackPane homeY4;
    @FXML
    private StackPane homeY2;
    @FXML
    private StackPane homeY1;
    @FXML
    private StackPane g1;
    @FXML
    private StackPane g2;
    @FXML
    private StackPane g3;
    @FXML
    private StackPane g4;
    @FXML
    private StackPane y1;
    @FXML
    private StackPane y2;
    @FXML
    private StackPane y3;
    @FXML
    private StackPane y4;
    @FXML
    private StackPane r4;
    @FXML
    private Button buttonDice;
    @FXML
    private StackPane f7;

    @FXML
    private ImageView diceView;

    public static Game game = new Game();
    @FXML
    private Label info;


    @FXML
    private void onMouseEnteredDice(MouseEvent mouseEvent) {
        buttonDice.setStyle("-fx-background-color: #A39384");
    }

    @FXML
    private void onMouseExitedDice(MouseEvent mouseEvent) {
        buttonDice.setStyle("-fx-background-color: #7D7065");
    }

    @FXML
    private void initialize() {

        for (Player p : players){

            HashMap<Integer, Field> home = getPlayerHome(p.getColor());
            HashMap<Integer, Field> round = getRound(p.getColor());

            p.setHome(home);
            p.setRound(round);

        }

        game.initGame(info);

    }

    private HashMap<Integer, Field> getPlayerHome(Color c){
        HashMap<Integer,Field> red = new HashMap<Integer,Field>();
        red.put(1,new Field(homeR1));
        red.put(2,new Field(homeR2));
        red.put(3,new Field(homeR3));
        red.put(4,new Field(homeR4));

        HashMap<Integer,Field> blue = new HashMap<Integer,Field>();
        blue.put(1,new Field(homeB1));
        blue.put(2,new Field(homeB2));
        blue.put(3,new Field(homeB3));
        blue.put(4,new Field(homeB4));

        HashMap<Integer,Field> green = new HashMap<Integer,Field>();
        green.put(1,new Field(homeG1));
        green.put(2,new Field(homeG2));
        green.put(3,new Field(homeG3));
        green.put(4,new Field(homeG4));

        HashMap<Integer,Field> yellow = new HashMap<Integer,Field>();
        yellow.put(1,new Field(homeY1));
        yellow.put(2,new Field(homeY2));
        yellow.put(3,new Field(homeY3));
        yellow.put(4,new Field(homeY4));

        return switch (c) {
            case RED -> red;
            case BLUE -> blue;
            case GREEN -> green;
            case YELLOW -> yellow;
            default -> null;
        };
    }

    private HashMap<Integer, Field> getRound(Color c){
        HashMap<Integer,Field> roundRed = new HashMap<Integer,Field>();
        roundRed.put(1,new Field(f11));
        roundRed.put(2,new Field(f12));
        roundRed.put(3,new Field(f13));
        roundRed.put(4,new Field(f14));
        roundRed.put(5,new Field(f15));
        roundRed.put(6,new Field(f16));
        roundRed.put(7,new Field(f17));
        roundRed.put(8,new Field(f18));
        roundRed.put(9,new Field(f19));
        roundRed.put(10,new Field(f20));
        roundRed.put(11,new Field(f21));
        roundRed.put(12,new Field(f22));
        roundRed.put(13,new Field(f23));
        roundRed.put(14,new Field(f24));
        roundRed.put(15,new Field(f25));
        roundRed.put(16,new Field(f26));
        roundRed.put(17,new Field(f27));
        roundRed.put(18,new Field(f28));
        roundRed.put(19,new Field(f29));
        roundRed.put(20,new Field(f30));
        roundRed.put(21,new Field(f31));
        roundRed.put(22,new Field(f32));
        roundRed.put(23,new Field(f33));
        roundRed.put(24,new Field(f34));
        roundRed.put(25,new Field(f35));
        roundRed.put(26,new Field(f36));
        roundRed.put(27,new Field(f37));
        roundRed.put(28,new Field(f38));
        roundRed.put(29,new Field(f39));
        roundRed.put(30,new Field(f40));
        roundRed.put(31,new Field(f1));
        roundRed.put(32,new Field(f2));
        roundRed.put(33,new Field(f3));
        roundRed.put(34,new Field(f4));
        roundRed.put(35,new Field(f5));
        roundRed.put(36,new Field(f6));
        roundRed.put(37,new Field(f7));
        roundRed.put(38,new Field(f8));
        roundRed.put(39,new Field(f9));
        roundRed.put(40,new Field(f10));
        roundRed.put(41, new Field(r1));
        roundRed.put(42, new Field(r2));
        roundRed.put(43, new Field(r3));
        roundRed.put(44, new Field(r4));

        HashMap<Integer,Field> roundBlue = new HashMap<Integer,Field>();

        roundBlue.put(1,new Field(f21));
        roundBlue.put(2,new Field(f22));
        roundBlue.put(3,new Field(f23));
        roundBlue.put(4,new Field(f24));
        roundBlue.put(5,new Field(f25));
        roundBlue.put(6,new Field(f26));
        roundBlue.put(7,new Field(f27));
        roundBlue.put(8,new Field(f28));
        roundBlue.put(9,new Field(f29));
        roundBlue.put(10,new Field(f30));
        roundBlue.put(11,new Field(f31));
        roundBlue.put(12,new Field(f32));
        roundBlue.put(13,new Field(f33));
        roundBlue.put(14,new Field(f34));
        roundBlue.put(15,new Field(f35));
        roundBlue.put(16,new Field(f36));
        roundBlue.put(17,new Field(f37));
        roundBlue.put(18,new Field(f38));
        roundBlue.put(19,new Field(f39));
        roundBlue.put(20,new Field(f40));
        roundBlue.put(21,new Field(f1));
        roundBlue.put(22,new Field(f2));
        roundBlue.put(23,new Field(f3));
        roundBlue.put(24,new Field(f4));
        roundBlue.put(25,new Field(f5));
        roundBlue.put(26,new Field(f6));
        roundBlue.put(27,new Field(f7));
        roundBlue.put(28,new Field(f8));
        roundBlue.put(29,new Field(f9));
        roundBlue.put(30,new Field(f10));
        roundBlue.put(31,new Field(f11));
        roundBlue.put(32,new Field(f12));
        roundBlue.put(33,new Field(f13));
        roundBlue.put(34,new Field(f14));
        roundBlue.put(35,new Field(f15));
        roundBlue.put(36,new Field(f16));
        roundBlue.put(37,new Field(f17));
        roundBlue.put(38,new Field(f18));
        roundBlue.put(39,new Field(f19));
        roundBlue.put(40,new Field(f20));
        roundBlue.put(41, new Field(b1));
        roundBlue.put(42, new Field(b2));
        roundBlue.put(43, new Field(b3));
        roundBlue.put(44, new Field(b4));

        HashMap<Integer,Field> roundGreen = new HashMap<Integer,Field>();

        roundGreen.put(1,new Field(f31));
        roundGreen.put(2,new Field(f32));
        roundGreen.put(3,new Field(f33));
        roundGreen.put(4,new Field(f34));
        roundGreen.put(5,new Field(f35));
        roundGreen.put(6,new Field(f36));
        roundGreen.put(7,new Field(f37));
        roundGreen.put(8,new Field(f38));
        roundGreen.put(9,new Field(f39));
        roundGreen.put(10,new Field(f40));
        roundGreen.put(11,new Field(f1));
        roundGreen.put(12,new Field(f2));
        roundGreen.put(13,new Field(f3));
        roundGreen.put(14,new Field(f4));
        roundGreen.put(15,new Field(f5));
        roundGreen.put(16,new Field(f6));
        roundGreen.put(17,new Field(f7));
        roundGreen.put(18,new Field(f8));
        roundGreen.put(19,new Field(f9));
        roundGreen.put(20,new Field(f10));
        roundGreen.put(21,new Field(f11));
        roundGreen.put(22,new Field(f12));
        roundGreen.put(23,new Field(f13));
        roundGreen.put(24,new Field(f14));
        roundGreen.put(25,new Field(f15));
        roundGreen.put(26,new Field(f16));
        roundGreen.put(27,new Field(f17));
        roundGreen.put(28,new Field(f18));
        roundGreen.put(29,new Field(f19));
        roundGreen.put(30,new Field(f20));
        roundGreen.put(31,new Field(f21));
        roundGreen.put(32,new Field(f22));
        roundGreen.put(33,new Field(f23));
        roundGreen.put(34,new Field(f24));
        roundGreen.put(35,new Field(f25));
        roundGreen.put(36,new Field(f26));
        roundGreen.put(37,new Field(f27));
        roundGreen.put(38,new Field(f28));
        roundGreen.put(39,new Field(f29));
        roundGreen.put(40,new Field(f30));
        roundGreen.put(41, new Field(g1));
        roundGreen.put(42, new Field(g2));
        roundGreen.put(43, new Field(g3));
        roundGreen.put(44, new Field(g4));

        HashMap<Integer,Field> roundYellow = new HashMap<Integer, Field>();

        roundYellow.put(1,new Field(f1));
        roundYellow.put(2,new Field(f2));
        roundYellow.put(3,new Field(f3));
        roundYellow.put(4,new Field(f4));
        roundYellow.put(5,new Field(f5));
        roundYellow.put(6,new Field(f6));
        roundYellow.put(7,new Field(f7));
        roundYellow.put(8,new Field(f8));
        roundYellow.put(9,new Field(f9));
        roundYellow.put(10,new Field(f10));
        roundYellow.put(11,new Field(f11));
        roundYellow.put(12,new Field(f12));
        roundYellow.put(13,new Field(f13));
        roundYellow.put(14,new Field(f14));
        roundYellow.put(15,new Field(f15));
        roundYellow.put(16,new Field(f16));
        roundYellow.put(17,new Field(f17));
        roundYellow.put(18,new Field(f18));
        roundYellow.put(19,new Field(f19));
        roundYellow.put(20,new Field(f20));
        roundYellow.put(21,new Field(f21));
        roundYellow.put(22,new Field(f22));
        roundYellow.put(23,new Field(f23));
        roundYellow.put(24,new Field(f24));
        roundYellow.put(25,new Field(f25));
        roundYellow.put(26,new Field(f26));
        roundYellow.put(27,new Field(f27));
        roundYellow.put(28,new Field(f28));
        roundYellow.put(29,new Field(f29));
        roundYellow.put(30,new Field(f30));
        roundYellow.put(31,new Field(f31));
        roundYellow.put(32,new Field(f32));
        roundYellow.put(33,new Field(f33));
        roundYellow.put(34,new Field(f34));
        roundYellow.put(35,new Field(f35));
        roundYellow.put(36,new Field(f36));
        roundYellow.put(37,new Field(f37));
        roundYellow.put(38,new Field(f38));
        roundYellow.put(39,new Field(f39));
        roundYellow.put(40,new Field(f40));
        roundYellow.put(41, new Field(y1));
        roundYellow.put(42, new Field(y2));
        roundYellow.put(43, new Field(y3));
        roundYellow.put(44, new Field(y4));

        return switch (c) {
            case RED -> roundRed;
            case BLUE -> roundBlue;
            case GREEN -> roundGreen;
            case YELLOW -> roundYellow;
            default -> null;
        };
    }


    @FXML
    private void onMousePressedDice(MouseEvent mouseEvent) throws Exception{
        if(game.isDiceBtnActive()){
            int diceResult = game.randNumb();
            int result = diceResult == 0? diceResult+1: diceResult;
            diceView.setImage(new Image(newInputStream(Path.of("C:\\Users\\iriss\\Documents\\Lehre Applikationsentwicklung\\WORK\\002_JAVA\\Mensch ärgere dich nicht\\" + result + ".png"))));
            game.playersMove(result);

        }
    }



}
