import edu.princeton.cs.algs4.*;
public class Three_Sum {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\admin\\Documents\\GitHub\\CTDL-GT\\Week_2\\Data\\4Kints.txt");
        int[] a = in.readAllInts();

        findZeroSumTriplets(a);
    }

    private static void findZeroSumTriplets(int[] arr) {
        int n = arr.length;

        // Sử dụng ba vòng lặp để kiểm tra mọi bộ 3 số có tổng bằng 0
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        StdOut.println("Triplet found: " + arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }
    }
}
