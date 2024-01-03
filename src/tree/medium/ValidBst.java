package tree.medium;

import java.util.ArrayList;
import java.util.List;

public class ValidBst {
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

    private void bstTraversal(TreeNode root, List<Integer> path) {
        if(root == null)
            return;

        bstTraversal(root.left, path);
        path.add(root.val);
        bstTraversal(root.right, path);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;

        List<Integer> path = new ArrayList<>();
        bstTraversal(root, path);

        for(int i = 1; i < path.size(); i++) {
            if(path.get(i - 1) >= path.get(i))
                return false;
        }

        return true;
    }
}
