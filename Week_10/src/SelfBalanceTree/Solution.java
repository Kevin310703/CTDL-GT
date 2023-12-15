//package Week10.SelfBalanceTree;
//
//public class Solution {
//    	/* Class node is defined as :
//    class Node
//    	int val;	//Value
//    	int ht;		//Height
//    	Node left;	//Left child
//    	Node right;	//Right child
//
//	*/
//
//    static Node insert(Node root,int val)
//    {
//        if (root == null) {
//            root = new Node();
//            root.val = val;
//            return root;
//        }
//
//        if (val > root.val) {
//            root.right = insert(root.right, val);
//        } else if (val < root.val) {
//            root.left = insert(root.left, val);
//        } else {
//            return root;
//        }
//
//        root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//
//        if (balance(root) < -1) {
//            if (balance(root.right) <= 0) {
//                return leftRotate(root);
//            } else {
//                root.right = rightRotate(root.right);
//                return leftRotate(root);
//            }
//        } else if (balance(root) > 1) {
//            if (balance(root.left) >= 0) {
//                return rightRotate(root);
//            } else {
//                root.left = leftRotate(root.left);
//                return rightRotate(root);
//            }
//        }
//        return root;
//    }
//
//    static Node leftRotate(Node root) {
//        Node newRoot = root.right;
//        root.right = newRoot.left;
//        newRoot.left = root;
//
//        root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//        newRoot.ht = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
//
//        return newRoot;
//    }
//
//    static Node rightRotate(Node root) {
//        Node newRoot = root.left;
//        root.left = newRoot.right;
//        newRoot.right = root;
//
//        root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//        newRoot.ht = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
//
//        return newRoot;
//    }
//
//    static int balance(Node root) {
//        if(root == null) {
//            return 0;
//        }
//        return getHeight(root.left) - getHeight(root.right);
//    }
//
//    static int getHeight(Node root) {
//        if (root != null) {
//            return root.ht;
//        }
//        return -1;
//    }
//}
//
//
