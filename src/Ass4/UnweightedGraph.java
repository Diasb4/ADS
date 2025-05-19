package Ass4;

public class UnweightedGraph<V> extends WeightedGraph<V> {
    public UnweightedGraph(boolean directed) {
        super(directed);
    }

    public void addEdge(V sourceData, V destData) {
        super.addEdge(sourceData, destData, 1.0);
    }
}
