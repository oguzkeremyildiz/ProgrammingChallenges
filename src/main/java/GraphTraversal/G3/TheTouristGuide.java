package GraphTraversal.G3;/* Created by oguzkeremyildiz on 27.04.2020 */

import Cookies.Graph.Edge;
import Cookies.Graph.IntegerLength;
import Cookies.Graph.LinkedWeightedGraph;
import Cookies.Tuple.Pair;
import Cookies.Tuple.Triplet;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class TheTouristGuide {
    private static LinkedList<Triplet<Integer, Integer, Integer>> outputs;
    private static HashSet<Integer> visited;
    private static LinkedList<Triplet<Integer, Integer, Integer>> addOutput(LinkedList<Triplet<Integer, Integer, Integer>> sequence, int finish) {
        LinkedList<Triplet<Integer, Integer, Integer>> outputs = new LinkedList<>();
        for (Triplet<Integer, Integer, Integer> integerIntegerIntegerTriplet : sequence) {
            if (integerIntegerIntegerTriplet.getA() == finish) {
                outputs.add(integerIntegerIntegerTriplet);
            }
        }
        sequence.removeAll(outputs);
        return outputs;
    }
    private static void next(LinkedWeightedGraph<Integer, Integer> graph, LinkedList<Pair<Integer, Edge<Integer>>> currentEdge, int index, int finish, int max, int length) {
        LinkedList<Triplet<Integer, Integer, Integer>> sequence = new LinkedList<>();
        for (Pair<Integer, Edge<Integer>> nextEdge : currentEdge) {
            if (!visited.contains(nextEdge.getKey())) {
                if (length > nextEdge.getValue().getCapacity()) {
                    if (nextEdge.getValue().getCapacity() > max) {
                        sequence.add(new Triplet<>(nextEdge.getKey(), max, index));
                    } else {
                        sequence.add(new Triplet<>(nextEdge.getKey(), nextEdge.getValue().getCapacity(), index));
                    }
                } else {
                    if (length > max) {
                        sequence.add(new Triplet<>(nextEdge.getKey(), max, index));
                    } else {
                        sequence.add(new Triplet<>(nextEdge.getKey(), length, index));
                    }
                }
            }
        }
        outputs.addAll(addOutput(sequence, finish));
        if (sequence.size() > 0 || visited.size() != graph.size()) {
            for (Triplet<Integer, Integer, Integer> element : sequence) {
                visited.add(element.getA());
                next(graph, graph.get(element.getA()), index + 1, finish, max, element.getB());
            }
        }
    }
    private static void breadthFirstSearch(LinkedWeightedGraph<Integer, Integer> graph, int start, int finish, int max) {
        outputs = new LinkedList<>();
        visited = new HashSet<>();
        visited.add(1);
        int index = 2;
        next(graph, graph.get(start), index, finish, max, graph.getFirst().getFirst().getValue().getCapacity());
        printBestOutput();
    }
    private static void printBestOutput() {
        Triplet<Integer, Integer, Integer> best = null;
        for (Triplet<Integer, Integer, Integer> output : outputs) {
            if (best == null) {
                best = output;
            } else {
                if (best.getB() < output.getB()) {
                    best = output;
                }
            }
        }
        System.out.println(best);
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Guide.txt"));
            int vertexSize = 1000;
            int times = 1000;
            int from, to, length, start, finish, max, scenario = 0;
            LinkedWeightedGraph<Integer, Integer> graph = new LinkedWeightedGraph<>(new IntegerLength());
            outputs = new LinkedList<>();
            while (vertexSize != 0 || times != 0) {
                scenario++;
                vertexSize = source.nextInt();
                times = source.nextInt();
                if (vertexSize != 0 || times != 0) {
                    for (int i = 1; i <= vertexSize; i++) {
                        graph.put(i, new LinkedList<>());
                    }
                    for (int i = 0; i < times; i++) {
                        from = source.nextInt();
                        to = source.nextInt();
                        length = source.nextInt();
                        graph.addUndirectedEdge(from, to, length, length);
                    }
                    start = source.nextInt();
                    finish = source.nextInt();
                    max = source.nextInt();
                    System.out.println("Scenario #" + scenario);
                    breadthFirstSearch(graph, start, finish, max);
                    outputs.clear();
                    graph.clear();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
