package GraphAlgorithms.G2;/* Created by oguzkeremyildiz on 11.08.2020 */

import Cookies.Tuple.Pair;

public class Node {

    private int index;
    private Pair<Integer, Integer> pair;

    public Node(int index, Pair<Integer, Integer> pair) {
        this.index = index;
        this.pair = pair;
    }

    public Pair<Integer, Integer> getPair() {
        return pair;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) {
            return false;
        }
        Node node = (Node) o;
        return this.index == (node.index) && this.pair.equals(node.pair);
    }

    @Override
    public String toString() {
        return this.pair.toString();
    }
}
