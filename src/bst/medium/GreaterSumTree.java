package bst.medium;

public class GreaterSumTree {
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

    private TreeNode bstToGstUtil(TreeNode root, TreeNode parent) {
        if(root == null)
            return null;

        if(root.right == null && parent != null)
            root.val = root.val + parent.val;

        if(root.left == null && root.right == null)
            return root;

        TreeNode right = bstToGstUtil(root.right, parent);
        if (right != null) {
            root.val = root.val + right.val;
        }

        TreeNode left = bstToGstUtil(root.left, root);
        if(left != null)
            return left;
        else
            return root;
    }

    public TreeNode bstToGst(TreeNode root) {
        bstToGstUtil(root, null);
        return root;
    }
}
