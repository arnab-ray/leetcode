package tree.medium;

public class DeepestLeavesSum {
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

    public int deepestLeavesSum(TreeNode root) {
        int treeHeight = height(root);
        return sum(root, 1, treeHeight);
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int sum(TreeNode root, int height, int maxHeight) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && height == maxHeight)
            return root.val;
        if (root.left == null && root.right == null)
            return 0;

        int leftVal = sum(root.left, height + 1, maxHeight);
        int rightVal = sum(root.right, height + 1, maxHeight);

        return leftVal + rightVal;
    }
}
