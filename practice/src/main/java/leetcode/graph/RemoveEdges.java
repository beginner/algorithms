package leetcode.graph;

import princeton.UnionFind;

import java.util.Arrays;

// https://leetcode.com/contest/weekly-contest-205/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
public class RemoveEdges {

    public static void main(String[] args) {
        int[][] edges = {
                {3,1,2},
                {3,2,3},
                {1,1,3},
                {1,2,4},
                {1,1,2},
                {2,3,4}
        };
        int n = 4;
        RemoveEdges problem = new RemoveEdges();
        System.out.println(problem.maxNumEdgesToRemove(n, edges));
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        int edgesAdded = 0;

        UnionFind aliceUf = new UnionFind(n);
        UnionFind bobUf = new UnionFind(n);

        for(int[] edge : edges) {
            int type = edge[0];
            int p = edge[1];
            int q = edge[2];

            if (type == 3) {
                if (aliceUf.union(p,q) | bobUf.union(p,q)) {
                    edgesAdded++;
                }
            } else if (type == 1 && aliceUf.union(p,q)) {
                edgesAdded++;
            } else if (bobUf.union(p,q)){
                edgesAdded++;
            }
        }

        if (aliceUf.isConnected() && bobUf.isConnected()) {
            return edges.length - edgesAdded;
        }
        return -1;
    }


    private class UnionFind {

        private int[] id;
        private int[] sz;
        private int count;

        public UnionFind(int N) {
            this.id = new int[N + 1];
            this.sz = new int[N +1];
            this.count = N;
            for(int i = 0; i <= N; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }

        public boolean isConnected() {
            return count == 1;
        }

        public boolean union(int p , int q) {
            int findP = find(p);
            int findQ = find(q);

            if (findP == findQ) {
                return false;
            }

            count--;
            if (sz[findP] < sz[findQ]) {
                id[findP] = findQ;
                sz[findQ] += sz[findP];
            } else {
                id[findQ] = findP;
                sz[findP] += sz[findQ];
            }

            return true;
        }

    }

}
