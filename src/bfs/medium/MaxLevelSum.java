package bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
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

    public int maxLevelSum(TreeNode root) {
         int maxVal = Integer.MIN_VALUE;
         int maxLevel = 1, currentLevel = 1;
         Queue<TreeNode> queue = new LinkedList<>();

         queue.add(root);
         while (!queue.isEmpty()) {
             int n = queue.size();
             int sumLevel = 0;
             for (int i = 0; i < n; i++) {
                 TreeNode node = queue.poll();
                 if (node != null) {
                     sumLevel += node.val;
                     if (node.left != null)
                         queue.add(node.left);
                     if (node.right != null)
                         queue.add(node.right);
                 }
             }

             if (sumLevel > maxVal) {
                 maxVal = sumLevel;
                 maxLevel = currentLevel;
             }

             currentLevel++;
        }

        return maxLevel;
    }
}
