package Ass4;
import java.util.List;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;
    protected V start;

    public Search(WeightedGraph<V> graph, V start) {
        this.graph = graph;
        this.start = start;
    }

    public abstract List<V> pathTo(V dest);
}
