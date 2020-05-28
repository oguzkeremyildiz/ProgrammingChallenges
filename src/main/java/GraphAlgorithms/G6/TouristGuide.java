package GraphAlgorithms.G6;

import Cookies.Graph.Graph;
import Cookies.Tuple.Pair;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class TouristGuide {
    private static LinkedList<LinkedList<String>> list;
    private static HashSet<String> stringVisited;
    private static LinkedList<String> findCamera(LinkedList<LinkedList<String>> paths, String start, String finish) {
        LinkedList<String> list = new LinkedList<>();
        if (paths.size() > 1) {
            for (int i = 0; i < paths.getFirst().size(); i++) {
                boolean bool = true;
                for (int j = 1; j < paths.size(); j++) {
                    if (!paths.get(j).contains(paths.getFirst().get(i))) {
                        bool = false;
                        break;
                    }
                }
                if (bool) {
                    if (!paths.getFirst().get(i).equals(start) && !paths.getFirst().get(i).equals(finish)) {
                        list.add(paths.getFirst().get(i));
                    }
                }
            }
        } else if (paths.size() == 1) {
            for (int i = 0; i < paths.getFirst().size(); i++) {
                String current = paths.getFirst().get(i);
                if (!current.equals(start) && !current.equals(finish)) {
                    list.add(current);
                }
            }
        }
        return list;
    }
    private static void find(Graph<String> graph, HashSet<String> cameras) {
        LinkedList<LinkedList<String>> paths;
        HashSet<Pair<String, String>> visited = new HashSet<>();
        for (String key1 : graph.getKeySet()) {
            for (String key2 : graph.getKeySet()) {
                if (!key1.equals(key2) && !visited.contains(new Pair<>(key1, key2))) {
                    visited.add(new Pair<>(key1, key2));
                    visited.add(new Pair<>(key2, key1));
                    list = new LinkedList<>();
                    stringVisited = new HashSet<>();
                    paths = depthFirstSearch(graph, key1, key2, new LinkedList<>());
                    cameras.addAll(findCamera(paths, key1, key2));
                }
            }
        }
    }
    private static LinkedList<LinkedList<String>> depthFirstSearch(Graph<String> graph, String start, String finish, LinkedList<String> sequence) {
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!stringVisited.contains(graph.get(start, i))) {
                stringVisited.add(graph.get(start, i));
                sequence.add(graph.get(start, i));
                if (!graph.get(start, i).equals(finish)) {
                    depthFirstSearch(graph, graph.get(start, i), finish, sequence);
                } else {
                    list.add((LinkedList<String>) sequence.clone());
                }
                sequence.removeLast();
                stringVisited.clear();
                stringVisited.addAll(sequence);
            }
        }
        return list;
    }
    public static void main(String[]args) {
        try {
            Graph<String> graph = new Graph<>();
            Scanner source = new Scanner(new File("Tourist.txt"));
            int iterate = 0;
            while (source.hasNext()) {
                iterate++;
                String graphSize = source.next();
                if (!graphSize.equals("0")) {
                    for (int i = 0; i < Integer.parseInt(graphSize); i++) {
                        graph.put(source.next(), new LinkedList<>());
                    }
                    String edges = source.next();
                    for (int i = 0; i < Integer.parseInt(edges); i++) {
                        String from = source.next();
                        String to = source.next();
                        graph.addUndirectedEdge(from, to);
                    }
                    LinkedList<Graph<String>> graphs = graph.connectedComponents();
                    HashSet<String> cameras = new HashSet<>();
                    HashSet<String> allCameras = new HashSet<>();
                    for (Graph<String> stringGraph : graphs) {
                        find(stringGraph, cameras);
                        allCameras.addAll(cameras);
                    }
                    System.out.println("City map #" + iterate + ": " + allCameras.size() + " camera(s) found");
                    for (String camera : allCameras) {
                        System.out.println(camera);
                    }
                    graph.clear();
                    graphs.clear();
                    cameras.clear();
                    allCameras.clear();
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
