package GraphTraversal.G2;/* Created by oguzkeremyildiz on 25.04.2020 */

import Cookies.Graph.Graph;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class PlayingWithWheels {

    private static LinkedList<String> changeDigit(int i, String current) {
        LinkedList<String> list = new LinkedList<>();
        int currentDigit = Integer.parseInt(current.charAt(i) + "");
        if (currentDigit == 9) {
            list.add(current.substring(0, i) + "0" + current.substring(i + 1));
            list.add(current.substring(0, i) + "8" + current.substring(i + 1));
        } else if (currentDigit == 0) {
            list.add(current.substring(0, i) + "1" + current.substring(i + 1));
            list.add(current.substring(0, i) + "9" + current.substring(i + 1));
        } else {
            list.add(current.substring(0, i) + Integer.toString(currentDigit + 1) + current.substring(i + 1));
            list.add(current.substring(0, i) + Integer.toString(currentDigit - 1) + current.substring(i + 1));
        }
        return list;
    }

    private static LinkedList<String> constructCandidates(String current) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.addAll(changeDigit(i, current));
        }
        return list;
    }

    private static Graph<String> addEdges() {
        Graph<String> graph = new Graph<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        String current = Integer.toString(i) + Integer.toString(j) + Integer.toString(k) + Integer.toString(l);
                        LinkedList<String> subsets = constructCandidates(current);
                        for (String subset : subsets) {
                            if (!graph.containsKey(current)) {
                                graph.addUndirectedEdge(current, subset);
                            } else if (!graph.get(current).contains(subset)) {
                                graph.addUndirectedEdge(current, subset);
                            }
                        }
                    }
                }
            }
        }
        return graph;
    }

    private static boolean breadthFirstSearch(Graph<String> graph, HashSet<String> edgeList, String current, String target) {
        HashMap<Integer, LinkedList<String>> depth = new HashMap<>();
        int iterate = 1;
        depth.put(iterate, new LinkedList<>());
        depth.get(iterate).add(current);
        boolean find = false;
        do {
            depth.put(iterate + 1, new LinkedList<>());
            for (int i = 0; i < depth.get(iterate).size(); i++) {
                String element = depth.get(iterate).get(i);
                for (int j = 0; j < graph.get(element).size(); j++) {
                    if (!edgeList.contains(graph.get(element, j))) {
                        edgeList.add(graph.get(element, j));
                        depth.get(iterate + 1).add(graph.get(element, j));
                        if (graph.get(element, j).equals(target)) {
                            System.out.println(iterate);
                            find = true;
                            break;
                        }
                    }
                }
            }
            iterate++;
        } while (depth.get(iterate).size() > 0);
        return find;
    }

    public static void main(String[] args) {
        try {
            Scanner source = new Scanner(new File("Wheels.txt"));
            int times = source.nextInt();
            int edgeListSize;
            String currentWheel;
            HashSet<String> edgeList = new HashSet<>();
            Graph<String> graph = addEdges();
            for (int i = 0; i < times; i++) {
                currentWheel = source.next();
                String target = source.next();
                edgeListSize = source.nextInt();
                for (int j = 0; j < edgeListSize; j++) {
                    edgeList.add(source.next());
                }
                if (!breadthFirstSearch(graph, edgeList, currentWheel, target)) {
                    if (currentWheel.equals(target)) {
                        System.out.println(0);
                    } else {
                        System.out.println(-1);
                    }
                }
                edgeList.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
