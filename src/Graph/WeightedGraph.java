package Graph;/* Created by oguzkeremyildiz on 11.04.2020 */

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WeightedGraph<Symbol> {
    private HashMap<Symbol, LinkedList<Pair<Symbol, Integer>>> edgeList;
    private HashSet<Symbol> vertexList;

    public WeightedGraph(){
        edgeList = new HashMap<>();
        vertexList = new HashSet<>();
    }

    public void clear() {
        edgeList.clear();
        vertexList.clear();
    }

    public void addDirectedEdge(Symbol from, Symbol to, int length) {
        vertexList.add(from);
        vertexList.add(to);
        if (!edgeList.containsKey(from)){
            edgeList.put(from, new LinkedList<>());
            edgeList.get(from).addFirst(new Pair<>(to, length));
        } else {
            edgeList.get(from).add(new Pair<>(to, length));
        }
    }

    public void addUndirectedEdge(Symbol from, Symbol to, int lengthFrom, int lengthTo) {
        addDirectedEdge(from, to, lengthTo);
        addDirectedEdge(to, from, lengthFrom);
    }

    public Set<Symbol> getKeySet() {
        return edgeList.keySet();
    }

    public int size() {
        return edgeList.size();
    }

    public void put(Symbol index, LinkedList<Pair<Symbol, Integer>> list) {
        edgeList.put(index, list);
    }

    public LinkedList<Pair<Symbol, Integer>> get(Symbol index) {
        return edgeList.get(index);
    }
}
