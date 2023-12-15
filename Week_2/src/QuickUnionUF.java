public class QuickUnionUF {
    private final int[] id;
    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        id[i] = j;
    }
    int find(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
