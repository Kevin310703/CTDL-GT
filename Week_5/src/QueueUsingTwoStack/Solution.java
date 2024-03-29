package QueueUsingTwoStack;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numOfQueries = in.nextInt();
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        int command;
        for (int i = 0; i < numOfQueries; i++) {
            command = in.nextInt();
            if (command == 1) {
                one.push(in.nextInt());
            } else if (command == 2) {
                if (two.isEmpty()) {
                    while (!one.isEmpty()) {
                        two.push(one.pop());
                    }
                }
                two.pop();
            } else if (command == 3) {
                if (two.isEmpty()) {
                    while (!one.isEmpty()) {
                        two.push(one.pop());
                    }
                }
                System.out.println(two.peek());
            }
        }
    }
}
