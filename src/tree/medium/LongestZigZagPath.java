package tree.medium;

import java.util.concurrent.atomic.AtomicInteger;

public class LongestZigZagPath {
    public static class TreeNode {
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
    
    public int longestZigZag(TreeNode root) {
        AtomicInteger left = new AtomicInteger();
        AtomicInteger right = new AtomicInteger();

        treeUtil(root.left, -1, 1, left);
        treeUtil(root.right, 1, 1, right);

        return Math.max(left.get(), right.get());
    }

    private void treeUtil(TreeNode root, int dir, int length, AtomicInteger maxLen) {
        if (root == null)
            return;

        if (length > maxLen.get()) {
            maxLen.set(length);
        }

        if (dir == -1) {
            treeUtil(root.left, -1, 1, maxLen);
            treeUtil(root.right, 1, length + 1, maxLen);
        } else {
            treeUtil(root.left, -1, length + 1, maxLen);
            treeUtil(root.right, 1, 1, maxLen);
        }
    }
}
