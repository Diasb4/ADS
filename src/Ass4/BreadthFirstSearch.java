package Ass4;
import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    private Map<Vertex<V>, Vertex<V>> previous;

    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        super(graph, start);
        previous = new HashMap<>();
        bfs();
    }

    private void bfs() {
        Vertex<V> startVertex = graph.getVertex(start);
        if (startVertex == null) return;

        Map<Vertex<V>, Double> distances = new HashMap<>();
        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(startVertex, 0.0);

        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Map.Entry<Vertex<V>, Double> neighbor : current.getAdjacentVertices().entrySet()) {
                Vertex<V> next = neighbor.getKey();
                if (distances.get(next) == Double.POSITIVE_INFINITY) {
                    distances.put(next, distances.get(current) + 1);
                    previous.put(next, current);
                    queue.add(next);
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
