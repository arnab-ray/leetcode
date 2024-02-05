package tree.medium;

public class SumRootToLeafNumbers {
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

    private int sumPathUtil(TreeNode root, int sum) {
        if (root == null) return 0;

        sum = (sum * 10) + root.val;
        if (root.left == null && root.right == null)
            return sum;

        return sumPathUtil(root.left, sum) + sumPathUtil(root.right, sum);
    }
 
    public int sumNumbers(TreeNode root) {
        return sumPathUtil(root, 0);
    }
}
