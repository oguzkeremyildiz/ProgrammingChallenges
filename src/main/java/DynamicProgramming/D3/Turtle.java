package DynamicProgramming.D3;/* Created by oguzkeremyildiz on 5.07.2020 */

import Cookies.Tuple.Pair;

public class Turtle {

    private int index;
    private Pair<Integer, Integer> pair;

    public Turtle(Integer index, Pair<Integer, Integer> pair) {
        this.index = index;
        this.pair = pair;
    }

    public int getIndex() {
        return index;
    }

    public Pair<Integer, Integer> getPair() {
        return pair;
    }

    public String toString() {
        return  "[" + getIndex() + ", " + getPair().getKey() + ", " + getPair().getValue() + "]";
    }
}
