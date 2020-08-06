package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers2 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root != null) {
            Queue<Node> queue = new LinkedList<>();
            Queue<Node> secondaryQueue = new LinkedList<>();
            Node prev = null;

            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if(prev != null)
                    prev.next = node;

                if(node.left != null)
                    secondaryQueue.add(node.left);
                if(node.right != null)
                    secondaryQueue.add(node.right);

                prev = node;

                if(queue.isEmpty()) {
                    queue = secondaryQueue;
                    secondaryQueue = new LinkedList<>();
                    prev = null;
                }
            }
        }

        return root;
    }
}
