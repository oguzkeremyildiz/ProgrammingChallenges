package Backtracking.B4;/* Created by oguzkeremyildiz on 9.04.2020 */

import java.io.File;
import java.util.*;

public class ServicingStations {
    private static int size;
    private static void constructCandidates(HashMap<Integer, LinkedList<Integer>> subsets, HashMap<Integer, LinkedList<Integer>> graph, HashMap<Integer, LinkedList<Integer>> sequence) {
        for (Integer key : graph.keySet()) {
            if (!sequence.containsKey(key)) {
                subsets.put(key, graph.get(key));
            }
        }
    }
    private static void backtrack(HashMap<Integer, LinkedList<Integer>> graph, HashSet<Integer> values, HashMap<Integer, LinkedList<Integer>> sequence) {
        if (size < sequence.size()){
            return;
        }
        HashMap<Integer, LinkedList<Integer>> subsets = new HashMap<>();
        if (isASolution(values, sequence)){
            size = sequence.size();
        } else {
            constructCandidates(subsets, graph, sequence);
            for (Integer key : subsets.keySet()){
                sequence.put(key, subsets.get(key));
                backtrack(graph, values, sequence);
                sequence.remove(key);
            }
        }
    }
    private static boolean isASolution(HashSet<Integer> values, HashMap<Integer, LinkedList<Integer>> sequence) {
        HashSet<Integer> subsetsValues = new HashSet<>();
        for (Integer key : sequence.keySet()) {
            subsetsValues.addAll(sequence.get(key));
        }
        return subsetsValues.containsAll(values);
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Service.txt"));
            HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
            HashSet<Integer> values = new HashSet<>();
            size = 10000;
            int key;
            int value;
            while (source.hasNext()){
                int graphSize = source.nextInt();
                int times = source.nextInt();
                for (int i = 0; i < times; i++) {
                    key = source.nextInt();
                    value = source.nextInt();
                    if (!graph.containsKey(key)){
                        graph.put(key, new LinkedList<>());
                        graph.get(key).addFirst(value);
                        values.add(key);
                    } else {
                        graph.get(key).add(value);
                        values.add(key);
                    }
                    if (!graph.containsKey(value)){
                        graph.put(value, new LinkedList<>());
                        graph.get(value).addFirst(key);
                        values.add(value);
                    } else {
                        graph.get(value).add(key);
                        values.add(value);
                    }
                }
                backtrack(graph, values, new HashMap<>());
                System.out.println(size);
                graph.clear();
                values.clear();
                size = 10000;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
