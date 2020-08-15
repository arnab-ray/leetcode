package tree.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SumRootToLeafNumbers {
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

    private void sumPathUtil(TreeNode root, List<Integer> path, AtomicInteger sum) {
        path.add(root.val);
        if(root.left == null && root.right == null) {
            int pathSum = 0;
            for(int i = path.size() - 1; i >= 0; i--) {
                pathSum += Math.pow(10, path.size() - i - 1) * path.get(i);
            }
            sum.set(sum.get() + pathSum);
        }

        if(root.left != null)
            sumPathUtil(root.left, path, sum);
        if(root.right != null)
            sumPathUtil(root.right, path, sum);

        path.remove(path.size() - 1);
    }
 
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;

        List<Integer> path = new LinkedList<>();
        AtomicInteger sum = new AtomicInteger(0);
        sumPathUtil(root, path, sum);

        return sum.get();
    }
}
