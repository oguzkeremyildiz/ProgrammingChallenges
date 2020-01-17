package DataStructures;/* Created by oguzkeremyildiz on 13.01.2020 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PokerHands {
    public static void whoWin(int pointBlack, int pointWhite){
        if (pointBlack > pointWhite){
            System.out.println("Black Wins." + pointBlack);
        } else if (pointWhite > pointBlack){
            System.out.println("White Wins." + pointWhite);
        } else {
            System.out.println("Tie.");
        }
    }

    public static void highCards(Hand blackHand, Hand whiteHand){
        if (blackHand.compareTo(whiteHand) > 0){
            System.out.println("Black wins.");
        } else {
            if (blackHand.compareTo(whiteHand) < 0){
                System.out.println("White wins.");
            } else {
                System.out.println("Tie.");
            }
        }
    }
    public static void main(String[]args){
        try {
            int pointBlack = 0;
            int pointWhite = 0;
            Scanner scan = new Scanner(new File("Poker.txt"));
            int size = scan.nextInt();
            String line;
            for (int i = 0; i < size; i++){
                Hand blackHand = new Hand();
                Hand whiteHand = new Hand();
                for (int j = 0; j < 10; j++){
                    line = scan.next();
                    if (j < 5){
                        blackHand.addCard(new Card(line));
                    } else {
                        whiteHand.addCard(new Card(line));
                    }
                    if (j == 9){
                        blackHand.sort();
                        whiteHand.sort();
                        if (blackHand.straightFlush()){
                            pointBlack = 9;
                        } else if (blackHand.fourOfAKind()){
                            pointBlack = 8;
                        } else if (blackHand.fullHouse()){
                            pointBlack = 7;
                        }  else if (blackHand.flush()){
                            pointBlack = 6;
                        } else if (blackHand.straight()){
                            pointBlack = 5;
                        } else if (blackHand.threeOfAKind() == 1){
                            pointBlack = 4;
                        } else if (blackHand.twoPairs() == 1){
                            pointBlack = 3;
                        } else if (blackHand.pair() != 0){
                            pointBlack = 2;
                        }
                        if (whiteHand.straightFlush()){
                            pointWhite = 9;
                        } else if (whiteHand.fourOfAKind()){
                            pointWhite = 8;
                        } else if (whiteHand.fullHouse()){
                            pointWhite = 7;
                        } else if (whiteHand.flush()){
                            pointWhite = 6;
                        } else if (whiteHand.straight()){
                            pointWhite = 5;
                        } else if (whiteHand.threeOfAKind() == 1){
                            pointWhite = 4;
                        } else if (whiteHand.twoPairs() == 1){
                            pointWhite = 3;
                        } else if (whiteHand.pair() != 0){
                            pointWhite = 2;
                        }
                        if (pointBlack == 5 && pointWhite == 5){
                            highCards(blackHand, whiteHand);
                        }else if (pointBlack == 6 && pointWhite == 6){
                            highCards(blackHand, whiteHand);
                        }else if (pointBlack == 0 && pointWhite == 0){
                            highCards(blackHand, whiteHand);
                        } else if (pointBlack == 3 && pointWhite == 3){
                            if (blackHand.twoPairs() != whiteHand.twoPairs()){
                                whoWin(blackHand.twoPairs(), whiteHand.twoPairs());
                            } else {
                                highCards(blackHand, whiteHand);
                            }
                        } else if (pointBlack == 4 && pointWhite == 4){
                            if (blackHand.threeOfAKind() != whiteHand.threeOfAKind()){
                                whoWin(blackHand.threeOfAKind(), blackHand.threeOfAKind());
                            } else {
                                highCards(blackHand, whiteHand);
                            }
                        } else if (pointBlack == 2 && pointWhite == 2){
                            if (blackHand.pair() != whiteHand.pair()){
                                whoWin(blackHand.pair(), whiteHand.pair());
                            } else {
                                highCards(blackHand, whiteHand);
                            }
                        } else {
                            whoWin(pointBlack,pointWhite);
                        }
                        pointBlack = 0;
                        pointWhite = 0;
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
