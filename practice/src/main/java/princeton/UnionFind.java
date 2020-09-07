package princeton;

// This implementation uses Quick Find.
public class UnionFind {

    private int[] id;
    private int count;

    public UnionFind(int N) {
        this.id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
        this.count = N;
    }

    // O(1)
    public int find(int p) {
        return id[p];
    }

    // O(N^2)
    public void union(int p, int q) {
        int findP = find(p);
        int findQ = find(q);

        if (findP == findQ) { // Already part of same component
            return;
        }

        for(int i = 0; i < id.length; i++) {
            if (id[i] == findP) {
                id[i] = findQ;
            }
        }
        count--;
    }

    public int count() {
        return count;
    }
}
