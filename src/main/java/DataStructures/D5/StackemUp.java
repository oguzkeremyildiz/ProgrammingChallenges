package DataStructures.D5;/* Created by oguzkeremyildiz on 22.01.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class StackemUp {
    private static void print(ArrayList<String> value, ArrayList<String> suit) {
        for (int i = 0; i < value.size(); i++){
            System.out.println(value.get(i) + " of " + suit.get(i));
        }
    }
    private static void normalDeck(ArrayList<String> value, ArrayList<String> suit){
        value.add("2");
        suit.add("Clubs");
        value.add("3");
        suit.add("Clubs");
        value.add("4");
        suit.add("Clubs");
        value.add("5");
        suit.add("Clubs");
        value.add("6");
        suit.add("Clubs");
        value.add("7");
        suit.add("Clubs");
        value.add("8");
        suit.add("Clubs");
        value.add("9");
        suit.add("Clubs");
        value.add("10");
        suit.add("Clubs");
        value.add("Jack");
        suit.add("Clubs");
        value.add("Queen");
        suit.add("Clubs");
        value.add("King");
        suit.add("Clubs");
        value.add("Ace");
        suit.add("Clubs");
        value.add("2");
        suit.add("Diamonds");
        value.add("3");
        suit.add("Diamonds");
        value.add("4");
        suit.add("Diamonds");
        value.add("5");
        suit.add("Diamonds");
        value.add("6");
        suit.add("Diamonds");
        value.add("7");
        suit.add("Diamonds");
        value.add("8");
        suit.add("Diamonds");
        value.add("9");
        suit.add("Diamonds");
        value.add("10");
        suit.add("Diamonds");
        value.add("Jack");
        suit.add("Diamonds");
        value.add("Queen");
        suit.add("Diamonds");
        value.add("King");
        suit.add("Diamonds");
        value.add("Ace");
        suit.add("Diamonds");
        value.add("2");
        suit.add("Hearts");
        value.add("3");
        suit.add("Hearts");
        value.add("4");
        suit.add("Hearts");
        value.add("5");
        suit.add("Hearts");
        value.add("6");
        suit.add("Hearts");
        value.add("7");
        suit.add("Hearts");
        value.add("8");
        suit.add("Hearts");
        value.add("9");
        suit.add("Hearts");
        value.add("10");
        suit.add("Hearts");
        value.add("Jack");
        suit.add("Hearts");
        value.add("Queen");
        suit.add("Hearts");
        value.add("King");
        suit.add("Hearts");
        value.add("Ace");
        suit.add("Hearts");
        value.add("2");
        suit.add("Spades");
        value.add("3");
        suit.add("Spades");
        value.add("4");
        suit.add("Spades");
        value.add("5");
        suit.add("Spades");
        value.add("6");
        suit.add("Spades");
        value.add("7");
        suit.add("Spades");
        value.add("8");
        suit.add("Spades");
        value.add("9");
        suit.add("Spades");
        value.add("10");
        suit.add("Spades");
        value.add("Jack");
        suit.add("Spades");
        value.add("Queen");
        suit.add("Spades");
        value.add("King");
        suit.add("Spades");
        value.add("Ace");
        suit.add("Spades");
    }
    private static void shuffle(ArrayList<Integer> current, ArrayList<String> value, ArrayList<String> suit){
        int currentNumber;
        String temporaryValue;
        String temporarySuit;
        HashSet<Integer> isNum = new HashSet<>();
        for (int i = 0; i < current.size(); i++){
            if (!isNum.contains(i) && i > 0){
                currentNumber = current.get(i);
                isNum.add(currentNumber - 1);
                temporaryValue = value.get(i);
                temporarySuit = suit.get(i);
                value.set(i, value.get(currentNumber - 1));
                value.set(currentNumber - 1, temporaryValue);
                suit.set(i, suit.get(currentNumber - 1));
                suit.set(currentNumber - 1, temporarySuit);
            }
        }
    }
    public static void main(String[]args){
        int numberOfDeck;
        int cards;
        int cardNumber;
        int[] values = new int[2];
        ArrayList<String> value = new ArrayList<>();
        ArrayList<String> suit = new ArrayList<>();
        normalDeck(value, suit);
        try {
            int deckNumber;
            LinkedHashMap<Integer, ArrayList<Integer>> deckList = new LinkedHashMap<>();
            ArrayList<Integer> decks = new ArrayList<>();
            ArrayList<Integer> current = new ArrayList<>();
            Scanner source = new Scanner(new File("Deck.txt"));
            numberOfDeck = source.nextInt();
            cards = source.nextInt();
            deckNumber = 0;
            for (int i = 0; i < numberOfDeck; i++){
                for (int t = 0; t < cards; t++){
                    for (int j = 1; j <= 52; j++){
                        cardNumber = source.nextInt();
                        decks.add(cardNumber);
                        if (j == 52){
                            deckNumber++;
                            deckList.put(deckNumber, decks);
                            decks = new ArrayList<>();
                        }
                    }
                }
                for (int k = 0; k < cards; k++){
                    values[k] = source.nextInt();
                    current.addAll(deckList.get(values[k]));
                    shuffle(current, value, suit);
                    current.clear();
                }
                print(value, suit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
