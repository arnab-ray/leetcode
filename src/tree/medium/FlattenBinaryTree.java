package tree.medium;

public class FlattenBinaryTree {
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
 
    public void flatten(TreeNode root) {
         if(root == null || (root.left == null && root.right == null))
             return;

         else if(root.left != null) {
             flatten(root.left);
             TreeNode right = root.right;
             flatten(root.right);
             root.right = root.left;

             TreeNode dummy = root.left;
             root.left = null;
             while (dummy.right != null)
                 dummy = dummy.right;
             dummy.right = right;
         } else {
             flatten(root.right);
         }
    }
}
