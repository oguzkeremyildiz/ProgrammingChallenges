package GraphTraversal.G8;/* Created by oguzkeremyildiz on 15.05.2020 */

import Cookies.Graph.Graph;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class HanoiTowerTroublesAgain {
    private static Graph<Integer> addEdge(HashSet<Integer> elements, int pegs) {
        Graph<Integer> graph = new Graph<>();
        boolean bool;
        int number = 0;
        do {
            number++;
            for (Integer key : graph.getKeySet()) {
                if (elements.contains(key + number)) {
                    graph.addDirectedEdge(key, number);
                }
            }
            bool = finish(pegs, graph);
            if (bool) {
                graph.put(number, new LinkedList<>());
            }
        } while (bool);
        return graph;
    }
    private static boolean finish(int pegs, Graph<Integer> graph) {
        boolean bool = true;
        if (graph.size() > pegs) {
            int total = 0;
            for (Integer key : graph.getKeySet()) {
                if (graph.get(key).size() == 0) {
                    total++;
                }
            }
            if (total == pegs) {
                bool = false;
            }
        } else {
            return true;
        }
        return bool;
    }
    private static HashSet<Integer> addSet() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= 1300; i++) {
            set.add(i * i);
        }
        return set;
    }
    public static void main(String[]args) {
        try {
            Graph<Integer> graph;
            Scanner source = new Scanner(new File("Hanoi.txt"));
            HashSet<Integer> elements;
            elements = addSet();
            int times = source.nextInt();
            for (int i = 0; i < times; i++) {
                int pegs = source.nextInt();
                if (pegs != 1) {
                    graph = addEdge(elements, pegs);
                    System.out.println(graph.size());
                    graph.clear();
                } else {
                    System.out.println("1");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
