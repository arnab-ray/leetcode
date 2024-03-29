package tree.easy;

import java.util.List;

public class MaxDepthNAryTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if(root == null)
            return 0;

        if(root.children == null || root.children.isEmpty())
            return 1;

        int k = 0;
        for(Node v : root.children){
            k = Math.max(k, 1 + maxDepth(v));
        }
        return k;

    }
}
