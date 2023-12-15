package BinaryTreeInsertion;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node insert(Node root,int data) {
        if(root != null) {
            Node node = new Node(data);
            Node temp = root;
            while(temp != null) {
                if(temp.data > data) {
                    if(temp.left != null) {
                        temp = temp.left;
                    } else {
                        temp.left = node;
                        return root;
                    }
                } else if(temp.data < data) {
                    if(temp.right != null) {
                        temp = temp.right;
                    } else {
                        temp.right = node;
                        return root;
                    }
                }
            }
        }
        return new Node(data);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
