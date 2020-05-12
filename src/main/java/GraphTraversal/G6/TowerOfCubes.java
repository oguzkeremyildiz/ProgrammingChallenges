package GraphTraversal.G6;/* Created by oguzkeremyildiz on 11.05.2020 */

import Cookies.Tuple.Pair;
import Cookies.Graph.LinkedGraph;
import Cookies.Tuple.Triplet;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class TowerOfCubes {
    private static LinkedList<Pair<Integer, String>> bestList;
    private static LinkedGraph<Cube> addEdge(LinkedList<Cube> cubes) {
        LinkedGraph<Cube> graph = new LinkedGraph<>();
        for (int i = 0; i < cubes.size(); i++) {
            graph.put(cubes.get(i), new LinkedList<>());
            if (i + 1 < cubes.size()) {
                for (int j = i + 1; j < cubes.size(); j++) {
                    graph.addDirectedEdge(cubes.get(i), cubes.get(j));
                }
            }
        }
        return graph;
    }
    private static LinkedList<Pair<Integer, String>> find(LinkedGraph<Cube> graph) {
        LinkedList<Pair<Integer, String>> best = new LinkedList<>();
        LinkedList<Pair<Integer, String>> currentBest;
        LinkedList<Pair<Integer, String>> start = new LinkedList<>();
        int iteration = 0;
        for (Cube key : graph.getKeySet()) {
            for (int i = 0; i < 6; i++) {
                start.add(new Pair<>(key.getWeight(), convertToString(i)));
                currentBest = search(graph, graph.get(key), start, new Triplet<>(key.getWeight(), key.get(i), i), key.getReverse(i).getKey());
                start.clear();
                if (currentBest.size() > best.size()) {
                    best.clear();
                    best.addAll(currentBest);
                }
                currentBest.clear();
            }
            iteration++;
            if (best.size() >= graph.size() - iteration) {
                return best;
            }
        }
        return best;
    }
    private static LinkedList<Pair<Integer, String>> search(LinkedGraph<Cube> graph, LinkedList<Cube> current, LinkedList<Pair<Integer, String>> list, Triplet<Integer, Integer, Integer> now, int reverse) {
        for (Cube cube : current) {
            if (cube.containsElement(reverse)) {
                for (int j = 0; j < 6; j++) {
                    if (cube.get(j) == reverse) {
                        LinkedList<Pair<Integer, String>> oldList = new LinkedList<>(list);
                        list.add(new Pair<>(cube.getWeight(), convertToString(j)));
                        if (graph.get(cube).size() > 0) {
                            search(graph, graph.get(cube), list, new Triplet<>(cube.getWeight(), cube.getReverse(j).getKey(), cube.getReverse(j).getValue()), cube.getReverse(j).getKey());
                        }
                        if (bestList.size() < list.size()) {
                            bestList.clear();
                            bestList.addAll(list);
                        }
                        list.clear();
                        list.addAll(oldList);
                    }
                }
            }
        }
        return bestList;
    }
    private static String convertToString(int i) {
        String string = "";
        switch (i) {
            case 0:
                string = "front";
                break;
            case 1:
                string = "back";
                break;
            case 2:
                string = "left";
                break;
            case 3:
                string = "right";
                break;
            case 4:
                string = "top";
                break;
            case 5:
                string = "bottom";
                break;
            default:
                break;
        }
        return string;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Cubes.txt"));
            LinkedList<Cube> cubes = new LinkedList<>();
            LinkedList<Pair<Integer, String>> list;
            bestList = new LinkedList<>();
            LinkedGraph<Cube> graph;
            int times = 10000;
            int count = 1;
            while (times != 0) {
                int weight = 1;
                times = source.nextInt();
                if (times > 0) {
                    for (int i = 0; i < times; i++) {
                        Cube cube = new Cube(0, 0, 0, 0, 0, 0, weight);
                        for (int j = 0; j < 6; j++) {
                            cube.add(j, source.nextInt());
                        }
                        cubes.add(cube);
                        weight++;
                    }
                    graph = addEdge(cubes);
                    System.out.println("Case #" + count);
                    list = find(graph);
                    System.out.println(list.size());
                    for (Pair<Integer, String> integerStringPair : list) {
                        System.out.println(integerStringPair);
                    }
                    graph.clear();
                    cubes.clear();
                    list.clear();
                    bestList.clear();
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
