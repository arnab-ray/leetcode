import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    static class MaxHeight {
        int val;
        int height;

        MaxHeight(int val, int height) {
            this.val = val;
            this.height = height;
        }

        MaxHeight() {
            this.val = -1;
            this.height = -1;
        }
    }

    private static void getAncestor(Node root, MaxHeight maxHeight, int level) {
        if(root == null) {
            return;
        }

        System.out.println("root: " + root.val + " height: " + level + " maxHeight: " + maxHeight.height);
        if (root.left == null && root.right == null) {
            if (level > maxHeight.height) {
                maxHeight.val = root.val;
                maxHeight.height = level;
            }
        }

        if (root.left != null) {
            getAncestor(root.left, maxHeight, level + 1);
        }

        if (root.right != null) {
            getAncestor(root.right, maxHeight, level + 1);
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int[][] input = new int[][] {{1,3}, {2,3}, {3,6}, {5,6}, {5,7}, {4,5}, {4,8}, {8,9}, {10,2}};

//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        node3.right = node1;
//        node3.left = node2;
//
//        Node node6 = new Node(6);
//        node6.right = node3;
//        Node node5 = new Node(5);
//        node6.left = node5;
//
//        Node node7 = new Node(7);
//        node7.right = node5;
//
//        Node node4= new Node(4);
//        Node node8 = new Node(8);
//
//        node5.left = node4;
//        node8.right = node4;
//
//        Node node9 = new Node(9);
//        node9.right = node8;
//
//        node2.right = new Node(10);


        Map<Integer, Node> nodes = new HashMap<>();


        for (int i = 0; i < input.length; i++) {
            if (nodes.get(input[i][1]) == null) {
                nodes.put(input[i][1], new Node(input[i][1]));
            }
        }

        for (int i = 0; i < input.length; i++) {
            Node node2 = nodes.get(input[i][1]);
            Node node1 = nodes.get(input[i][0]) == null ? new Node(input[i][0]) : nodes.get(input[i][0]);

            nodes.putIfAbsent(input[i][0], node1);


            if (node2.right == null) {
                node2.right = node1;
            } else {
                node2.left = node1;
            }
        }


        Integer val = 6;
        Node root = null;
        for (Map.Entry<Integer, Node> entry : nodes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().val);
            if (entry.getKey() == val) {
                root = entry.getValue();
            }
        }

        //Node root = node6;
        //System.out.println(root.val);
        //printTree(root);
        MaxHeight maxHeight = new MaxHeight();
        getAncestor(root, maxHeight, 1);
        System.out.println(maxHeight.val + ":" + maxHeight.height);
    }
}