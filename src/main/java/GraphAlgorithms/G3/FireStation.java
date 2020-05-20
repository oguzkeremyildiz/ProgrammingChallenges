package GraphAlgorithms.G3;/* Created by oguzkeremyildiz on 20.05.2020 */

import Cookies.Graph.IntegerLength;
import Cookies.Graph.WeightedGraph;
import Cookies.Tuple.Pair;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class FireStation {
    private static HashMap<Integer, Integer> reverse(HashMap<Integer, Integer> map) {
        HashMap<Integer, Integer> reversed = new HashMap<>();
        for (Integer key : map.keySet()) {
            reversed.put(map.get(key), key);
        }
        return reversed;
    }
    private static int findSmallest(WeightedGraph<Integer, Integer> graph, int[] stations, HashSet<Integer> set) {
        HashMap<Integer, Integer> values = new HashMap<>();
        Pair<HashMap<Integer, Integer>, LinkedList<LinkedList<Integer>>> pair = graph.floydWarshallWithKeys();
        HashMap<Integer, Integer> reversed = reverse(pair.getKey());
        for (Integer key : pair.getKey().keySet()) {
            int current = 0;
            if (!set.contains(pair.getKey().get(key))) {
                for (int j = 0; j < graph.size(); j++) {
                    int now = pair.getValue().get(key).get(j);
                    for (int station : stations) {
                        if (pair.getValue().get(reversed.get(station)).get(j) < now) {
                            now = pair.getValue().get(reversed.get(station)).get(j);
                        }
                    }
                    if (now > current) {
                        current = now;
                    }
                }
                values.put(pair.getKey().get(key), current);
            }
        }
        if (values.size() == 0) {
            return 1;
        }
        int returning = 0;
        int best = Integer.MAX_VALUE;
        for (Integer key : values.keySet()) {
            if (best > values.get(key)) {
                best = values.get(key);
                returning = key;
            }
        }
        return returning;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Station.txt"));
            HashSet<Integer> set = new HashSet<>();
            WeightedGraph<Integer, Integer> graph = new WeightedGraph<>(new IntegerLength());
            int[] stations;
            int times = source.nextInt();
            for (int i = 0; i < times; i++) {
                int stationNumber = source.nextInt();
                stations = new int[stationNumber];
                int buildNumber = source.nextInt();
                for (int j = 0; j < stationNumber; j++) {
                    stations[j] = source.nextInt();
                    set.add(stations[j]);
                }
                for (int j = 0; j < buildNumber; j++) {
                    graph.addUndirectedEdge(source.nextInt(), source.nextInt(), source.nextInt());
                }
                System.out.println(findSmallest(graph, stations, set));
                graph.clear();
                set.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
