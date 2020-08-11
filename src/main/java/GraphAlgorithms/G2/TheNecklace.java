package GraphAlgorithms.G2;/* Created by oguzkeremyildiz on 19.05.2020 */

import Cookies.Graph.Graph;
import Cookies.Tuple.Pair;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class TheNecklace {
    private static boolean finished;
    private static Graph<Pair<Integer, Integer>> addEdges(LinkedList<Pair<Integer, Integer>> pairs) {
        Graph<Pair<Integer, Integer>> graph = new Graph<>();
        for (Pair<Integer, Integer> pair : pairs) {
            graph.put(pair, new LinkedList<>());
            for (Pair<Integer, Integer> key : graph.getKeySet()) {
                if (!key.equals(pair)) {
                    if (key.getKey().equals(pair.getKey()) || key.getKey().equals(pair.getValue()) || key.getValue().equals(pair.getKey()) || key.getValue().equals(pair.getValue())) {
                        graph.addUndirectedEdge(key, pair);
                    }
                }
            }
        }
        return graph;
    }
    private static void depthFirstSearch(Graph<Pair<Integer, Integer>> graph, Pair<Integer, Integer> current, LinkedList<Pair<Integer, Integer>> visited, Pair<Integer, Integer> start) {
        if (finished) {
            return;
        }
        for (int i = 0; i < graph.get(current).size(); i++) {
            if (!visited.contains(graph.get(current, i)) && graph.containsKey(graph.get(current, i))) {
                visited.add(graph.get(current, i));
                if (visited.size() == graph.size() && graph.get(current, i).equals(start)) {
                    System.out.println(visited);
                    finished = true;
                } else {
                    depthFirstSearch(graph, graph.get(current, i), visited, start);
                    visited.remove(graph.get(current, i));
                }
            } else {
                if (visited.size() == graph.size() && graph.get(current, i).equals(start)) {
                    System.out.println(visited);
                    finished = true;
                }
            }
        }
    }
    private static void find(Graph<Pair<Integer, Integer>> graph, Pair<Integer, Integer> pair) {
        LinkedList<Pair<Integer, Integer>> visited = new LinkedList<>();
        visited.add(pair);
        depthFirstSearch(graph, pair, visited, pair);
        if (!finished) {
            System.out.println("some beads may be lost");
        }
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Necklace.txt"));
            LinkedList<Pair<Integer, Integer>> pairs = new LinkedList<>();
            Graph<Pair<Integer, Integer>> graph;
            int times = source.nextInt();
            for (int i = 0; i < times; i++) {
                finished = false;
                int size = source.nextInt();
                for (int j = 0; j < size; j++) {
                    pairs.add(new Pair<>(source.nextInt(), source.nextInt()));
                }
                graph = addEdges(pairs);
                System.out.println("Case #" + (i + 1));
                find(graph, pairs.getFirst());
                graph.clear();
                pairs.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
