package DataStructures.D2;/* Created by oguzkeremyildiz on 17.01.2020 */

import DataStructures.D2.Card;

import java.util.Comparator;

public class SuitComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getSuit().compareTo(o2.getSuit()) < 0){
            return -1;
        } else {
            if (o1.getSuit().compareTo(o2.getSuit()) > 0){
                return 1;
            } else {
                return o1.getValue() - o2.getValue();
            }
        }
    }
}
