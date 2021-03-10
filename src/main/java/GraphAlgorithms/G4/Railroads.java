package GraphAlgorithms.G4;/* Created by oguzkeremyildiz on 22.05.2020 */

import Cookies.Graph.Edge;
import Cookies.Graph.IntegerLength;
import Cookies.Graph.WeightedGraph;
import Cookies.Tuple.Pair;

import java.io.File;
import java.util.*;

public class Railroads {
    private static Set<Road> addSet(Set<Road> keySet) {
        return new HashSet<>(keySet);
    }
    private static void addEdge(WeightedGraph<Road, Integer> graph, Roads list) {
        if (graph.size() > 0) {
            graph.put(list.getFirst(), new LinkedList<>());
            for (int i = 1; i < list.size(); i++) {
                graph.addDirectedEdge(list.getFirst(), list.get(i), new Edge<>(Math.abs(list.get(i).getHour() - list.getFirst().getHour())));
            }
            for (int i = 0; i < list.size(); i++) {
                Set<Road> keys = addSet(graph.getVertexList());
                for (Road key : keys) {
                    if (key.getName().equals(list.get(i).getName()) && !key.equals(list.get(i))) {
                        if (key.getHour() < list.get(i).getHour()) {
                            graph.addDirectedEdge(key, list.get(i), new Edge<>(Math.abs(list.get(i).getHour() - key.getHour())));
                        } else {
                            graph.addDirectedEdge(list.get(i), key, new Edge<>(Math.abs(list.get(i).getHour() - key.getHour())));
                        }
                    }
                }
            }
        } else {
            graph.put(list.getFirst(), new LinkedList<>());
            for (int i = 1; i < list.size(); i++) {
                graph.addDirectedEdge(list.getFirst(), list.get(i), new Edge<>(Math.abs(list.get(i).getHour() - list.getFirst().getHour())));
            }
        }
    }
    private static void findPath(WeightedGraph<Road, Integer> graph, int open, String start, String finish) {
        LinkedList<Pair<Road, Road>> list = new LinkedList<>();
        for (Road key : graph.getKeySet()) {
            if (key.getName().equals(start) && key.getHour() > open) {
                HashMap<Road, Pair<Integer, Road>> map = graph.bellmanFord(key);
                for (Road element : map.keySet()) {
                    if (element.getName().equals(finish) && map.get(element).getValue() != null) {
                        list.add(new Pair<>(key, element));
                    }
                }
            }
        }
        if (list.size() > 0) {
            int best = Integer.MAX_VALUE;
            Pair<Road, Road> pair = null;
            for (Pair<Road, Road> roadPair : list) {
                if (roadPair.getValue().getHour() < best) {
                    pair = new Pair<>(roadPair.getKey(), roadPair.getValue());
                    best = roadPair.getValue().getHour();
                } else if (roadPair.getValue().getHour() == best) {
                    if (pair != null) {
                        if (roadPair.getKey().getHour() > pair.getKey().getHour()) {
                            pair = new Pair<>(roadPair.getKey(), roadPair.getValue());
                        }
                    }
                }
            }
            if (pair != null) {
                System.out.println("Departure " + pair.getKey().getHour() + " " + pair.getKey().getName());
                System.out.println("Arrival " + pair.getValue().getHour() + " " + pair.getValue().getName());
            }
        } else {
            System.out.println("No connection");
        }
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Road.txt"));
            Roads list = new Roads();
            WeightedGraph<Road, Integer> graph = new WeightedGraph<>(new IntegerLength());
            String times = source.next();
            for (int i = 0; i < Integer.parseInt(times); i++) {
                String edges = source.next();
                for (int j = 0; j < Integer.parseInt(edges); j++) {
                    source.next();
                }
                String stations = source.next();
                for (int j = 0; j < Integer.parseInt(stations); j++) {
                    String size = source.next();
                    for (int k = 0; k < Integer.parseInt(size); k++) {
                        String hour = source.next();
                        String name = source.next();
                        list.add(new Road(name, Integer.parseInt(hour)));
                    }
                    addEdge(graph, list);
                    list.clear();
                }
                String open = source.next();
                String start = source.next();
                String finish = source.next();
                System.out.println("Scenario " + (i + 1));
                findPath(graph, Integer.parseInt(open), start, finish);
                graph.clear();
                list.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
