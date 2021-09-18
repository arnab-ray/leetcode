package tree.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class SumOfLeftLeaves {
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

    public int sumOfLeftLeaves(TreeNode root) {
        AtomicInteger i = new AtomicInteger();
        if(root == null || (root.left == null && root.right == null))
            return 0;
        sumUtil(root.left, true, i);
        sumUtil(root.right, false, i);

        return i.get();
    }

    private void sumUtil(TreeNode root, boolean left, AtomicInteger i) {
        if(root == null)
            return;

        if(left && root.left == null && root.right == null) {
            i.getAndAdd(root.val);
        }

        sumUtil(root.left, true, i);
        sumUtil(root.right, false, i);
    }
}
