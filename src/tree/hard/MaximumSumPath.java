package tree.hard;

import java.util.concurrent.atomic.AtomicInteger;

public class MaximumSumPath {
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

    private int findMaxSumUtil(TreeNode root, AtomicInteger sum) {
        if(root == null)
            return 0;

        int left = findMaxSumUtil(root.left, sum);
        int right = findMaxSumUtil(root.right, sum);

        int maxSumPath = Math.max(root.val, Math.max(left, right) + root.val);
        int maxWithRoot = Math.max(maxSumPath, left + right + root.val);
        sum.set(Math.max(sum.get(), maxWithRoot));

        return maxSumPath;
    }
 
    public int maxPathSum(TreeNode root) {
        AtomicInteger sum = new AtomicInteger(Integer.MIN_VALUE);
        findMaxSumUtil(root, sum);

        return sum.get();
    }
}
