package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

public class FindTargetCopy {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(original);
        queue2.add(cloned);

        while (!queue1.isEmpty()) {
            TreeNode temp1 = queue1.poll();
            TreeNode temp2 = queue2.poll();

            if(temp1 == target)
                return temp2;

            if(temp1.left != null)
                queue1.add(temp1.left);
            if(temp1.right != null)
                queue1.add(temp1.right);

            if(temp2 != null) {
                if(temp2.left != null)
                    queue2.add(temp2.left);
                if(temp2.right != null)
                    queue2.add(temp2.right);
            }
        }

        return null;
    }
}
