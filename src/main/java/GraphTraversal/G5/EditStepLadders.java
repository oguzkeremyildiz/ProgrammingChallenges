package GraphTraversal.G5;/* Created by oguzkeremyildiz on 8.05.2020 */

import Graph.Graph;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class EditStepLadders {
    private static int iterate;
    private static boolean isSuitable(String current, String compared) {
        int size;
        if (current.length() == compared.length()) {
            size = 0;
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == compared.charAt(i)) {
                    size++;
                }
            }
            return size == current.length() - 1;
        } else if (current.length() == compared.length() + 1) {
            if (current.charAt(0) != compared.charAt(0)) {
                for (int i = 0; i < compared.length(); i++) {
                    if (compared.charAt(i) != current.charAt(1 + i)) {
                        return false;
                    }
                }
            } else if (current.charAt(current.length() - 1) != compared.charAt(compared.length() - 1)) {
                for (int i = 0; i < compared.length(); i++) {
                    if (compared.charAt(i) != current.charAt(i)) {
                        return false;
                    }
                }
            }
        } else if (current.length() + 1 == compared.length()) {
            if (current.charAt(0) != compared.charAt(0)) {
                for (int i = 0; i < current.length(); i++) {
                    if (compared.charAt(1 + i) != current.charAt(i)) {
                        return false;
                    }
                }
            } else if (current.charAt(current.length() - 1) != compared.charAt(compared.length() - 1)) {
                for (int i = 0; i < current.length(); i++) {
                    if (compared.charAt(i) != current.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private static Graph<String> addEdge(LinkedList<String> list) {
        Graph<String> graph = new Graph<String>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (isSuitable(list.get(i), list.get(j))) {
                    if (!graph.containsKey(list.get(j))) {
                        graph.put(list.get(j), new LinkedList<>());
                    }
                    if (!graph.containsKey(list.get(i))) {
                        graph.put(list.get(i), new LinkedList<>());
                    }
                    graph.addUndirectedEdge(list.get(i), list.get(j));
                }
            }
        }
        return graph;
    }
    private static int breadthFirstSearch(Graph<String> graph, HashMap<Integer, LinkedList<String>> map, HashSet<String> visited) {
        iterate++;
        map.put(iterate, new LinkedList<>());
        for (int i = 0; i < map.get(iterate - 1).size(); i++) {
            for (int j = 0; j < graph.get(map.get(iterate - 1).get(i)).size(); j++) {
                if (!visited.contains(graph.get(map.get(iterate - 1).get(i)).get(j))) {
                    map.get(iterate).add(graph.get(map.get(iterate - 1).get(i)).get(j));
                    visited.add(graph.get(map.get(iterate - 1).get(i)).get(j));
                }
            }
        }
        if (map.get(iterate).size() > 0) {
            breadthFirstSearch(graph, map, visited);
        }
        return map.size() - 1;
    }
    public static void main(String[]args) {
        try {
            LinkedList<String> list = new LinkedList<>();
            HashMap<Integer, LinkedList<String>> map = new HashMap<>();
            int best = 0;
            Graph<String> graph;
            Scanner source = new Scanner(new File("Ladders.txt"));
            while (source.hasNext()) {
                list.add(source.next());
            }
            graph = addEdge(list);
            for (String key : graph.getKeySet()) {
                iterate = 0;
                map.put(iterate, graph.get(key));
                if (breadthFirstSearch(graph, map, new HashSet<>()) > best) {
                    best = breadthFirstSearch(graph, map, new HashSet<>());
                }
            }
            System.out.println(best);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
