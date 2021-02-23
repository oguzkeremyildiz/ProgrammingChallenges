package DynamicProgramming.D6;/* Created by oguzkeremyildiz on 23.02.2021 */

public class Node {

    private final int value;
    private final int weight;

    public Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;
        }
        Node node = (Node) obj;
        return this.value == node.value && this.weight == node.weight;
    }
}
