package Dijkstra;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Cost implements Comparable<Cost> {
    public int r, v;

    public Cost(int cost, int vertex) {
        r = cost;
        v = vertex;
    }

    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r > c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        return 0;
    }
}

class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        List<List<Cost>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Cost>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new Cost(w, v));
            adj.get(v).add(new Cost(w, u));
            System.out.println(u + " " + v + " " + w);
        }

        PriorityQueue<Cost> pq = new PriorityQueue<>();
        ArrayList<Integer> marked = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            marked.add(Integer.MAX_VALUE);
        }
        marked.set(s, 0);

        pq.add(new Cost(0, s));
        while (!pq.isEmpty()) {
            Cost cost = pq.poll();
            if(marked.get(cost.v) < cost.r) {
                continue;
            }

            for(Cost x : adj.get(cost.v)) {
                if(marked.get(x.v) > cost.r + x.r) {
                    marked.set(x.v, cost.r + x.r);
                    pq.add(new Cost(marked.get(x.v), x.v));
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(marked.get(i) == Integer.MAX_VALUE) {
                marked.set(i, -1);
            }
            if(i != s) {
                result.add(marked.get(i));
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.shortestReach(n, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
