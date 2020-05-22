package GraphAlgorithms.G4;/* Created by oguzkeremyildiz on 22.05.2020 */

import Cookies.Graph.IntegerLength;
import Cookies.Graph.WeightedGraph;
import Cookies.Tuple.Pair;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Railroads {
    private static Roads setRoads(Set<Road> roads) {
        Roads returning = new Roads();
        for (Road key : roads) {
            returning.add(key);
        }
        return returning;
    }
    private static void addList(LinkedList<WeightedGraph<Road, Integer>> graphs, Roads list) {
        if (graphs.size() > 0) {
            for (WeightedGraph<Road, Integer> graph : graphs) {
                Roads keySet = setRoads(graph.getKeySet());
                Roads vertexSet = setRoads(graph.getVertexList());
                if (!keySet.containsRoadName(list.getFirst().getName()) && vertexSet.containsRoadName(list.getFirst().getName())) {
                    if (vertexSet.getRoad(list.getFirst().getName()).getHour() < list.getFirst().getHour()) {
                        for (int i = 1; i < list.size(); i++) {
                            graph.addDirectedEdge(list.getFirst(), list.get(i), list.get(i).getHour() - list.getFirst().getHour());
                        }
                    }
                }
            }
        }
        graphs.add(new WeightedGraph<>(new IntegerLength()));
        graphs.getLast().put(list.getFirst(), new LinkedList<>());
        for (int i = 1; i < list.size(); i++) {
            graphs.getLast().addDirectedEdge(list.getFirst(), list.get(i), list.get(i).getHour() - list.getFirst().getHour());
        }
    }
    private static void findPath(LinkedList<WeightedGraph<Road, Integer>> graphs, int open, String start, String finish) {
        LinkedList<Pair<Road, Road>> list = new LinkedList<>();
        for (int i = 0; i < graphs.size(); i++) {
            if (contains(graphs.get(i), start, open)) {
                for (Road key : graphs.get(i).getKeySet()) {
                    if (key.getName().equals(start) && key.getHour() > open) {
                        HashMap<Road, Pair<Integer, Road>> map = graphs.get(i).bellmanFord(key);
                        for (Road element : map.keySet()) {
                            if (element.getName().equals(finish)) {
                                list.add(new Pair<>(key, element));
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        if (list.size() > 0) {
            int best = Integer.MAX_VALUE;
            Pair<Road, Road> pair = null;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getValue().getHour() < best) {
                    pair = new Pair<>(list.get(i).getKey(), list.get(i).getValue());
                    best = list.get(i).getValue().getHour();
                } else if (list.get(i).getValue().getHour() == best) {
                    if (pair != null) {
                        if (list.get(i).getKey().getHour() > pair.getKey().getHour()) {
                            pair = new Pair<>(list.get(i).getKey(), list.get(i).getValue());
                        }
                    }
                }
            }
            System.out.println("Departure " + pair.getKey().getHour() + " " + pair.getKey().getName());
            System.out.println("Departure " + pair.getValue().getHour() + " " + pair.getValue().getName());
        } else {
            System.out.println("No connection");
        }
    }
    private static boolean contains(WeightedGraph<Road, Integer> graph, String target, int open) {
        for (Road key : graph.getKeySet()) {
            if (key.getName().equals(target) && key.getHour() > open) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Road.txt"));
            Roads list = new Roads();
            LinkedList<WeightedGraph<Road, Integer>> graphs = new LinkedList<>();
            String times = source.next();
            for (int i = 0; i < Integer.parseInt(times); i++) {
                String stations = source.next();
                for (int j = 0; j < Integer.parseInt(stations); j++) {
                    String size = source.next();
                    for (int k = 0; k < Integer.parseInt(size); k++) {
                        String hour = source.next();
                        String name = source.next();
                        list.add(new Road(name, Integer.parseInt(hour)));
                    }
                    addList(graphs, list);
                    list.clear();
                }
                String open = source.next();
                String start = source.next();
                String finish = source.next();
                System.out.println("Scenario " + (i + 1));
                findPath(graphs, Integer.parseInt(open), start, finish);
                graphs.clear();
                list.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
