package princeton;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST {

    private boolean[] visited; // MST Vertices
    private Queue<Edge> mst; // MST edges
    private PriorityQueue<Edge> pq; // PQ of edges

    // Proportional of E log E
    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new PriorityQueue<>(Comparator.comparingDouble(Edge::weight));
        mst = new ArrayDeque<>();
        visited = new boolean[G.V()];

        visit(G, 0);

        while(! pq.isEmpty()) {
            Edge poll = pq.poll();
            int v = poll.either();
            int w = poll.other(v);

            if (visited[v] && visited[w]) continue;

            mst.add(poll);

            if (!visited[v]) {
                visit(G, v);
            }
            if (!visited[w]) {
                visit(G, w);
            }
        }


    }

    private void visit(EdgeWeightedGraph G, int v) {
        visited[v] = true;
        for(Edge e : G.adj(v)) {
            int other = e.other(v);
            if (!visited[other]) {
                pq.offer(e);
            }
        }
    }


    public Iterable<Edge> mst() {
        return mst;
    }
}
