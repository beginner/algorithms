package algorithm;

import princeton.Edge;

public class UnionFindPathCompression {

    private int[] id;
    private int count;

    public UnionFindPathCompression(int N) {
        this.count = N;
        this.id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        int findP = id[p];
        if (p == findP) return p;
        id[p] = find(findP);
        return id[p];
    }

    public void union(int p, int q) {
        int findP = find(p);
        int findQ = find(q);

        if (findP == findQ) return;

        id[findP] = findQ;
        count--;
    }

}
