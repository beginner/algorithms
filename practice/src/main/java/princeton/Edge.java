package princeton;

public class Edge implements Comparable<Edge> {

    private final int v,w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        return v;
    }


    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}
