package GraphAlgorithms.G2;/* Created by oguzkeremyildiz on 19.05.2020 */

import Cookies.Graph.Graph;
import Cookies.Tuple.Pair;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class TheNecklace {
    private static boolean finished;
    private static void constructCandidates(LinkedList<Pair<Integer, Integer>> subsets, Graph<Pair<Integer, Integer>> graph, LinkedList<Pair<Integer, Integer>> sequence) {
        if (sequence.size() > 0) {
            if (graph.containsKey(sequence.getLast())) {
                for (int i = 0; i < graph.get(sequence.getLast()).size(); i++) {
                    Pair<Integer, Integer> current = graph.get(sequence.getLast()).get(i);
                    if (!sequence.contains(current)) {
                        if (sequence.getLast().getValue().equals(current.getKey())) {
                            subsets.add(current);
                        } else if (sequence.getLast().getValue().equals(current.getValue())) {
                            subsets.add(new Pair<>(current.getValue(), current.getKey()));
                        }
                    }
                }
            } else {
                for (int i = 0; i < graph.get(new Pair<>(sequence.getLast().getValue(), sequence.getLast().getKey())).size(); i++) {
                    Pair<Integer, Integer> current = graph.get(new Pair<>(sequence.getLast().getValue(), sequence.getLast().getKey())).get(i);
                    if (!sequence.contains(current)) {
                        if (sequence.getLast().getValue().equals(current.getKey())) {
                            subsets.add(current);
                        } else if (sequence.getLast().getValue().equals(current.getValue())) {
                            subsets.add(new Pair<>(current.getValue(), current.getKey()));
                        }
                    }
                }
            }
        } else {
            subsets.addAll(graph.getKeySet());
        }
    }
    private static boolean isASolution(LinkedList<Pair<Integer, Integer>> sequence) {
        if (sequence.getFirst().getKey().equals(sequence.getLast().getValue())) {
            for (int i = 0; i < sequence.size(); i++) {
                if (i + 1 < sequence.size()) {
                    if (!sequence.get(i).getValue().equals(sequence.get(i + 1).getKey())) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
    private static void backtrack(Graph<Pair<Integer, Integer>> graph, LinkedList<Pair<Integer, Integer>> sequence, int number) {
        if (sequence.size() == graph.size()) {
            if (isASolution(sequence)) {
                System.out.println("Case #" + number);
                for (Pair<Integer, Integer> integerPair : sequence) {
                    System.out.println(integerPair);
                }
                finished = true;
            }
        } else {
            if (!finished) {
                LinkedList<Pair<Integer, Integer>> subsets = new LinkedList<>();
                constructCandidates(subsets, graph, sequence);
                for (Pair<Integer, Integer> subset : subsets) {
                    sequence.add(subset);
                    backtrack(graph, sequence, number);
                    sequence.removeLast();
                }
            }
        }
    }
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
                backtrack(graph, new LinkedList<>(), (i + 1));
                if (!finished) {
                    System.out.println("Case #" + (i + 1));
                    System.out.println("some beads may be lost");
                }
                graph.clear();
                pairs.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
