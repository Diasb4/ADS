package Ass4;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.vertices = new HashMap<>();
        this.directed = directed;
    }

    public void addEdge(V sourceData, V destData, double weight) {
        Vertex<V> source = vertices.computeIfAbsent(sourceData, Vertex::new);
        Vertex<V> dest = vertices.computeIfAbsent(destData, Vertex::new);
        source.addAdjacentVertex(dest, weight);
        if (!directed) {
            dest.addAdjacentVertex(source, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Set<Vertex<V>> getVertices() {
        return new HashSet<>(vertices.values());
    }
}