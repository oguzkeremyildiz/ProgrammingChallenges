import Cookies.Graph.Edge;
import Cookies.Graph.IntegerLength;
import Cookies.Graph.WeightedGraph;
import GraphAlgorithms.G7.TheGrandDinner;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TheGrandDinnerTest extends TheGrandDinner {

    @Test
    void testBreadthFirstSearch() {
        HashMap<String, String> returning = new HashMap<>();
        WeightedGraph<String, Integer> graph = new WeightedGraph<>(new IntegerLength());
        graph.addUndirectedEdge("s", "team1", new Edge<>(4, new IntegerLength()));
        graph.addUndirectedEdge("s", "team2", new Edge<>(5, new IntegerLength()));
        graph.addUndirectedEdge("s", "team3", new Edge<>(3, new IntegerLength()));
        graph.addUndirectedEdge("s", "team4", new Edge<>(5, new IntegerLength()));
        graph.addUndirectedEdge("team1", "table1", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team1", "table2", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team1", "table3", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team1", "table4", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team1", "table5", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team2", "table1", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team2", "table2", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team2", "table3", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team2", "table4", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team2", "table5", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team3", "table1", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team3", "table2", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team3", "table3", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team3", "table4", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team3", "table5", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team4", "table1", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team4", "table2", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team4", "table3", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team4", "table4", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("team4", "table5", new Edge<>(1, new IntegerLength()));
        graph.addUndirectedEdge("table1", "t", new Edge<>(3, new IntegerLength()));
        graph.addUndirectedEdge("table2", "t", new Edge<>(5, new IntegerLength()));
        graph.addUndirectedEdge("table3", "t", new Edge<>(2, new IntegerLength()));
        graph.addUndirectedEdge("table4", "t", new Edge<>(6, new IntegerLength()));
        graph.addUndirectedEdge("table5", "t", new Edge<>(4, new IntegerLength()));
        returning.put("team1", "s");
        returning.put("team2", "s");
        returning.put("team3", "s");
        returning.put("team4", "s");
        returning.put("table1", "team1");
        returning.put("table2", "team1");
        returning.put("table3", "team1");
        returning.put("table4", "team1");
        returning.put("table5", "team1");
        returning.put("t", "table1");
        assertEquals(returning, breadthFirstSearch(graph, "s"));
    }
}
