package DataStructures;/* Created by oguzkeremyildiz on 17.01.2020 */

import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable{
    ArrayList<Card> cards = new ArrayList<>();

    public Hand(){
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void sort(){
        Collections.sort(cards);
    }

    public boolean straightFlush(){
        sort();
        for (int i = 0; i < cards.size() - 1; i++){
            if (!cards.get(i).getSuit().equals(cards.get(i + 1).getSuit()) || cards.get(i).getValue() + 1 != cards.get(i + 1).getValue()){
                return false;
            }
        }
        return true;
    }

    public boolean fourOfAKind(){
        int number = 0;
        int current = cards.get(0).getValue();
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (cards.get(i + 1).getValue() == current){
                    number++;
                } else {
                    current = cards.get(i + 1).getValue();
                    number = 0;
                }
            }
        }
        return number == 3;
    }

    public boolean fullHouse(){
        ArrayList<Card> copy = new ArrayList<>(cards);
        ArrayList<Integer> cards1 = new ArrayList<>();
        int number1 = 1;
        int number2 = 1;
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (cards.get(i).getValue() == cards.get(i + 1).getValue()){
                    number1++;
                    cards1.add(cards.get(i).getValue());
                    cards1.add(cards.get(i).getValue());
                } else {
                    break;
                }
            }
        }
        for (int j = 0; j < cards1.size(); j++){
            for (int k = 0; k < cards.size(); k++){
                if (cards.get(k).getValue() == cards1.get(j)){
                    cards.remove(k);
                }
            }
        }
        for (int t = 0; t < cards.size(); t++){
            if (t < cards.size() - 1){
                if (cards.get(t).getValue() == cards.get(t + 1).getValue()){
                    number2++;
                } else {
                    break;
                }
            }
        }
        cards = new ArrayList<>(copy);
        return number1 == 3 && number2 == 2 || number1 == 2 && number2 == 3;
    }
    public boolean flush(){
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (!cards.get(i).getSuit().equals(cards.get(i + 1).getSuit())){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean straight(){
        for (int t = 0; t < cards.size(); t++){
            if (cards.get(t).getValue() == 14){
                cards.get(t).setValue(1);
            }
        }
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                for (int j = 0; j < cards.size(); j++){
                    if (cards.get(j).getValue() == 1){
                        cards.get(j).setValue(14);
                    }
                }
                if (cards.get(i).getValue() + 1 != cards.get(i + 1).getValue()){
                    return false;
                }
            }
        }
        for (int j = 0; j < cards.size(); j++){
            if (cards.get(j).getValue() == 1){
                cards.get(j).setValue(14);
            }
        }
        return true;
    }
    public int pair(){
        int sum = 0;
        int number = 0;
        int current = cards.get(0).getValue();
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (cards.get(i + 1).getValue() == current){
                    number++;
                } else {
                    if (number == 1){
                        sum = 1;
                    }
                    current = cards.get(i + 1).getValue();
                    number = 0;
                }
            }
        }
        return sum;
    }
    public int threeOfAKind(){
        int sum = 0;
        int number = 0;
        int current = cards.get(0).getValue();
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (cards.get(i + 1).getValue() == current){
                    number++;
                } else {
                    if (number == 2){
                        sum = 1;
                    }
                    current = cards.get(i + 1).getValue();
                    number = 0;
                }
            }
        }
        if (number == 2){
            sum = 1;
        }
        return sum;
    }
    public  int twoPairs(){
        ArrayList<Integer> cards1 = new ArrayList<>();
        ArrayList<Card> copy = new ArrayList<>(cards);
        int sum = 0;
        int number1 = 0;
        int number2 = 0;
        int current = cards.get(0).getValue();
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (cards.get(i + 1).getValue() == current){
                    number1++;
                    cards1.add(current);
                    cards1.add(current);
                } else {
                    if (number1 == 1){
                        break;
                    }
                    current = cards.get(i + 1).getValue();
                    number1 = 0;
                }
            }
        }
        for (int j = 0; j < cards1.size(); j++){
            for (int k = 0; k < cards.size(); k++){
                if (cards.get(k).getValue() == cards1.get(j)){
                    cards.remove(k);
                }
            }
        }
        int current2 = cards.get(0).getValue();
        for (int i = 0; i < cards.size(); i++){
            if (i < cards.size() - 1){
                if (cards.get(i + 1).getValue() == current2){
                    number2++;
                } else {
                    if (number1 == 1 && number2 == 1){
                        sum = 1;
                    }
                    current2 = cards.get(i + 1).getValue();
                    number2 = 0;
                }
            }
        }
        if (number1 == 1 && number2 == 1){
            sum = 1;
        }
        cards = new ArrayList<>(copy);
        return sum;
    }
    @Override
    public int compareTo(Object o) {
        Hand second = (Hand) o;
        for (int i = cards.size() - 1; i >= 0; i--){
            if (cards.get(i).compareTo(second.cards.get(i)) != 0){
                return cards.get(i).compareTo(second.cards.get(i));
            }
        }
        return 0;
    }
}
