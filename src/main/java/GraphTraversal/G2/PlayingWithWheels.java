package GraphTraversal.G2;/* Created by oguzkeremyildiz on 25.04.2020 */

import Graph.Graph;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class PlayingWithWheels {
    private static HashSet<Integer> edgeList;
    private static boolean find;
    private static int iterate;
    private static int incrementDigit(int digit, int number) {
        int currentDigit = digit(digit, number);
        switch (digit) {
            case 0:
                if (currentDigit == 9) {
                    return number - 9;
                } else {
                    return number + 1;
                }
            case 1:
                if (currentDigit == 9) {
                    return number - 90;
                } else {
                    return number + 10;
                }
            case 2:
                if (currentDigit == 9) {
                    return number - 900;
                } else {
                    return number + 100;
                }
            case 3:
                if (currentDigit == 9) {
                    return number - 9000;
                } else {
                    return number + 1000;
                }
        }
        return -1;
    }

    private static int decrementDigit(int digit, int number) {
        int currentDigit = digit(digit, number);
        switch (digit) {
            case 0:
                if (currentDigit == 0) {
                    return number + 9;
                } else {
                    return number - 1;
                }
            case 1:
                if (currentDigit == 0) {
                    return number + 90;
                } else {
                    return number - 10;
                }
            case 2:
                if (currentDigit == 0) {
                    return number + 900;
                } else {
                    return number - 100;
                }
            case 3:
                if (currentDigit == 0) {
                    return number + 9000;
                } else {
                    return number - 1000;
                }
        }
        return -1;
    }

    private static int digit(int digit, int number) {
        switch (digit) {
            case 0:
                return number % 10;
            case 1:
                return (number / 10) % 10;
            case 2:
                return (number / 100) % 10;
            case 3:
                return (number / 1000) % 10;
        }
        return -1;
    }

    private static boolean constructCandidates(Graph<Integer> graph, int target) {
        boolean check = false;
        int candidateOne;
        int candidateTwo;
        for (int i = 0; i < graph.get(iterate - 1).size(); i++) {
            for (int j = 0; j < 4; j++) {
                candidateOne = incrementDigit(j, graph.get(iterate - 1).get(i));
                if (!edgeList.contains(candidateOne)) {
                    graph.addDirectedEdge(iterate, candidateOne);
                    edgeList.add(candidateOne);
                    if (target == candidateOne) {
                        System.out.println(candidateOne + " " + iterate);
                        find = false;
                        check = false;
                        break;
                    } else {
                        check = true;
                    }
                }
                candidateTwo = decrementDigit(j, graph.get(iterate - 1).get(i));
                if (!edgeList.contains(candidateTwo)) {
                    graph.addDirectedEdge(iterate, candidateTwo);
                    edgeList.add(candidateTwo);
                    if (target == candidateTwo) {
                        System.out.println(candidateTwo + " " + iterate);
                        find = false;
                        check = false;
                        break;
                    } else {
                        check = true;
                    }
                }
            }
        }
        return check;
    }

    private static void addEdge(Graph<Integer> graph, int target) {
        iterate++;
        graph.put(iterate, new LinkedList<>());
        boolean check = true;
        while (check) {
            check = constructCandidates(graph, target);
            if (check) {
                iterate++;
                graph.put(iterate, new LinkedList<>());
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner source = new Scanner(new File("Wheels.txt"));
            int times = source.nextInt();
            int currentWheel;
            int current;
            edgeList = new HashSet<>();
            Graph<Integer> graph = new Graph<Integer>();
            for (int i = 0; i < times; i++) {
                find = true;
                iterate = 0;
                currentWheel = source.nextInt();
                graph.put(0, new LinkedList<>());
                graph.addDirectedEdge(0, currentWheel);
                int target = source.nextInt();
                current = source.nextInt();
                edgeList.add(graph.get(0).getFirst());
                for (int j = 0; j < current; j++) {
                    edgeList.add(source.nextInt());
                }
                addEdge(graph, target);
                if (find) {
                    System.out.println(-1);
                }
                graph.clear();
                edgeList.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
