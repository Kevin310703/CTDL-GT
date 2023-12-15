package BalancedBrackets;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class ArrayStack {
    private char[] arr = new char[10000];
    int top = -1;
    public void push(char c) {
        arr[++top] = c;
    }
    public void pop(){
        if(top >= 0)    top--;
    }
    public char peek(){
        return arr[top];
    }
    public boolean empty(){
        return top < 0;
    }
}

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        ArrayStack stacks = new ArrayStack();
        int leng = s.length();
        if(leng % 2 != 0)    return "NO";
        for(int i = 0; i < leng; i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stacks.push(s.charAt(i));
            }
            if(i > 0) {
                if(stacks.empty())  return "NO";
                if(s.charAt(i) == '}' && stacks.peek() == '{') stacks.pop();
                else if(s.charAt(i) == ']' && stacks.peek() == '[') stacks.pop();
                else if(s.charAt(i) == ')' && stacks.peek() == '(') stacks.pop();
            }
        }
        if(stacks.empty())  return "YES";
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
