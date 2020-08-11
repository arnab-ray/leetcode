package tree.medium;

import java.util.*;

public class VerticalTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    class Node {
        int x;
        int y;
        int val;
        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private void verticalTraversalUtil(TreeNode root, int x, int y, List<Node> list) {
        if(root == null)
            return;

        list.add(new Node(x, y, root.val));

        verticalTraversalUtil(root.left, x - 1, y - 1, list);
        verticalTraversalUtil(root.right, x + 1, y - 1, list);
    }
 
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null)
            return new LinkedList<>();

        List<Node> list = new LinkedList<>();
        verticalTraversalUtil(root, 0, 0, list);

        Collections.sort(list, (p1, p2) -> p1.x == p2.x ? p1.y == p2.y ? p1.val- p2.val : p2.y - p1.y : p1.x - p2.x);

        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(Node n : list) {
            List<Integer> line = map.getOrDefault(n.x, new LinkedList<>());
            line.add(n.val);
            map.put(n.x, line);
        }

        return new LinkedList<>(map.values());
    }
}
