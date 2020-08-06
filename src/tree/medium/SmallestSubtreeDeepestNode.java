package tree.medium;

import java.util.LinkedList;
import java.util.List;

public class SmallestSubtreeDeepestNode {
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

    private int depthOfTree(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;

        return Math.max(depthOfTree(root.left), depthOfTree(root.right)) + 1;
    }

    private void deepestNodes(TreeNode root, List<TreeNode> currentPath, int depth, int maxDepth, List<List<TreeNode>> deepestPaths) {
        if(root == null)
            return;

        currentPath.add(root);
        if(depth == maxDepth) {
            deepestPaths.add(new LinkedList<>(currentPath));
        } else {
            deepestNodes(root.left, currentPath, depth + 1, maxDepth, deepestPaths);
            deepestNodes(root.right, currentPath, depth + 1, maxDepth, deepestPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root != null) {
            int depth = depthOfTree(root);
            System.out.println(depth);
            List<List<TreeNode>> deepestPaths = new LinkedList<>();
            List<TreeNode> currentPath = new LinkedList<>();
            deepestNodes(root, currentPath, 1, depth, deepestPaths);
            System.out.println(deepestPaths.size());

            if(deepestPaths.size() == 1) {
                List<TreeNode> path = deepestPaths.get(0);
                return path.get(path.size() - 1);
            }

            List<TreeNode> firstPath = deepestPaths.get(0);
            for(int i = 0; i < firstPath.size(); i++) {
                boolean containsInAll = true;
                for(List<TreeNode> path : deepestPaths) {
                    if(!path.contains(firstPath.get(i))) {
                        containsInAll = false;
                        break;
                    }
                }
                if(!containsInAll)
                    return firstPath.get(i - 1);
            }
        }
        return null;
    }

    public TreeNode subtreeWithAllDeepest_(TreeNode root) {
        int leftDepth = depthOfTree(root.left);
        int rightDepth = depthOfTree(root.right);

        if(leftDepth == rightDepth)
            return root;
        else if (leftDepth > rightDepth)
            return subtreeWithAllDeepest_(root.left);
        else
            return subtreeWithAllDeepest_(root.right);
    }
}
