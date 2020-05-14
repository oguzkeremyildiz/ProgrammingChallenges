package GraphTraversal.G7;/* Created by oguzkeremyildiz on 13.05.2020 */

import Cookies.Tuple.Pair;
import Cookies.Tuple.Triplet;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class FromDuskTillDawn {
    private static int minimum;
    private static int find(HashMap<String, LinkedList<Triplet<String, Integer, Integer>>> map, Pair<String, String> directions) {
        for (int i = 0; i < map.get(directions.getKey()).size(); i++) {
            Triplet<String, Integer, Integer> current = map.get(directions.getKey()).get(i);
            if (checkTime(current.getB()) && checkTime(setTime(current.getB(), current.getC()))) {
                int count = breadthFirstSearch(map, current, directions);
                if (count > 0 && minimum == 0) {
                    minimum = count;
                } else {
                    if (count != 0) {
                        if (count < minimum) {
                            minimum = count;
                        }
                    }
                }
            }
        }
        return minimum;
    }
    private static int breadthFirstSearch(HashMap<String, LinkedList<Triplet<String, Integer, Integer>>> map, Triplet<String, Integer, Integer> current, Pair<String, String> directions) {
        int iterate = 1;
        int returning = 0;
        HashMap<Integer, LinkedList<Pair<Integer, Triplet<String, Integer, Integer>>>> bfs = new HashMap<>();
        HashSet<Triplet<String, Integer, Integer>> visited = new HashSet<>();
        LinkedList<Pair<Integer, Triplet<String, Integer, Integer>>> destinationList = new LinkedList<>();
        visited.add(current);
        bfs.put(iterate, new LinkedList<>());
        if (drink(current.getB(), current.getC())) {
            bfs.get(iterate).add(new Pair<>(1, current));
        } else {
            bfs.get(iterate).add(new Pair<>(0, current));
        }
        do {
            iterate++;
            bfs.put(iterate, new LinkedList<>());
            for (int i = 0; i < bfs.get(iterate - 1).size(); i++) {
                Pair<Integer, Triplet<String, Integer, Integer>> from = bfs.get(iterate - 1).get(i);
                if (map.containsKey(from.getValue().getA())) {
                    for (int j = 0; j < map.get(from.getValue().getA()).size(); j++) {
                        Triplet<String, Integer, Integer> to = map.get(from.getValue().getA()).get(j);
                        if (!visited.contains(to)) {
                            if (checkTime(to.getB()) && checkTime(setTime(to.getB(), to.getC()))) {
                                int time = from.getKey();
                                if (drinkForTransportation(setTime(from.getValue().getB(), from.getValue().getC()), to.getB())) {
                                    time++;
                                }
                                if (drink(to.getB(), to.getC())) {
                                    time++;
                                }
                                bfs.get(iterate).add(new Pair<>(time, to));
                                if (to.getA().equals(directions.getValue())) {
                                    destinationList.add(bfs.get(iterate).getLast());
                                }
                                visited.add(to);
                            }
                        }
                    }
                }
            }
        } while (bfs.get(iterate).size() != 0);
        for (Pair<Integer, Triplet<String, Integer, Integer>> element : destinationList) {
            if (returning == 0 || element.getKey() < returning) {
                returning = element.getKey();
            }
        }
        return returning;
    }
    protected static boolean drinkForTransportation(int timeOne, int timeTwo) {
        if (timeOne > timeTwo) {
            return timeOne >= 12 && 12 <= timeTwo;
        } else if (timeTwo > timeOne) {
            for (int i = timeOne; i <= timeTwo; i++) {
                if (i == 12) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }
    protected static boolean drink(int currentTime, int addedOne) {
        if (addedOne < 24) {
            int last = setTime(currentTime, addedOne);
            return last >= 12 && 12 >= currentTime;
        }
        return true;
    }
    protected static boolean checkTime(int time) {
        if (time > 17) {
            return true;
        } else return time < 7;
    }
    protected static int setTime(int currentTime, int addedOne) {
        int total = currentTime + addedOne;
        if (total > 24) {
            total = (currentTime + addedOne) - 24;
        }
        return total;
    }
    public static void main(String[]args) {
        try {
            HashMap<String, LinkedList<Triplet<String, Integer, Integer>>> map = new HashMap<>();
            Scanner source = new Scanner(new File("Vladimir.txt"));
            String times = source.next();
            int testCases = 0;
            for (int i = 0; i < Integer.parseInt(times); i++) {
                String numberOfPath = source.next();
                minimum = 0;
                testCases++;
                for (int j = 0; j < Integer.parseInt(numberOfPath); j++) {
                    String placeOne = source.next();
                    String placeTwo = source.next();
                    String one = source.next();
                    String two = source.next();
                    if (!map.containsKey(placeOne)) {
                        map.put(placeOne, new LinkedList<>());
                    }
                    map.get(placeOne).add(new Triplet<>(placeTwo, Integer.parseInt(one), Integer.parseInt(two)));
                }
                String from = source.next();
                String to = source.next();
                Pair<String, String> directions = new Pair<>(from, to);
                int count = find(map, directions);
                System.out.println("Test Case " + testCases + ".");
                if (minimum == 0) {
                    System.out.println("There is no route Vladimir can take.");
                } else {
                    System.out.println("Vladimir needs " + count + " litre(s) of blood.");
                }
                map.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
