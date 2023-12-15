package ClosestNumber;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MergeSort {
    public void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public void mergeSort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (hi - lo) / 2 + lo;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
}

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        MergeSort sort = new MergeSort();
        List<Integer> list = new LinkedList<>();
        int length = arr.size();
        int[] a = new int[length];
        int[] aux = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = arr.get(i);
        }
        int min = Integer.MAX_VALUE;
        sort.mergeSort(a, aux, 0, length - 1);
        for (int i = 1; i < length; i++) {
            if (a[i] - a[i - 1] < min) {
                min = a[i] - a[i - 1];
                list.clear();
                list.add(a[i - 1]);
                list.add(a[i]);
            } else if (a[i] - a[i - 1] == min) {
                list.add(a[i - 1]);
                list.add(a[i]);
            }
        }
        return list;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

