package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
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

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();

        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int n = queue.size();
            int previous = -1;

            for(int i = 0; i < n; i++) {
                TreeNode v = queue.poll();
                if(level % 2 == v.val % 2)
                    return false;
                if(previous != -1 && (level % 2 == 0 && v.val <= previous || level % 2 != 0 && v.val >= previous))
                    return false;

                previous = v.val;
                if(v.left != null)
                    tempQueue.add(v.left);
                if(v.right != null)
                    tempQueue.add(v.right);

                if(queue.isEmpty()) {
                    level++;
                    queue = tempQueue;
                    tempQueue = new LinkedList<>();
                }
            }
        }
        return true;
    }
}
