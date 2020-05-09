package GraphTraversal.G5;/* Created by oguzkeremyildiz on 8.05.2020 */

import Graph.Graph;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class EditStepLadders {
    private static LinkedList<String> ladder;
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
            size = 0;
            if (current.charAt(0) != compared.charAt(0)) {
                for (int i = 0; i < compared.length(); i++) {
                    if (compared.charAt(i) == current.charAt(1 + i)) {
                        size++;
                    }
                }
                return compared.length() == size;
            } else if (current.charAt(current.length() - 1) != compared.charAt(compared.length() - 1)) {
                for (int i = 0; i < compared.length(); i++) {
                    if (compared.charAt(i) == current.charAt(i)) {
                        size++;
                    }
                }
                return compared.length() == size;
            }
        } else if (current.length() + 1 == compared.length()) {
            size = 0;
            if (current.charAt(0) != compared.charAt(0)) {
                for (int i = 0; i < current.length(); i++) {
                    if (compared.charAt(1 + i) == current.charAt(i)) {
                        size++;
                    }
                }
                return current.length() == size;
            } else if (current.charAt(current.length() - 1) != compared.charAt(compared.length() - 1)) {
                for (int i = 0; i < current.length(); i++) {
                    if (compared.charAt(i) == current.charAt(i)) {
                        size++;
                    }
                }
                return current.length() == size;
            }
        }
        return false;
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
    private static boolean suitable(LinkedList<Integer> list, String current, String visited) {
        if (list.size() == 0) {
            if (visited.length() == current.length()) {
                for (int i = 0; i < visited.length(); i++) {
                    if (visited.charAt(i) != current.charAt(i)) {
                        list.add(i);
                        return true;
                    }
                }
            }
            return true;
        } else {
            if (visited.length() == current.length()) {
                for (int i = 0; i < visited.length(); i++) {
                    if (visited.charAt(i) != current.charAt(i)) {
                        if (!list.getLast().equals(i)) {
                            list.add(i);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    private static int depthFirstSearch(Graph<String> graph, String current, LinkedList<String> visited, LinkedList<Integer> list) {
        for (int i = 0; i < graph.get(current).size(); i++) {
            if (!visited.contains(graph.get(current, i))) {
                if (visited.size() > 0) {
                    if (suitable(list, graph.get(current, i), visited.getLast())) {
                        visited.add(current);
                        depthFirstSearch(graph, graph.get(current).get(i), visited, list);
                        if (ladder.size() < visited.size()) {
                            ladder.clear();
                            ladder.addAll(visited);
                        }
                        visited.removeLast();
                    }
                } else {
                    visited.add(current);
                    depthFirstSearch(graph, graph.get(current).get(i), visited, list);
                    if (ladder.size() < visited.size()) {
                        ladder.clear();
                        ladder.addAll(visited);
                    }
                    visited.removeLast();
                }
            }
        }
        return ladder.size();
    }
    public static void main(String[]args) {
        try {
            LinkedList<String> list = new LinkedList<>();
            LinkedList<String> visited = new LinkedList<>();
            int best = 0;
            Graph<String> graph;
            Scanner source = new Scanner(new File("Ladders.txt"));
            while (source.hasNext()) {
                list.add(source.next());
            }
            graph = addEdge(list);
            for (String key : graph.getKeySet()) {
                ladder = new LinkedList<>();
                int current = depthFirstSearch(graph, key, visited, new LinkedList<>());
                if (current > best) {
                    best = current;
                }
                visited.clear();
            }
            System.out.println(best);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
