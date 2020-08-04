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

    private void evaluatePath(TreeNode root, List<Integer> path, AtomicInteger sumTillNow, List<List<Integer>> result, int sum) {
        if(root == null)
            return;

        sumTillNow.set(sumTillNow.get() + root.val);
        path.add(root.val);
        if(sumTillNow.get() == sum && root.left == null && root.right == null) {
            result.add(new LinkedList<>(path));
        }

        evaluatePath(root.left, path, sumTillNow, result, sum);
        evaluatePath(root.right, path, sumTillNow, result, sum);

        sumTillNow.set(sumTillNow.get() - root.val);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         List<List<Integer>> result = new LinkedList<>();
         AtomicInteger sumTillNow = new AtomicInteger(0);
         List<Integer> path = new LinkedList<>();
         evaluatePath(root, path, sumTillNow, result, sum);

         return result;
    }
}
