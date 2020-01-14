package DataStructures;/* Created by oguzkeremyildiz on 13.01.2020 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    public static void sort(ArrayList<Integer> cardsFirstInt){
        int current;
        for (int i = 0; i < cardsFirstInt.size(); i++){
            for (int j = 0; j < cardsFirstInt.size(); j++){
                if (i != j){
                    if (cardsFirstInt.get(j) > cardsFirstInt.get(i)){
                        current = cardsFirstInt.get(i);
                        cardsFirstInt.set(i, cardsFirstInt.get(j));
                        cardsFirstInt.set(j, current);
                    }
                }
            }
        }
    }
    public static void convert(ArrayList<Character> cardsFirst, ArrayList<Integer> cardsFirstInt){
        for (int i = 0; i < cardsFirst.size(); i++){
            switch (cardsFirst.get(i)){
                case '2':
                    cardsFirstInt.add(2);
                    break;
                case '3':
                    cardsFirstInt.add(3);
                    break;
                case '4':
                    cardsFirstInt.add(4);
                    break;
                case '5':
                    cardsFirstInt.add(5);
                    break;
                case '6':
                    cardsFirstInt.add(6);
                    break;
                case '7':
                    cardsFirstInt.add(7);
                    break;
                case '8':
                    cardsFirstInt.add(8);
                    break;
                case '9':
                    cardsFirstInt.add(9);
                    break;
                case 'T':
                    cardsFirstInt.add(10);
                    break;
                case 'J':
                    cardsFirstInt.add(11);
                    break;
                case 'Q':
                    cardsFirstInt.add(12);
                    break;
                case 'K':
                    cardsFirstInt.add(13);
                    break;
                case 'A':
                    cardsFirstInt.add(14);
                    break;
            }
        }
    }
    public static int straightFlush(ArrayList<Integer> cardsFirstInt, ArrayList<Character> cardsSecond){ //it works
        int sum = 1;
        sort(cardsFirstInt);
        for (int i = 0; i < cardsSecond.size(); i++){
            if (i < cardsSecond.size() - 1){
                if (!cardsSecond.get(i).equals(cardsSecond.get(i + 1)) || cardsFirstInt.get(i) + 1 != cardsFirstInt.get(i + 1)){
                    sum = 0;
                    break;
                }
            }
        }
        return sum;
    }
    public static int fourOfAKind(ArrayList<Integer> cardsFirstInt){ //it works
        int sum = 0;
        int number = 0;
        int current = cardsFirstInt.get(0);
        sort(cardsFirstInt);
        for (int i = 0; i < cardsFirstInt.size(); i++){
            if (i < cardsFirstInt.size() - 1){
                if (cardsFirstInt.get(i + 1) == current){
                    number++;
                } else{
                    if (number == 3){
                        sum = 1;
                    }
                    current = cardsFirstInt.get(i + 1);
                    number = 0;
                }
            }
        }
        if (number == 3){
            sum = 1;
        }
        return sum;
    }
    public static int fullHouse(ArrayList<Integer> cardsFirstInt){ // it works
        ArrayList<Integer> cards = new ArrayList<>(cardsFirstInt);
        ArrayList<Integer> cards1 = new ArrayList<>();
        int sum = 0;
        int number1 = 1;
        int number2 = 1;
        sort(cardsFirstInt);
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (cards.get(i) == cards.get(i + 1)){
                    number1++;
                    cards1.add(cards.get(i));
                    cards1.add(cards.get(i));
                } else {
                    break;
                }
            }
        }
        for (int j = 0; j < cards1.size(); j++){
            for (int k = 0; k < cards.size(); k++){
                if (cards.get(k) == cards1.get(j)){
                    cards.remove(k);
                }
            }
        }
        for (int t = 0; t < cards.size(); t++){
            if (t < cards.size() - 1){
                if (cards.get(t) == cards.get(t + 1)){
                    number2++;
                } else {
                    break;
                }
            }
        }
        if (number1 == 3 && number2 == 2 || number1 == 2 && number2 == 3){
            sum = 1;
        }
        return sum;
    }
    public static void highCards(ArrayList<Integer> cardsFirstInt1, ArrayList<Integer> cardsFirstInt2){
        int biggest1 = 0;
        int biggest2 = 0;
        if (cardsFirstInt1.size() == 0){
            System.out.println("Tie.");
            return;
        }
        ArrayList<Integer> cards1 = new ArrayList<>(cardsFirstInt1);
        ArrayList<Integer> cards2 = new ArrayList<>(cardsFirstInt2);
        for (int i = 0; i < cardsFirstInt1.size(); i++){
            if (cardsFirstInt1.get(i) > biggest1){
                biggest1 = cardsFirstInt1.get(i);
            }
        }
        for (int j = 0; j < cardsFirstInt2.size(); j++){
            if (cardsFirstInt2.get(j) > biggest2){
                biggest2 = cardsFirstInt2.get(j);
            }
        }
        if (biggest1 > biggest2){
            System.out.println("Black Wins.");
        } else if (biggest2 > biggest1){
            System.out.println("White Wins.");
        } else {
            for (int t = 0; t < cards1.size(); t++){
                if (cards1.get(t) == biggest1){
                    cards1.remove(t);
                    break;
                }
            }
            for (int t = 0; t < cards2.size(); t++){
                if (cards2.get(t) == biggest2){
                    cards2.remove(t);
                    break;
                }
            }
            highCards(cards1,cards2);
        }
    }
    public static int flush(ArrayList<Character> cardsSecond){ //it works
        int sum = 1;
        for (int i = 0; i < cardsSecond.size(); i++){
            if (i < cardsSecond.size() - 1){
                if (!cardsSecond.get(i).equals(cardsSecond.get(i + 1))){
                    sum = 0;
                    break;
                }
            }
        }
        return sum;
    }
    public static int straight(ArrayList<Integer> cardsFirstInt){ //it works
        int sum = 1;
        for (int t = 0; t < cardsFirstInt.size(); t++){
            if (cardsFirstInt.get(t) == 14){
                cardsFirstInt.set(t, 1);
            }
        }
        sort(cardsFirstInt);
        for (int i = 0; i < cardsFirstInt.size(); i++){
            if (i < cardsFirstInt.size() - 1){
                if (cardsFirstInt.get(i) + 1 != cardsFirstInt.get(i + 1)){
                    sum = 0;
                    break;
                }
            }
        }
        for (int j = 0; j < cardsFirstInt.size(); j++){
            if (cardsFirstInt.get(j) == 1){
                cardsFirstInt.set(j, 14);
            }
        }
        return sum;
    }
    public static int pair(ArrayList<Integer> cardsFirstInt){ //it works
        int sum = 0;
        int number = 0;
        int current = cardsFirstInt.get(0);
        sort(cardsFirstInt);
        for (int i = 0; i < cardsFirstInt.size(); i++){
            if (i < cardsFirstInt.size() - 1){
                if (cardsFirstInt.get(i + 1) == current){
                    number++;
                } else {
                    if (number == 1){
                        sum = 1;
                    }
                    current = cardsFirstInt.get(i + 1);
                    number = 0;
                }
            }
        }
        if (number == 1){
            sum = 1;
        }
        return sum;
    }
    public static int threeOfAKind(ArrayList<Integer> cardsFirstInt){ //it works
        int sum = 0;
        int number = 0;
        int current = cardsFirstInt.get(0);
        sort(cardsFirstInt);
        for (int i = 0; i < cardsFirstInt.size(); i++){
            if (i < cardsFirstInt.size() - 1){
                if (cardsFirstInt.get(i + 1) == current){
                    number++;
                } else {
                    if (number == 2){
                        sum = 1;
                    }
                    current = cardsFirstInt.get(i + 1);
                    number = 0;
                }
            }
        }
        if (number == 2){
            sum = 1;
        }
        return sum;
    }
    public static int twoPairs(ArrayList<Integer> cardsFirstInt){
        ArrayList<Integer> cards = new ArrayList<>(cardsFirstInt);
        ArrayList<Integer> cards1 = new ArrayList<>();
        int sum = 0;
        int number1 = 0;
        int number2 = 0;
        int current = cards.get(0);
        sort(cards);
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (cards.get(i + 1) == current){
                    number1++;
                    cards1.add(current);
                    cards1.add(current);
                } else {
                    if (number1 == 1){
                        break;
                    }
                    current = cards.get(i + 1);
                    number1 = 0;
                }
            }
        }
        for (int j = 0; j < cards1.size(); j++){
            for (int k = 0; k < cards.size(); k++){
                if (cards.get(k) == cards1.get(j)){
                    cards.remove(k);
                }
            }
        }
        int current2 = cards.get(0);
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (cards.get(i + 1) == current2){
                    number2++;
                } else {
                    if (number1 == 1 && number2 == 1){
                        sum = 1;
                    }
                    current2 = cards.get(i + 1);
                    number2 = 0;
                }
            }
        }
        if (number1 == 1 && number2 == 1){
            sum = 1;
        }
        return sum;
    }
    public static void main(String[]args){
        try {
            int pointBlack = 0;
            int pointWhite = 0;
            Scanner scan = new Scanner(new File("Poker.txt"));
            int size = scan.nextInt();
            String line;
            char line1;
            char line2;
            ArrayList<Character> cardsBlackFirst = new ArrayList<>();
            ArrayList<Integer> cardsBlackFirstInt = new ArrayList<>();
            ArrayList<Character> cardsBlackSecond = new ArrayList<>();
            ArrayList<Character> cardsWhiteFirst = new ArrayList<>();
            ArrayList<Integer> cardsWhiteFirstInt = new ArrayList<>();
            ArrayList<Character> cardsWhiteSecond = new ArrayList<>();
            for (int i = 0; i < size; i++){
                for (int j = 0; j < 10; j++){
                    line = scan.next();
                    line1 = line.charAt(0);
                    line2 = line.charAt(1);
                    if (j < 5){
                        cardsBlackFirst.add(line1);
                        cardsBlackSecond.add(line2);
                    } else {
                        cardsWhiteFirst.add(line1);
                        cardsWhiteSecond.add(line2);
                    }
                    if (j == 9){
                        convert(cardsBlackFirst, cardsBlackFirstInt);
                        convert(cardsWhiteFirst, cardsWhiteFirstInt);
                        if (straightFlush(cardsBlackFirstInt,cardsBlackSecond) == 1){
                            pointBlack = 9;
                        } else if (fourOfAKind(cardsBlackFirstInt) == 1){
                            pointBlack = 8;
                        } else if (fullHouse(cardsBlackFirstInt) == 1){
                            pointBlack = 7;
                        }  else if (flush(cardsBlackSecond) == 1){
                            pointBlack = 6;
                        } else if (straight(cardsBlackFirstInt) == 1){
                            pointBlack = 5;
                        } else if (threeOfAKind(cardsBlackFirstInt) == 1){
                            pointBlack = 4;
                        } else if (twoPairs(cardsBlackFirstInt) == 1){
                            pointBlack = 3;
                        } else if (pair(cardsBlackFirstInt) != 0){
                            pointBlack = 2;
                        }
                        if (straightFlush(cardsWhiteFirstInt, cardsWhiteSecond) == 1){
                            pointWhite = 9;
                        } else if (fourOfAKind(cardsWhiteFirstInt) == 1){
                            pointWhite = 8;
                        } else if (fullHouse(cardsWhiteFirstInt) == 1){
                            pointWhite = 7;
                        } else if (flush(cardsWhiteSecond) == 1){
                            pointWhite = 6;
                        } else if (straight(cardsWhiteFirstInt) == 1){
                            pointWhite = 5;
                        } else if (threeOfAKind(cardsWhiteFirstInt) == 1){
                            pointWhite = 4;
                        } else if (twoPairs(cardsWhiteFirstInt) == 1){
                            pointWhite = 3;
                        } else if (pair(cardsWhiteFirstInt) != 0){
                            pointWhite = 2;
                        }
                        if (pointBlack == 5 && pointWhite == 5){
                            highCards(cardsBlackFirstInt, cardsWhiteFirstInt);
                        }else if (pointBlack == 6 && pointWhite == 6){
                            highCards(cardsBlackFirstInt, cardsWhiteFirstInt);
                        }else if (pointBlack == 0 && pointWhite == 0){
                            highCards(cardsBlackFirstInt, cardsWhiteFirstInt);
                        } else if (pointBlack == 3 && pointWhite == 3){
                            if (twoPairs(cardsBlackFirstInt) != twoPairs(cardsWhiteFirstInt)){
                                whoWin(twoPairs(cardsBlackFirstInt), twoPairs(cardsWhiteFirstInt));
                            } else {
                                highCards(cardsBlackFirstInt, cardsWhiteFirstInt);
                            }
                        } else if (pointBlack == 4 && pointWhite == 4){
                            if (threeOfAKind(cardsBlackFirstInt) != threeOfAKind(cardsWhiteFirstInt)){
                                whoWin(threeOfAKind(cardsBlackFirstInt), threeOfAKind(cardsWhiteFirstInt));
                            } else {
                                highCards(cardsBlackFirstInt, cardsWhiteFirstInt);
                            }
                        } else if (pointBlack == 2 && pointWhite == 2){
                            if (pair(cardsBlackFirstInt) != pair(cardsWhiteFirstInt)){
                                whoWin(pair(cardsBlackFirstInt), pair(cardsWhiteFirstInt));
                            } else {
                                highCards(cardsBlackFirstInt, cardsWhiteFirstInt);
                            }
                        } else {
                            whoWin(pointBlack,pointWhite);
                        }
                        cardsBlackFirst.clear();
                        cardsBlackFirstInt.clear();
                        cardsBlackSecond.clear();
                        cardsWhiteFirst.clear();
                        cardsWhiteFirstInt.clear();
                        cardsWhiteSecond.clear();
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
