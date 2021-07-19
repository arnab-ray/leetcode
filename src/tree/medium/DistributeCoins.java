package tree.medium;

import java.util.concurrent.atomic.AtomicInteger;

public class DistributeCoins {
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
    
    public int distributeCoins(TreeNode root) {
        AtomicInteger minVal = new AtomicInteger();
        distributeCoinsUtil(root, minVal);

        return minVal.get();
    }

    private int distributeCoinsUtil(TreeNode root, AtomicInteger minVal) {
        if (root == null)
            return 0;

        int coinsLeft = distributeCoinsUtil(root.left, minVal);
        int coinsRight = distributeCoinsUtil(root.right, minVal);

        int delta = Math.abs(coinsLeft) + Math.abs(coinsRight);
        minVal.getAndAdd(delta);

        return root.val + coinsLeft + coinsRight - 1;
    }
}
