package tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CountGoodNodes {
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

    private boolean existsGreater(int target, List<Integer> path) {
        if(path == null || path.isEmpty())
            return false;

        for(Integer i : path) {
            if(i > target) {
                return true;
            }
        }
        return false;
    }

    private int goodNodes(TreeNode root, List<Integer> path) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null) {
            if(!existsGreater(root.val, path))
                return 1;
        }

        path.add(root.val);
        int leftCount = goodNodes(root.left, path);
        int rightCount = goodNodes(root.right, path);
        if(!path.isEmpty())
            path.remove(path.size() - 1);

        if(!existsGreater(root.val, path))
            return leftCount + rightCount + 1;
        else
            return leftCount + rightCount;
    }

    public int goodNodes(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        return goodNodes(root, path);
    }
}
