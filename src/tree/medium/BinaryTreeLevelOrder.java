package tree.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
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
 
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new LinkedList<>();

        List<List<Integer>> list = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> secondaryQueue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tempList.add(node.val);
            if(node.left != null)
                secondaryQueue.add(node.left);
            if(node.right != null)
                secondaryQueue.add(node.right);

            if(queue.isEmpty()) {
                list.add(tempList);
                tempList = new LinkedList<>();
                queue = secondaryQueue;
                secondaryQueue = new LinkedList<>();
            }
        }

        return list;
    }
}
