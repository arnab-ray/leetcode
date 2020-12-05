package bfs.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueTreeRow {
    private class TreeNode {
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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);

            while (!queue.isEmpty()) {
                int maxValue = Integer.MIN_VALUE;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        maxValue = Math.max(maxValue, node.val);
                        if (node.left != null)
                            queue.add(node.left);
                        if (node.right != null)
                            queue.add(node.right);
                    }
                }
                result.add(maxValue);
            }
        }

        return result;
    }
}
