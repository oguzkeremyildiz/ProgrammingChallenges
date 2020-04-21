package Backtracking.B4;/* Created by oguzkeremyildiz on 9.04.2020 */

import Graph.Graph;

import java.io.File;
import java.util.*;

public class ServicingStations {
    private static int size;
    private static void constructCandidates(HashMap<Integer, LinkedList<Integer>> subsets, Graph<Integer> graph, HashMap<Integer, LinkedList<Integer>> sequence) {
        for (Integer key : graph.getKeySet()) {
            if (!sequence.containsKey(key)) {
                subsets.put(key, graph.get(key));
            }
        }
    }
    private static void backtrack(Graph<Integer> graph, HashMap<Integer, LinkedList<Integer>> sequence) {
        if (size < sequence.size()){
            return;
        }
        HashMap<Integer, LinkedList<Integer>> subsets = new HashMap<>();
        if (isASolution(graph, sequence)){
            size = sequence.size();
        } else {
            constructCandidates(subsets, graph, sequence);
            for (Integer key : subsets.keySet()){
                sequence.put(key, subsets.get(key));
                backtrack(graph, sequence);
                sequence.remove(key);
            }
        }
    }
    private static boolean isASolution(Graph<Integer> graph, HashMap<Integer, LinkedList<Integer>> sequence) {
        HashSet<Integer> subsetsValues = new HashSet<>();
        for (Integer key : sequence.keySet()) {
            subsetsValues.addAll(sequence.get(key));
        }
        return subsetsValues.containsAll(graph.getKeySet());
    }


    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Service.txt"));
            Graph<Integer> graph = new Graph<Integer>();
            LinkedList<Graph<Integer>> graphs;
            size = 10000;
            int key;
            int value;
            while (source.hasNext()){
                int graphSize = source.nextInt();
                int times = source.nextInt();
                for (int i = 0; i < times; i++) {
                    key = source.nextInt() - 1;
                    value = source.nextInt() - 1;
                    graph.addUndirectedEdge(key, value);
                }
                graphs = graph.connectedComponents();
                for (Graph<Integer> integerLinkedListHashMap : graphs) {
                    backtrack(integerLinkedListHashMap, new HashMap<>());
                    System.out.println(size);
                    graph.clear();
                    size = 10000;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
