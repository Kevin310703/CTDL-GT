public class QuickFind {
    private int[] id;
    QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }
    int find(int p) {
        return id[p];
    }
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
