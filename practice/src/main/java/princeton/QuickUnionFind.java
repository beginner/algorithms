package princeton;

// This implementation uses Quick Union.
public class QuickUnionFind {

    int[] id;
    int count;

    public QuickUnionFind(int N) {
        this.id = new int[N];
        this.count = N;
        for(int i = 0; i < N ; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while ( p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int findP = find(p);
        int findQ = find(q);

        if (findP == findQ) return;

        id[findP] = findQ;
        count--;
    }

    public int count() {
        return count;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
