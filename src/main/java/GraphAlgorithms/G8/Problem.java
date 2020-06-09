package GraphAlgorithms.G8;/* Created by oguzkeremyildiz on 8.06.2020 */

import java.util.LinkedList;

public class Problem {

    private int no;
    private int categories;
    private LinkedList<Integer> categoryList;

    public Problem(int no, int categories) {
        this.no = no;
        this.categories = categories;
        categoryList = new LinkedList<>();
    }

    public void addCategory(int category) {
        categoryList.add(category);
    }

    public int getCategory(int index) {
        return categoryList.get(index);
    }

    public boolean contains(int category) {
        return categoryList.contains(category);
    }

    public int find(int category) {
        int total = 0;
        for (Integer i : categoryList) {
            if (i.equals(category)) {
                total++;
            }
        }
        return total;
    }

    public int getNo() {
        return no;
    }
}
