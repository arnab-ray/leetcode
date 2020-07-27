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

    private void BstTraversal(TreeNode root, List<Integer> path) {
        if(root == null)
            return;

        BstTraversal(root.left, path);
        path.add(root.val);
        BstTraversal(root.right, path);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;

        List<Integer> path = new ArrayList<>();
        BstTraversal(root, path);

        for(int i = 1; i < path.size(); i++) {
            if(path.get(i - 1) >= path.get(i))
                return false;
        }

        return true;
    }
}
