package GraphAlgorithms.G4;/* Created by oguzkeremyildiz on 22.05.2020 */

import java.util.LinkedList;

public class Roads {

    private LinkedList<Road> roads;

    public Roads() {
        roads = new LinkedList<>();
    }

    public void add(Road road) {
        roads.add(road);
    }

    public boolean containsRoadName(String name) {
        for (Road road : roads) {
            if (road.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Road getRoad(String name) {
        for (Road road : roads) {
            if (road.getName().equals(name)) {
                return road;
            }
        }
        return null;
    }

    public Road getFirst() {
        return roads.getFirst();
    }

    public Road getLast() {
        return roads.getLast();
    }

    public Road get(int index) {
        return roads.get(index);
    }

    public int size() {
        return roads.size();
    }

    public void clear() {
        roads.clear();
    }
}
