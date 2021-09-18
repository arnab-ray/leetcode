package tree.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinsBinaryTree {
    static class TreeNode {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;

        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> height = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();
        queue.add(root);
        height.put(root.val, 0);
        parent.put(root.val, null);

        int currentHeight = 1;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                tempQueue.add(node.left);
                parent.put(node.left.val, node.val);
                height.put(node.left.val, currentHeight);
            }

            if(node.right != null) {
                tempQueue.add(node.right);
                parent.put(node.right.val, node.val);
                height.put(node.right.val, currentHeight);
            }

            if(queue.isEmpty()) {
                queue = tempQueue;
                tempQueue = new LinkedList<>();
                currentHeight++;
            }
        }

        return parent.get(x).intValue() != parent.get(y).intValue() && height.get(x).intValue() == height.get(y).intValue();
    }
}
