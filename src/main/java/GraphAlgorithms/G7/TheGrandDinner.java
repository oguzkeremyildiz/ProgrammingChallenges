package GraphAlgorithms.G7;

import Cookies.Graph.Edge;
import Cookies.Graph.IntegerLength;
import Cookies.Graph.WeightedGraphEdge;

import java.io.File;
import java.util.*;

public class TheGrandDinner {
    private static void print(HashMap<String, LinkedList<String>> map, LinkedList<Integer> teamList) {
        HashMap<String, Integer> check = new HashMap<>();
        for (String string : map.keySet()) {
            check.put(string, 0);
        }
        for (int i = 0; i < teamList.size(); i++) {
            for (String key : map.keySet()) {
                if (map.get(key).contains("team" + (i + 1)) && !check.get(key).equals(map.get(key).size())) {
                    check.put(key, check.get(key) + 1);
                    System.out.print(key.substring(5) + " ");
                }
            }
            System.out.println();
        }
    }
    private static boolean isASolution(HashMap<String, LinkedList<String>> map, LinkedList<Integer> teamList) {
        int total = 0;
        for (String key : map.keySet()) {
            total += map.get(key).size();
        }
        return total == teamList.stream().mapToInt(Integer::intValue).sum();
    }
    private static void fordFulkerson(LinkedList<Integer> teamList, LinkedList<Integer> tableList, WeightedGraphEdge<String, Integer> graph) {
        String source = "s";
        String sink = "t";
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (int i = 0; i < tableList.size(); i++) {
            map.put("table" + (i + 1), new LinkedList<>());
        }
        LinkedHashMap<String, String> previousMap;
        LinkedList<String> list = new LinkedList<>();
        do {
            list.clear();
            previousMap = breadthFirstSearch(graph, source);
            if (previousMap.containsKey(sink) && previousMap.containsValue(source)) {
                String current = sink;
                list.add(sink);
                while (!list.contains(source)) {
                    list.add(previousMap.get(current));
                    current = previousMap.get(current);
                }
                setGraphAndMap(graph, map, list);
            }
        } while (list.contains(source));
        if (isASolution(map, teamList)) {
            System.out.println("1");
            print(map, teamList);
        } else {
            System.out.println("0");
        }
    }
    private static void setGraphAndMap(WeightedGraphEdge<String, Integer> graph, HashMap<String, LinkedList<String>> map, LinkedList<String> list) {
        if (!map.get(list.get(1)).contains(list.get(2))) {
            Collections.reverse(list);
            for (int i = 0; i < list.size(); i++) {
                if (i + 1 < list.size()) {
                    if (graph.containsKey(list.get(i))) {
                        for (int j = 0; j < graph.get(list.get(i)).size(); j++) {
                            if (list.get(i + 1).equals(graph.get(list.get(i), j).getKey())) {
                                graph.get(list.get(i), j).getValue().setFlow(graph.get(list.get(i), j).getValue().getFlow() + 1);
                                for (int k = 0; k < graph.get(list.get(i + 1)).size(); k++) {
                                    String current = graph.get(list.get(i + 1)).get(k).getKey();
                                    if (current.equals(list.get(i))) {
                                        graph.get(list.get(i + 1), k).getValue().setFlow(graph.get(list.get(i + 1), k).getValue().getFlow() - 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            map.get(list.get(2)).add(list.get(1));
        }
    }
    private static WeightedGraphEdge<String, Integer> setGraph(LinkedList<Integer> teamList, LinkedList<Integer> tableList) {
        WeightedGraphEdge<String, Integer> graph = new WeightedGraphEdge<>(new IntegerLength());
        for (int i = 0; i < teamList.size(); i++) {
            graph.addUndirectedEdge("s", "team" + (i + 1), new Edge<>(teamList.get(i), 0, new IntegerLength()), new Edge<>(teamList.get(i), new IntegerLength()));
        }
        for (int i = 0; i < tableList.size(); i++) {
            graph.addUndirectedEdge("table" + (i + 1), "t", new Edge<>(tableList.get(i), 0, new IntegerLength()), new Edge<>(tableList.get(i), new IntegerLength()));
        }
        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < tableList.size(); j++) {
                graph.addUndirectedEdge("team" + (i + 1), "table" + (j + 1), new Edge<>(1, 0, new IntegerLength()), new Edge<>(1, new IntegerLength()));
            }
        }
        return graph;
    }
    protected static LinkedHashMap<String, String> breadthFirstSearch(WeightedGraphEdge<String, Integer> graph, String source) {
        LinkedHashMap<String, String> returning = new LinkedHashMap<>();
        HashSet<String> set = new HashSet<>();
        HashMap<Integer, LinkedList<String>> map = new HashMap<>();
        int iterate = 0;
        map.put(iterate, new LinkedList<>());
        map.get(iterate).add(source);
        set.add(source);
        do {
            map.put(iterate + 1, new LinkedList<>());
            for (int i = 0; i < map.get(iterate).size(); i++) {
                String current = map.get(iterate).get(i);
                if (graph.containsKey(current)) {
                    set.add(current);
                    for (int j = 0; j < graph.get(current).size(); j++) {
                        if (!set.contains(graph.get(current).get(j).getKey()) && graph.get(current).get(j).getValue().getResidual() > 0) {
                            set.add(graph.get(current, j).getKey());
                            map.get(iterate + 1).add(graph.get(current, j).getKey());
                            returning.put(graph.get(current, j).getKey(), current);
                        }
                    }
                }
            }
            iterate++;
        } while (map.get(iterate).size() > 0);
        return returning;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Dinner.txt"));
            WeightedGraphEdge<String, Integer> graph;
            int teams = 1000;
            int tables = 1000;
            while (teams != 0 && tables != 0) {
                teams = source.nextInt();
                tables = source.nextInt();
                if (teams != 0 && tables != 0) {
                    LinkedList<Integer> teamList = new LinkedList<>();
                    for (int i = 0; i < teams; i++) {
                        teamList.add(source.nextInt());
                    }
                    LinkedList<Integer> tableList = new LinkedList<>();
                    for (int i = 0; i < tables; i++) {
                        tableList.add(source.nextInt());
                    }
                    graph = setGraph(teamList, tableList);
                    if (teamList.stream().mapToInt(Integer::intValue).sum() <= tableList.stream().mapToInt(Integer::intValue).sum()) {
                        fordFulkerson(teamList, tableList, graph);
                    } else {
                        System.out.println("0");
                    }
                    teamList.clear();
                    tableList.clear();
                    graph.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
