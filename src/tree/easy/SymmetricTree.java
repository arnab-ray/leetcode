package tree.easy;

public class SymmetricTree {
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

    public boolean isSymmetric(TreeNode root) {
        root.left = mirrorTree(root.left);
        return isIdentical(root.left, root.right);
    }

    private TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;

        mirrorTree(root.left);
        mirrorTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    private boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null || root1.val != root2.val)
            return false;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}
