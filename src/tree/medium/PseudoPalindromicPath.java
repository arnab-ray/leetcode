package tree.medium;

import java.util.concurrent.atomic.AtomicInteger;

public class PseudoPalindromicPath {
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
    
    public int pseudoPalindromicPaths (TreeNode root) {
        AtomicInteger count = new AtomicInteger();
        int[] countDigits = new int[10];

        countUtil(root, count, countDigits);

        return count.get();
    }

    private static void countUtil(TreeNode root, AtomicInteger count, int[] countDigits) {
        if (root == null)
            return;

        countDigits[root.val]++;

        if (root.left == null && root.right == null) {
            int countOddFreq = 0;
            for (int i = 1; i <= 9; i++) {
                if (countDigits[i] % 2 != 0) {
                    countOddFreq++;
                }
            }

            if (countOddFreq == 0 || countOddFreq == 1)
                count.getAndIncrement();
        }

        countUtil(root.left, count, countDigits);
        countUtil(root.right, count, countDigits);

        countDigits[root.val]--;
    }
}
