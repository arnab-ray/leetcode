package tree.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AllElementsBST {
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

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);

        List<Integer> result = new LinkedList<>();

        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if(list1.get(i) < list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }

        while (i < list1.size())
            result.add(list1.get(i++));
        while (j < list2.size())
            result.add(list2.get(j++));

        return result;
    }
}
