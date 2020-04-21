package DataStructures.D2;/* Created by oguzkeremyildiz on 17.01.2020 */

public class Card implements Comparable{
    SuitType suit;
    int value;

    public SuitType getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Card(String line){
        switch (line.charAt(0)){
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                value = line.charAt(0) - '0';
                break;
            case 'T':
                value = 10;
                break;
            case 'J':
                value = 11;
                break;
            case 'Q':
                value = 12;
                break;
            case 'K':
                value = 13;
                break;
            case 'A':
                value = 14;
                break;
            default:
                break;
        }
        switch (line.charAt(1)){
            case 'C':
                suit = SuitType.CLUBS;
                break;
            case 'D':
                suit = SuitType.DIAMONDS;
                break;
            case 'H':
                suit = SuitType.HEARTS;
                break;
            case 'S':
                suit = SuitType.SPADES;
                break;
            default:
                break;

        }
    }

    @Override
    public int compareTo(Object o) {
        Card second = (Card) o;
        return value - second.value;
    }
}
