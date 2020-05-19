package GraphAlgorithms.G1;/* Created by oguzkeremyildiz on 17.05.2020 */

import Cookies.Graph.DoubleLength;
import Cookies.Graph.WeightedGraph;
import Cookies.Tuple.Pair;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Freckles {
    private static WeightedGraph<Integer, Double> addEdges(LinkedList<Pair<Double, Double>> coordinates) {
        WeightedGraph<Integer, Double> graph = new WeightedGraph<>(new DoubleLength());
        for (int i = 0; i < coordinates.size(); i++) {
            Pair<Double, Double> first = coordinates.get(i);
            for (int j = 0; j < coordinates.size(); j++) {
                Pair<Double, Double> second = coordinates.get(j);
                if (!second.equals(first)) {
                    if (graph.containsKey(i)) {
                        if (!graph.get(i).contains(new Pair<>(j, length(first, second)))) {
                            graph.addUndirectedEdge(i, j, length(first, second), length(first, second));
                        }
                    } else {
                        graph.addUndirectedEdge(i, j, length(first, second), length(first, second));
                    }
                }
            }
        }
        return graph;
    }
    private static double length(Pair<Double, Double> first, Pair<Double, Double> second) {
        double x = Math.abs(first.getKey()) - Math.abs(second.getKey());
        double y = Math.abs(first.getValue()) - Math.abs(second.getValue());
        return Math.sqrt((x * x) + (y * y));
    }
    public static void main(String[]args) {
        try {
            WeightedGraph<Integer, Double> graph;
            LinkedList<Pair<Double, Double>> coordinates = new LinkedList<>();
            Scanner source = new Scanner(new File("Freckles.txt"));
            String times = source.next();
            for (int i = 0; i < Integer.parseInt(times); i++) {
                String sequence = source.next();
                for (int j = 0; j < Integer.parseInt(sequence); j++) {
                    coordinates.add(new Pair<>(Double.parseDouble(source.next()), Double.parseDouble(source.next())));
                }
                graph = addEdges(coordinates);
                System.out.println(graph.kruskal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
