import java.util.*;

import static java.util.stream.Collectors.joining;

class equalStack {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = h1.size() - 1; i >= 0; i--) {
            int num = h1.get(i);
            stack1.push(num);
            sum1 += num;
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            int num = h2.get(i);
            stack2.push(num);
            sum2 += num;
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            int num = h3.get(i);
            stack3.push(num);
            sum3 += num;
        }
        while(!(sum1 == sum2 && sum2 == sum3)) {
            if(sum3 > sum2) {
                if(sum3 > sum1) {
                    sum3 -= stack3.pop();
                }
                else {
                    sum1 -= stack1.pop();
                }
            }
            else { // sum2 >= sum3
                if(sum2 > sum1) {
                    sum2 -= stack2.pop();
                }
                else {
                    sum1 -= stack1.pop();
                }
            }
        }
        return sum1;
    }

}