//package Week10.IsABinarySearchTree;
//
///* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.
//
//The Node class is defined as follows:
//    class Node {
//        int data;
//        Node left;
//        Node right;
//     }
//*/
//
//import java.util.ArrayList;
//
//public class Solution {
//}
//
//    public static ArrayList<Integer> ans = new ArrayList<>();
//
//    public static ArrayList<Integer> inOrder(Node root) {
//        if (root != null) {
//            if (root.left != null) {
//                inOrder(root.left);
//            }
//
//            ans.add(root.data);
//
//            if (root.right != null) {
//                inOrder(root.right);
//            }
//        }
//        return ans;
//    }
//
//    boolean checkBST(Node root) {
//        ArrayList<Integer> ans = inOrder(root);
//        for (int i = 1; i < ans.size(); i++) {
//            if (ans.get(i) <= ans.get(i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }