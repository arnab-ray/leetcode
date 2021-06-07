package string.easy;

public class StringFromBinaryTree {
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

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        treeUtil(root, sb);

        return sb.toString();
    }

    private void treeUtil(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            sb.append(root.val);
        } else if (root.left == null) {
            sb.append(root.val);
            sb.append("()");
            sb.append("(");
            treeUtil(root.right, sb);
            sb.append(")");
        } else {
            sb.append(root.val);
            sb.append("(");
            treeUtil(root.left, sb);
            sb.append(")");

            if (root.right != null) {
                sb.append("(");
                treeUtil(root.right, sb);
                sb.append(")");
            }
        }
    }
}
