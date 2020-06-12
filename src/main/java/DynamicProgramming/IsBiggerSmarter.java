package DynamicProgramming;/* Created by oguzkeremyildiz on 11.06.2020 */

import Cookies.Graph.Graph;
import Cookies.Tuple.Pair;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class IsBiggerSmarter {
    private static LinkedList<Elephant> currentBest;
    private static void print(LinkedList<Elephant> longest) {
        System.out.println(longest.size());
        for (Elephant elephant : longest) {
            System.out.println(elephant.getNo());
        }
    }
    private static void sort(LinkedList<Elephant> elephantList) {
        LinkedList<Elephant> removeList = new LinkedList<>();
        for (int i = 0; i < elephantList.size(); i++) {
            for (int j = 0; j < elephantList.size(); j++) {
                if (i != j) {
                    if (elephantList.get(i).getWeight() < elephantList.get(j).getWeight()) {
                        Elephant temporary = elephantList.get(i);
                        elephantList.set(i, elephantList.get(j));
                        elephantList.set(j, temporary);
                    } else if (elephantList.get(i).getWeight() == elephantList.get(j).getWeight()) {
                        if (elephantList.get(i).getIq() > elephantList.get(j).getIq()) {
                            removeList.add(elephantList.get(j));
                            Elephant temporary = elephantList.get(i);
                            elephantList.set(i, elephantList.get(j));
                            elephantList.set(j, temporary);
                        }
                    }
                }
            }
        }
        elephantList.removeAll(removeList);
    }
    private static void depthFirstSearch(Graph<Elephant> graph, HashSet<Elephant> traveled, Elephant current, LinkedList<Elephant> sequence) {
        for (int i = 0; i < graph.get(current).size(); i++) {
            if (!traveled.contains(graph.get(current, i)) && graph.containsKey(graph.get(current, i))) {
                LinkedList<Elephant> oldSequence = (LinkedList<Elephant>) sequence.clone();
                HashSet<Elephant> oldTraveled = (HashSet<Elephant>) traveled.clone();
                traveled.add(graph.get(current, i));
                sequence.add(graph.get(current, i));
                depthFirstSearch(graph, traveled, graph.get(current, i), sequence);
                if (currentBest.size() < sequence.size()) {
                    currentBest = (LinkedList<Elephant>) sequence.clone();
                }
                sequence = oldSequence;
                traveled = oldTraveled;
            } else if (!traveled.contains(graph.get(current, i)) && !graph.containsKey(graph.get(current, i))) {
                sequence.add(graph.get(current, i));
                if (currentBest.size() < sequence.size()) {
                    currentBest = (LinkedList<Elephant>) sequence.clone();
                }
                sequence.removeLast();
            }
        }
    }
    private static Graph<Elephant> setGraph(LinkedList<Elephant> list) {
        Graph<Elephant> graph = new Graph<>();
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size()) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j).getIq() < list.get(i).getIq()) {
                        graph.addDirectedEdge(list.get(i), list.get(j));
                    }
                }
            }
        }
        return graph;
    }
    private static LinkedList<Elephant> longestDecreasingSequence(LinkedList<Elephant> list) {
        LinkedList<Elephant> longest = new LinkedList<>();
        Graph<Elephant> graph = setGraph(list);
        for (Elephant node : graph.getKeySet()) {
            HashSet<Elephant> traveled = new HashSet<>();
            traveled.add(node);
            LinkedList<Elephant> sequence = new LinkedList<>();
            sequence.add(node);
            currentBest = new LinkedList<>();
            depthFirstSearch(graph, traveled, node, sequence);
            if (longest.size() < currentBest.size()) {
                longest = currentBest;
            }
        }
        return longest;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Smart.txt"));
            LinkedList<Elephant> elephantList = new LinkedList<>();
            int iterator = 0;
            while (source.hasNext()) {
                iterator++;
                elephantList.add(new Elephant(source.nextInt(), source.nextInt(), iterator));
            }
            sort(elephantList);
            LinkedList<Elephant> longest = longestDecreasingSequence(elephantList);
            print(longest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
