package JavaMap;

import edu.princeton.cs.algs4.In;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int phone = sc.nextInt();
            sc.nextLine();
            map.put(name, phone);
        }
        while (sc.hasNext()) {
            String name = sc.nextLine();
            if (map.get(name) != null) {
                System.out.println(name + "=" + map.get(name));
            } else {
                System.out.println("Not found");
            }
        }
    }
}