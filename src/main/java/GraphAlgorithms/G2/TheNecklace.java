package GraphAlgorithms.G2;/* Created by oguzkeremyildiz on 19.05.2020 */

import Cookies.Graph.Graph;
import Cookies.Tuple.Pair;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class TheNecklace {
    private static boolean finished;
    private static Graph<Node> addEdges(LinkedList<Node> nodes) {
        Graph<Node> graph = new Graph<>();
        for (Node node : nodes) {
            graph.put(node, new LinkedList<>());
            for (Node key : graph.getKeySet()) {
                if (!key.equals(node)) {
                    if (key.getPair().getKey().equals(node.getPair().getKey()) || key.getPair().getKey().equals(node.getPair().getValue()) || key.getPair().getValue().equals(node.getPair().getKey()) || key.getPair().getValue().equals(node.getPair().getValue())) {
                        graph.addUndirectedEdge(key, node);
                    }
                }
            }
        }
        return graph;
    }
    private static void depthFirstSearch(Graph<Node> graph, Node current, LinkedList<Node> visited, Node start) {
        if (finished) {
            return;
        }
        for (int i = 0; i < graph.get(current).size(); i++) {
            if (!visited.contains(graph.get(current, i)) && graph.containsKey(graph.get(current, i))) {
                visited.add(graph.get(current, i));
                if (visited.size() == graph.size() && graph.get(current, i).equals(start)) {
                    System.out.println(visited);
                    finished = true;
                } else {
                    depthFirstSearch(graph, graph.get(current, i), visited, start);
                    visited.remove(graph.get(current, i));
                }
            } else {
                if (visited.size() == graph.size() && graph.get(current, i).equals(start)) {
                    System.out.println(visited);
                    finished = true;
                }
            }
        }
    }
    private static void find(Graph<Node> graph, Node node) {
        LinkedList<Node> visited = new LinkedList<>();
        visited.add(node);
        depthFirstSearch(graph, node, visited, node);
        if (!finished) {
            System.out.println("some beads may be lost");
        }
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Necklace.txt"));
            LinkedList<Node> nodes = new LinkedList<>();
            Graph<Node> graph;
            int times = source.nextInt();
            for (int i = 0; i < times; i++) {
                finished = false;
                int size = source.nextInt();
                for (int j = 0; j < size; j++) {
                    nodes.add(new Node(j, new Pair<>(source.nextInt(), source.nextInt())));
                }
                graph = addEdges(nodes);
                System.out.println("Case #" + (i + 1));
                find(graph, nodes.getFirst());
                graph.clear();
                nodes.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
