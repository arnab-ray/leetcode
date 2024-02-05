package tree.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PathSum2 {
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

    private void pathSumUtil(TreeNode root, int targetSum, int currSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null)
            return;

        int sum = currSum + root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && sum == targetSum) {
            result.add(new LinkedList<>(path));
        }

        pathSumUtil(root.left, targetSum, sum, path, result);
        pathSumUtil(root.right, targetSum, sum, path, result);

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         List<List<Integer>> result = new LinkedList<>();
         List<Integer> path = new LinkedList<>();
         pathSumUtil(root, sum, 0, path, result);

         return result;
    }
}
