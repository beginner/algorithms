package princeton;

public class QuickUnionOptimized {

    private int[] id;
    private int[] sz;
    private int count;

    public QuickUnionOptimized(int N) {
        this.id = new int[N];
        this.sz = new int[N];
        this.count = N;
        for(int i = 0; i < N; i++) {
            sz[i] = 1;
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int findP = find(p);
        int findQ = find(q);

        if (findP == findQ) return;

        if (sz[p] < sz[q]) {
            id[p] = findQ;
            sz[q] += sz[p];
        } else {
            id[q] = findP;
            sz[p] += sz[q];
        }
        count--;
    }
}
