package Kruskal;

import java.io.*;
import java.util.*;

class Cost implements Comparable<Cost> {
    public int gFrom, gTo, gWeight;

    public Cost(int gFrom, int gTo, int gWeight) {
        this.gFrom = gFrom;
        this.gTo = gTo;
        this.gWeight = gWeight;
    }

    @Override
    public int compareTo(Cost other) {
        return Integer.compare(gWeight, other.gWeight);
    }
}

class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int getRoot(int x, int[] root) {
        while (root[x] != x) {
            x = root[x];
        }
        return x;
    }

    public static boolean connected(int x, int y, int[] root) {
        return getRoot(x, root) == getRoot(y, root);
    }

    public static void doConnect(int x, int y, int[] root) {
        root[getRoot(x, root)] = getRoot(y, root);
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        PriorityQueue<Cost> minPQ = new PriorityQueue<>();
        for (int i = 0; i < gTo.size(); i++) {
            minPQ.add(new Cost(gFrom.get(i), gTo.get(i), gWeight.get(i)));
        }
        int[] root = new int[gNodes + 5];
        for (int i = 1; i <= gNodes; i++) {
            root[i] = i;
        }
        int total = 0, amount = 0;
        while (total < gNodes - 1 && !minPQ.isEmpty()) {
            Cost cost = minPQ.remove();
            if (!connected(cost.gFrom, cost.gTo, root)) {
                doConnect(cost.gFrom, cost.gTo, root);
                amount += cost.gWeight;
                total++;
            }
        }
        return amount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int gNodes = scanner.nextInt();
        int gSize = scanner.nextInt();
        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();
        for (int i = 0; i < gSize; i++) {
            gFrom.add(scanner.nextInt());
            gTo.add(scanner.nextInt());
            gWeight.add(scanner.nextInt());
        }
        int result = Result.kruskals(gNodes, gFrom, gTo, gWeight);
        System.out.println(result);
    }
}
