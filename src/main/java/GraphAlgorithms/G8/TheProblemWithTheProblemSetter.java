package GraphAlgorithms.G8;/* Created by oguzkeremyildiz on 8.06.2020 */

import Cookies.Graph.IntegerLength;
import Cookies.Graph.ResidualEdge;
import Cookies.Graph.WeightedGraph;

import java.io.File;
import java.util.*;

public class TheProblemWithTheProblemSetter {
    private static boolean isASolution(HashMap<String, LinkedList<Problem>> map, LinkedList<Integer> size) {
        int totalElement = 0;
        for (String key : map.keySet()) {
            totalElement += map.get(key).size();
        }
        return totalElement == size.stream().mapToInt(Integer::intValue).sum();
    }
    private static LinkedHashMap<String, String> breadthFirstSearch(WeightedGraph<String, Integer> graph, String source) {
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
                        if (!set.contains(graph.get(current).get(j).getKey()) && ((ResidualEdge<Integer>) graph.get(current).get(j).getValue()).getResidual() > 0) {
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
    private static void print(HashMap<String, LinkedList<Problem>> map, LinkedList<Integer> boundary) {
        for (int i = 0; i < boundary.size(); i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < map.get("category" + (i + 1)).size(); j++) {
                list.add(map.get("category" + (i + 1)).get(j).getNo());
            }
            System.out.println(list);
        }
    }
    private static void fordFulkerson(WeightedGraph<String, Integer> graph, LinkedList<Problem> list, LinkedList<Integer> boundary) {
        String source = "s";
        String sink = "t";
        HashMap<String, LinkedList<Problem>> used = new HashMap<>();
        HashSet<Problem> allUsed = new HashSet<>();
        HashMap<String, LinkedList<Problem>> map = new HashMap<>();
        for (int i = 0; i < boundary.size(); i++) {
            map.put("category" + (i + 1), new LinkedList<>());
            used.put("category" + (i + 1), new LinkedList<>());
        }
        LinkedHashMap<String, String> previousMap;
        LinkedList<String> path = new LinkedList<>();
        do {
            path.clear();
            previousMap = breadthFirstSearch(graph, source);
            if (previousMap.containsKey(sink) && previousMap.containsValue(source)) {
                String current = sink;
                path.add(sink);
                while (!path.contains(source)) {
                    path.add(previousMap.get(current));
                    current = previousMap.get(current);
                }
                setGraphAndMap(graph, map, path, used, list);
                for (String key : used.keySet()) {
                    allUsed.addAll(used.get(key));
                }
                if (allUsed.size() == list.size()) {
                    break;
                }
            }
        } while (path.contains(source));
        if (isASolution(map, boundary)) {
            System.out.println("1");
            print(map, boundary);
        } else {
            System.out.println("0");
        }
    }
    private static boolean check(WeightedGraph<String, Integer> graph, LinkedList<String> path, int now, Problem problem) {
        int total = problem.find(now);
        for (int j = 0; j < graph.get(path.get(3)).size(); j++) {
            String current = graph.get(path.get(3), j).getKey();
            if (current.equals(path.get(2))) {
                if (((ResidualEdge<Integer>) graph.get(path.get(3), j).getValue()).getFlow() + total <= graph.get(path.get(3), j).getValue().getLength()) {
                    for (int i = 0; i < graph.get(path.get(1)).size(); i++) {
                        if (graph.get(path.get(1), i).getKey().equals(path.get(0))) {
                            return ((ResidualEdge<Integer>) graph.get(path.get(1), i).getValue()).getFlow() + total <= graph.get(path.get(1), i).getValue().getLength();
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    private static void setGraphAndMap(WeightedGraph<String, Integer> graph, HashMap<String, LinkedList<Problem>> map, LinkedList<String> path, HashMap<String, LinkedList<Problem>> used, LinkedList<Problem> list) {
        LinkedList<Problem> currentList = (LinkedList<Problem>) list.clone();
        for (String key : used.keySet()) {
            currentList.removeAll(used.get(key));
        }
        boolean check = false;
        for (Problem problem : currentList) {
            if (problem.contains(Integer.parseInt(path.get(1).substring(8))) && check(graph, path, Integer.parseInt(path.get(1).substring(8)), problem)) {
                int total = problem.find(Integer.parseInt(path.get(1).substring(8)));
                used.get(path.get(1)).add(problem);
                map.get(path.get(1)).add(problem);
                check = true;
                for (int j = 0; j < graph.get(path.get(3)).size(); j++) {
                    String current = graph.get(path.get(3), j).getKey();
                    if (current.equals(path.get(2))) {
                        ((ResidualEdge<Integer>) graph.get(path.get(3), j).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(path.get(3), j).getValue()).getFlow() + total);
                        for (int k = 0; k < graph.get(path.get(2)).size(); k++) {
                            if (graph.get(path.get(2), k).getKey().equals(path.get(3))) {
                                ((ResidualEdge<Integer>) graph.get(path.get(2), k).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(path.get(2), k).getValue()).getFlow() - total);
                                break;
                            }
                        }
                        break;
                    }
                }
                for (int j = 0; j < graph.get(path.get(1)).size(); j++) {
                    String current = graph.get(path.get(1), j).getKey();
                    if (current.equals(path.get(0))) {
                        ((ResidualEdge<Integer>) graph.get(path.get(1), j).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(path.get(1), j).getValue()).getFlow() + total);
                        for (int k = 0; k < graph.get(path.get(0)).size(); k++) {
                            if (graph.get(path.get(0), k).getKey().equals(path.get(1))) {
                                ((ResidualEdge<Integer>) graph.get(path.get(0), k).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(path.get(0), k).getValue()).getFlow() - total);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        if (!check) {
            for (String key : map.keySet()) {
                if (!key.equals(path.get(1))) {
                    for (int i = 0; i < map.get(key).size(); i++) {
                        if (map.get(key).get(i).contains(Integer.parseInt(path.get(1).substring(8))) && !used.get(path.get(1)).contains(map.get(key).get(i))) {
                            int total = map.get(key).get(i).find(Integer.parseInt(path.get(1).substring(8)));
                            used.get(path.get(1)).add(map.get(key).get(i));
                            map.get(path.get(1)).add(map.get(key).get(i));
                            map.get(key).remove(i);
                            for (int j = 0; j < graph.get(path.get(3)).size(); j++) {
                                String current = graph.get(path.get(3), j).getKey();
                                if (current.equals(path.get(2))) {
                                    ((ResidualEdge<Integer>) graph.get(path.get(3), j).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(path.get(3), j).getValue()).getFlow() + total);
                                    for (int k = 0; k < graph.get(path.get(2)).size(); k++) {
                                        if (graph.get(path.get(2), k).getKey().equals(path.get(3))) {
                                            ((ResidualEdge<Integer>) graph.get(path.get(2), k).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(path.get(2), k).getValue()).getFlow() - total);
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            for (int j = 0; j < graph.get(path.get(1)).size(); j++) {
                                String current = graph.get(path.get(1), j).getKey();
                                if (current.equals(path.get(0))) {
                                    ((ResidualEdge<Integer>) graph.get(path.get(1), j).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(path.get(1), j).getValue()).getFlow() + total);
                                    for (int k = 0; k < graph.get(path.get(0)).size(); k++) {
                                        if (graph.get(path.get(0), k).getKey().equals(path.get(1))) {
                                            ((ResidualEdge<Integer>) graph.get(path.get(0), k).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(path.get(0), k).getValue()).getFlow() - total);
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            LinkedList<String> anotherPath = (LinkedList<String>) path.clone();
                            anotherPath.set(1, key);
                            for (int j = 0; j < graph.get(anotherPath.get(3)).size(); j++) {
                                String current = graph.get(anotherPath.get(3), j).getKey();
                                if (current.equals(anotherPath.get(2))) {
                                    ((ResidualEdge<Integer>) graph.get(anotherPath.get(3), j).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(anotherPath.get(3), j).getValue()).getFlow() - total);
                                    for (int k = 0; k < graph.get(anotherPath.get(2)).size(); k++) {
                                        if (graph.get(anotherPath.get(2), k).getKey().equals(anotherPath.get(3))) {
                                            ((ResidualEdge<Integer>) graph.get(anotherPath.get(2), k).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(anotherPath.get(2), k).getValue()).getFlow() + total);
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            for (int j = 0; j < graph.get(anotherPath.get(1)).size(); j++) {
                                String current = graph.get(anotherPath.get(1), j).getKey();
                                if (current.equals(anotherPath.get(0))) {
                                    ((ResidualEdge<Integer>) graph.get(anotherPath.get(1), j).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(anotherPath.get(1), j).getValue()).getFlow() - total);
                                    for (int k = 0; k < graph.get(anotherPath.get(0)).size(); k++) {
                                        if (graph.get(anotherPath.get(0), k).getKey().equals(anotherPath.get(1))) {
                                            ((ResidualEdge<Integer>) graph.get(anotherPath.get(0), k).getValue()).setFlow(((ResidualEdge<Integer>) graph.get(anotherPath.get(0), k).getValue()).getFlow() + total);
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    private static WeightedGraph<String, Integer> setGraph(LinkedList<Problem> list, LinkedList<Integer> boundary) {
        WeightedGraph<String, Integer> graph = new WeightedGraph<>(new IntegerLength());
        String source = "s";
        String sink = "t";
        graph.addUndirectedEdge(source, "problems", new ResidualEdge<>(list.size(), 0, new IntegerLength()), new ResidualEdge<>(list.size(), new IntegerLength()));
        for (int i = 0; i < boundary.size(); i++) {
            graph.addUndirectedEdge("problems", "category" + (i + 1), new ResidualEdge<>(boundary.get(i), 0, new IntegerLength()), new ResidualEdge<>(boundary.get(i), new IntegerLength()));
        }
        for (int i = 0; i < boundary.size(); i++) {
            graph.addUndirectedEdge("category" + (i + 1), sink, new ResidualEdge<>(boundary.get(i), 0, new IntegerLength()), new ResidualEdge<>(boundary.get(i), new IntegerLength()));
        }
        return graph;
    }
    private static boolean suitable(LinkedList<Problem> problems, LinkedList<Integer> boundary) {
        for (int i = 0; i < boundary.size(); i++) {
            int total = 0;
            for (Problem problem : problems) {
                total += problem.find((i + 1));
            }
            if (total < boundary.get(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("ProblemSetter.txt"));
            while (true) {
                int categories = source.nextInt();
                int problems = source.nextInt();
                LinkedList<Problem> list = new LinkedList<>();
                LinkedList<Integer> boundary = new LinkedList<>();
                WeightedGraph<String, Integer> graph;
                if (categories != 0 && problems != 0) {
                    for (int i = 0; i < categories; i++) {
                        boundary.add(source.nextInt());
                    }
                    for (int i = 0; i < problems; i++) {
                        int category = source.nextInt();
                        list.add(new Problem((i + 1), category));
                        for (int j = 0; j < category; j++) {
                            list.getLast().addCategory(source.nextInt());
                        }
                    }
                    graph = setGraph(list, boundary);
                    if (suitable(list, boundary)) {
                        fordFulkerson(graph, list, boundary);
                    } else {
                        System.out.println("0");
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
