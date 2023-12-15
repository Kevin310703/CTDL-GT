import edu.princeton.cs.algs4.In;

public class InsertionSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        In input = new In("D:\\CTDLGT\\algs4-data\\algs4-data\\1Mints.txt");
        int[] a = input.readAllInts();
        for(int i = 1; i < a.length; i++) {
            if(a[i] < a[i-1]) {
                int j = i;
                while(j > 0 && a[j] < a[j-1]) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    j--;
                }
            }
        }
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}
