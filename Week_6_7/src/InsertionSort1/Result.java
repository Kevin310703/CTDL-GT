package InsertionSort1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int key = arr.get(arr.size() - 1);
        for(int i = arr.size() - 1; i >= 1; i--) {
            if(arr.get(i-1) > key) {
                arr.set(i, arr.get(i-1));
                for(int j = 0; j < arr.size(); j++) {
                    System.out.print(arr.get(j) + " ");
                }
                System.out.println("");
            }
            else {
                arr.set(i, key);
                for(int j = 0; j < arr.size(); j++) {
                    System.out.print(arr.get(j) + " ");
                }
                System.out.println("");
                break;
            }
        }
        if(arr.get(0) > key) {
            arr.set(0, key);
            for(int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(j) + " ");
            }
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
