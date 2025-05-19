package Ass4;

import java.util.*;

public class DepthFirstSearch<V> extends Search<V> {
    private Map<Vertex<V>, Vertex<V>> previous;

    public DepthFirstSearch(WeightedGraph<V> graph, V start) {
        super(graph, start);
        previous = new HashMap<>();
        dfs();
    }

    private void dfs() {
        Vertex<V> startVertex = graph.getVertex(start);
        if (startVertex == null) return;

        Set<Vertex<V>> visited = new HashSet<>();
        Stack<Vertex<V>> stack = new Stack<>();
        stack.push(startVertex);
        visited.add(startVertex);

        while (!stack.isEmpty()) {
            Vertex<V> current = stack.pop();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                    previous.put(neighbor, current);
                }
            }
        }
    }

    @Override
    public List<V> pathTo(V dest) {
        List<V> path = new ArrayList<>();
        Vertex<V> destVertex = graph.getVertex(dest);
        if (destVertex == null) return path;

        Vertex<V> current = destVertex;
        while (current != null) {
            path.add(current.getData());
            current = previous.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}
