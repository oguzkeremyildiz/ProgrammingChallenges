package GraphTraversal.G6;/* Created by oguzkeremyildiz on 11.05.2020 */

import Cookies.Tuple.Pair;

import java.util.LinkedList;

public class Cube {

    private int front;
    private int back;
    private int left;
    private int right;
    private int top;
    private int bottom;
    private int weight;
    private LinkedList<Integer> list;

    public Cube(int front, int back, int left, int right, int top, int bottom, int weight) {
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.weight = weight;
        list = new LinkedList<>();
        list.add(front);
        list.add(back);
        list.add(left);
        list.add(right);
        list.add(top);
        list.add(bottom);
    }

    public boolean containsElement(int element) {
        return list.contains(element);
    }

    public int get(int index) {
        return list.get(index);
    }

    public Pair<Integer, Integer> getReverse(int index) {
        switch (index) {
            case 0:
                return new Pair<>(getBack(), 1);
            case 1:
                return new Pair<>(getFront(), 0);
            case 2:
                return new Pair<>(getRight(), 3);
            case 3:
                return new Pair<>(getLeft(), 2);
            case 4:
                return new Pair<>(getBottom(), 5);
            case 5:
                return new Pair<>(getTop(), 4);
            default:
                break;
        }
        return null;
    }

    public void add(int index, int element) {
        switch (index) {
            case 0:
                list.set(0, element);
                setFront(element);
                break;
            case 1:
                list.set(1, element);
                setBack(element);
                break;
            case 2:
                list.set(2, element);
                setLeft(element);
                break;
            case 3:
                list.set(3, element);
                setRight(element);
                break;
            case 4:
                list.set(4, element);
                setTop(element);
                break;
            case 5:
                list.set(5, element);
                setBottom(element);
                break;
            default:
                break;
        }
    }

    private int getFront() {
        return front;
    }

    private void setFront(int front) {
        this.front = front;
    }

    private int getBack() {
        return back;
    }

    private void setBack(int back) {
        this.back = back;
    }

    private int getLeft() {
        return left;
    }

    private void setLeft(int left) {
        this.left = left;
    }

    private int getRight() {
        return right;
    }

    private void setRight(int right) {
        this.right = right;
    }

    private int getTop() {
        return top;
    }

    private void setTop(int top) {
        this.top = top;
    }

    private int getBottom() {
        return bottom;
    }

    private void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }
}
