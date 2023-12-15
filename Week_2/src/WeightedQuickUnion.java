public class WeightedQuickUnion {
    private final int[] id;
    private final int[] sz;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j]+=sz[i];
        } else {
            id[j] = i;
            sz[i]+=sz[j];
        }
    }

    int find(int i) {
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
