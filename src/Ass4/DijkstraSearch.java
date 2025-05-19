package Ass4;

import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distances;
    private Map<Vertex<V>, Vertex<V>> previous;

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(graph, start);
        distances = new HashMap<>();
        previous = new HashMap<>();
        dijkstra();
    }

    private void dijkstra() {
        Vertex<V> startVertex = graph.getVertex(start);
        if (startVertex == null) return;

        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(startVertex, 0.0);

        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(startVertex);

        Set<Vertex<V>> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            if (visited.contains(current)) continue;
            visited.add(current);

            for (Map.Entry<Vertex<V>, Double> neighbor : current.getAdjacentVertices().entrySet()) {
                Vertex<V> next = neighbor.getKey();
                double newDist = distances.get(current) + neighbor.getValue();
                if (newDist < distances.get(next)) {
                    distances.put(next, newDist);
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
        if (destVertex == null || distances.get(destVertex) == Double.POSITIVE_INFINITY) return path;

        Vertex<V> current = destVertex;
        while (current != null) {
            path.add(current.getData());
            current = previous.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}