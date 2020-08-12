package tree.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigzagTraversal {
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
 
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new LinkedList<>();

        List<List<Integer>> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> secondaryStack = new Stack<>();
        boolean leftToRight = true;

        List<Integer> list = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if(leftToRight) {
                if(node.left != null)
                    secondaryStack.add(node.left);
                if(node.right != null)
                    secondaryStack.add(node.right);
            } else {
                if(node.right != null)
                    secondaryStack.add(node.right);
                if(node.left != null)
                    secondaryStack.add(node.left);
            }

            if(stack.isEmpty()) {
                leftToRight = !leftToRight;
                result.add(list);
                list = new LinkedList<>();
                stack = secondaryStack;
                secondaryStack = new Stack<>();
            }
        }

        return result;
    }
}
