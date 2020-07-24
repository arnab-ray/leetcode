package tree.medium;

public class PruneTree {
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

    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;

        if(root.left == null && root.right == null) {
            if(root.val == 1)
                return root;
            else
                return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.left == null && root.right == null)
            return root.val == 0 ? null : root;
        else
            return root;
    }
}
