import edu.princeton.cs.algs4.*;
public class Two_Sum {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\admin\\Documents\\GitHub\\CTDL-GT\\Week_2\\Data\\4Kints.txt");
        int[] a = in.readAllInts();

        findZeroSumPairs(a);
    }

    private static void findZeroSumPairs(int[] arr) {
        int n = arr.length;

        // Sử dụng hai vòng lặp để kiểm tra mọi cặp số có tổng bằng 0
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == 0) {
                    StdOut.println("Pair found: " + arr[i] + " " + arr[j]);
                }
            }
        }
    }
}
