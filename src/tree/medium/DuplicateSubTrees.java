package tree.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DuplicateSubTrees {
    private static class TreeNode {
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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        Map<String, Integer> count = new HashMap<>();

        getTreeString(root, result, count);
        return result;
    }

    private String getTreeString(TreeNode root, List<TreeNode> result, Map<String, Integer> count) {
        if(root == null) return "N";

        String left = getTreeString(root.left, result, count);
        String right = getTreeString(root.right, result, count);

        String curr = root.val + "," + left + "," + right;

        count.put(curr, count.getOrDefault(curr, 0) + 1);
        if(count.get(curr) == 2)
            result.add(root);

        return curr;
    }
}
