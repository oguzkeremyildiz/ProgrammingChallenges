package GraphTraversal.G4;/* Created by oguzkeremyildiz on 1.05.2020 */

import Cookies.Graph.Graph;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class SlashMaze {
    private static HashSet<HashSet<Integer>> founded;
    private static Graph<Integer> addEdge(String[][] maze, int[] squares, HashSet<Integer> set) {
        int current = 0;
        boolean bool = true;
        Graph<Integer> graph = new Graph<Integer>();
        for (int i = 0; i < squares.length; i++) {
            graph.put(i + 1, new LinkedList<>());
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (!set.contains(squares[current])) {
                    if (i + 1 < maze.length) {
                        i++;
                        j = 0;
                    } else {
                        bool = false;
                        break;
                    }
                }
                while (!set.contains(squares[current])) {
                    current++;
                    if (current == squares.length) {
                        bool = false;
                        break;
                    }
                }
                if (bool) {
                    if (set.contains(squares[current])) {
                        if (maze[i][j].equals("/")) {
                            if (j + 1 < maze[0].length) {
                                if (maze[i][j + 1].equals("/")) {
                                    if (current + maze[0].length - 1 < squares.length) {
                                        graph.addUndirectedEdge(squares[current], squares[current + maze[0].length - 1]);
                                    }
                                    if (current - maze[0].length + 1 > 0) {
                                        graph.addUndirectedEdge(squares[current], squares[current - maze[0].length + 1]);
                                    }
                                } else if (current + maze[0].length - 1 < squares.length) {
                                    graph.addUndirectedEdge(squares[current], squares[current + maze[0].length - 1]);
                                    if (current + maze[0].length < squares.length) {
                                        graph.addUndirectedEdge(squares[current], squares[current + maze[0].length]);
                                    }
                                }
                            }
                        } else {
                            if (j + 1 < maze[0].length) {
                                if (!maze[i][j + 1].equals("/")) {
                                    if (current + maze[0].length < squares.length) {
                                        graph.addUndirectedEdge(squares[current], squares[current + maze[0].length]);
                                    }
                                } else {
                                    if (current - maze[0].length + 1 > 0) {
                                        graph.addUndirectedEdge(squares[current], squares[current - maze[0].length + 1]);
                                    }
                                }
                            }
                            if (current - maze[0].length > 0) {
                                graph.addUndirectedEdge(squares[current], squares[current - maze[0].length]);
                            }
                        }
                    }
                    if (current + 1 != squares.length) {
                        current++;
                    } else {
                        bool = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!bool) {
                break;
            }
        }
        return graph;
    }
    private static LinkedList<Integer> find(Graph<Integer> graph) {
        LinkedList<Integer> circulars = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 1; i <= graph.size(); i++) {
            visited.add(i);
            circulars.addAll(breadthFirstSearch(graph, i, visited, 0, i, new LinkedList<>()));
            visited.clear();
        }
        return circulars;
    }
    private static LinkedList<Integer> breadthFirstSearch(Graph<Integer> graph, int current, HashSet<Integer> visited, int iterate, int target, LinkedList<Integer> list) {
        for (int i = 0; i < graph.get(current).size(); i++) {
            HashSet<Integer> elements = new HashSet<>(graph.get(current));
            if (elements.contains(target) && iterate > 2) {
                if (!founded.contains(visited)) {
                    list.add(visited.size());
                    founded.add(visited);
                    return list;
                }
            }
            if (!visited.contains(graph.get(current).get(i))) {
                visited.add(graph.get(current).get(i));
                iterate++;
                breadthFirstSearch(graph, graph.get(current).get(i), visited, iterate, target, list);
                iterate--;
            }
        }
        return list;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Maze.txt"));
            Graph<Integer> graph;
            HashSet<Integer> set = new HashSet<>();
            founded = new HashSet<>();
            LinkedList<Integer> connectedGraphs;
            int current = 1;
            while (source.hasNext()) {
                String[][] maze;
                int row = source.nextInt();
                int column = source.nextInt();
                int total = 0;
                int added = 0;
                for (int i = 0; i < (column * 2) - 1; i++) {
                    if (i % 2 == 0) {
                        for (int j = 0; j < row - 1; j++) {
                            added++;
                            set.add(added);
                        }
                        total += row - 1;
                    } else {
                        added += row;
                        total += row;
                    }
                }
                int[] squares = new int[total];
                for (int i = 0; i < squares.length; i++) {
                    squares[i] = i + 1;
                }
                if (row != 0 && column != 0) {
                    maze = new String[column][row];
                    for (int i = 0; i < maze.length; i++) {
                        for (int j = 0; j < maze[0].length; j++) {
                            maze[i][j] = source.next();
                        }
                    }
                    graph = addEdge(maze, squares, set);
                    connectedGraphs = find(graph);
                    System.out.println("Maze #" + current + ":");
                    if (connectedGraphs.size() > 0) {
                        int size = 0;
                        for (Integer connectedGraph : connectedGraphs) {
                            if (connectedGraph > size) {
                                size = connectedGraph;
                            }
                        }
                        System.out.println(connectedGraphs.size() + " Cycles; the longest has length " + size + ".");
                    } else {
                        System.out.println("There are no cycles.");
                    }
                    graph.clear();
                    connectedGraphs.clear();
                    set.clear();
                    founded.clear();
                    current++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
