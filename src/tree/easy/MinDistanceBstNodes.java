package tree.easy;

import java.util.LinkedList;
import java.util.List;

public class MinDistanceBstNodes {
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

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrderUtil(root, list);

        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) {
            if(i > 0) {
                diff = Math.min(diff, list.get(i) - list.get(i - 1));
            }
        }

        return diff;
    }

    private void inOrderUtil(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        inOrderUtil(root.left, list);
        list.add(root.val);
        inOrderUtil(root.right, list);
    }
}
