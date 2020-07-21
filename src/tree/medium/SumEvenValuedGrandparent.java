package tree.medium;

public class SumEvenValuedGrandparent {
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

    private int sumEvenGrandparentUtil(TreeNode root, TreeNode parent, TreeNode grandParent) {
        if(root == null)
            return 0;

        int left = sumEvenGrandparentUtil(root.left, root, parent);
        int right = sumEvenGrandparentUtil(root.right, root, parent);

        int childrenSum = left + right;

        return (grandParent != null && grandParent.val % 2 == 0) ? childrenSum + root.val : childrenSum;
    }

    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparentUtil(root, null, null);
    }
}
