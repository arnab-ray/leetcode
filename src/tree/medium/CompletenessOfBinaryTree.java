package tree.medium;

public class CompletenessOfBinaryTree {
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

    private int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean isCompleteUtil(TreeNode root, int index, int nodeCount) {
        if(root == null)
            return true;

        if(index > nodeCount)
            return false;

        return isCompleteUtil(root.left, 2 * index, nodeCount) &&
                isCompleteUtil(root.right, 2 * index + 1, nodeCount);
    }

    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        return isCompleteUtil(root, 1, totalNodes);
    }
}
