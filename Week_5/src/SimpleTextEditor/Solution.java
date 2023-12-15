package SimpleTextEditor;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = "";
        int numOfRequest = sc.nextInt();
        int request;
        Stack<String> oldVersion = new Stack<>();
        for (int i = 0; i < numOfRequest; i++) {
            request = sc.nextInt();
            switch (request) {
                case 1: {
                    oldVersion.push(text);
                    String append = sc.next();
                    text += append;
                    break;
                }
                case 2: {
                    oldVersion.push(text);
                    int k = sc.nextInt();
                    text = text.substring(0, text.length() - k);
                    break;
                }
                case 3: {
                    int k = sc.nextInt();
                    System.out.println(text.charAt(k-1));
                    break;
                }
                case 4: {
                    if(!oldVersion.isEmpty()) {
                        String oldText = oldVersion.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }
    }
}

