package GraphTraversal;/* Created by oguzkeremyildiz on 24.04.2020 */

import Graph.Graph;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Bicoloring {
    private static boolean containsAllValues(HashMap<Boolean, LinkedList<Integer>> colorMap, HashSet<Integer> vertexList) {
        boolean check = false;
        for (Boolean key : colorMap.keySet()) {
            for (int i = 0; i < colorMap.get(key).size(); i++) {
                check = false;
                for (Integer vertex : vertexList) {
                    if (colorMap.get(key).get(i).equals(vertex)) {
                        check = true;
                    }
                }
                if (!check) {
                    break;
                }
            }
            if (!check) {
                break;
            }
        }
        return check;
    }
    private static HashMap<Boolean, LinkedList<Integer>> addColor(Graph<Integer> graph, HashSet<Integer> vertexList) {
        HashMap<Boolean, LinkedList<Integer>> colorMap = new HashMap<>();
        boolean color = false;
        colorMap.put(true, new LinkedList<>());
        colorMap.put(false, new LinkedList<>());
        for (Integer key : graph.getKeySet()) {
            for (int i = 0; i < graph.get(key).size(); i++) {
                colorMap.get(true).add(graph.get(key).get(i));
            }
            break;
        }
        while (!containsAllValues(colorMap, vertexList)) {
            if (!color) {
                for (int i = 0; i < colorMap.get(true).size(); i++) {
                    for (int j = 0; j < graph.get(colorMap.get(true).get(i)).size(); j++) {
                        colorMap.get(false).add(graph.get(colorMap.get(true).get(i)).get(j));
                    }
                }
                color = true;
            } else {
                for (int i = 0; i < colorMap.get(false).size(); i++) {
                    for (int j = 0; j < graph.get(colorMap.get(false).get(i)).size(); j++) {
                        colorMap.get(true).add(graph.get(colorMap.get(false).get(i)).get(j));
                    }
                }
                color = false;
            }
        }
        return colorMap;
    }
    private static boolean isBicolorable(HashMap<Boolean, LinkedList<Integer>> colorMap) {
        boolean bool = true;
        HashSet<Integer> set = new HashSet<>(colorMap.get(false));
        for (int i = 0; i < colorMap.get(true).size(); i++) {
            if (set.contains(colorMap.get(true).get(i))) {
                bool = false;
                break;
            }
        }
        return bool;
    }
    public static void main(String[]args) {
        try {
            Graph<Integer> graph = new Graph<Integer>();
            HashMap<Boolean, LinkedList<Integer>> colorMap;
            HashSet<Integer> vertexList = new HashSet<>();
            Scanner source = new Scanner(new File("Bicoloring.txt"));
            int times;
            int edgeSize;
            int vertex;
            int edge;
            while (true) {
                edgeSize = source.nextInt();
                if (edgeSize > 0) {
                times = source.nextInt();
                    for (int i = 0; i < times; i++) {
                        vertex = source.nextInt();
                        edge = source.nextInt();
                        vertexList.add(vertex);
                        vertexList.add(edge);
                        if (graph.containsKey(edge) && graph.containsKey(vertex)) {
                            graph.addUndirectedEdge(edge, vertex);
                        } else if (graph.containsKey(edge)) {
                            graph.put(vertex, new LinkedList<>());
                            graph.addUndirectedEdge(edge, vertex);
                        } else if (graph.containsKey(vertex)){
                            graph.put(edge, new LinkedList<>());
                            graph.addUndirectedEdge(edge, vertex);
                        } else {
                            graph.put(edge, new LinkedList<>());
                            graph.put(vertex, new LinkedList<>());
                            graph.addUndirectedEdge(edge, vertex);
                        }
                    }
                    colorMap = addColor(graph, vertexList);
                    if (isBicolorable(colorMap)) {
                        System.out.println("BICOLORABLE.");
                    } else {
                        System.out.println("NOT BICOLORABLE.");
                    }
                    graph.clear();
                    colorMap.clear();
                } else {
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
