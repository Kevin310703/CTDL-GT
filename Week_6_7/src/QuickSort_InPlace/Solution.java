package QuickSort_InPlace;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        QuickSortInPlace(arr, 0, n - 1);
    }

    public static void QuickSortInPlace(int[] arr, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        int patition = end;
        int pivot = arr[patition];
        int right = -1;
        for (int i = start; i <= end; i++) {
            if (right != -1 && arr[i] <= pivot) {
                if(arr[i] == pivot) {
                    patition = right;
                }
                int temp = arr[i];
                arr[i] = arr[right];
                arr[right] = temp;
                right++;
            }
            if (right == -1 && arr[i] > pivot) {
                right = i;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        QuickSortInPlace(arr, start, patition - 1);
        QuickSortInPlace(arr, patition + 1, end);
    }
}
