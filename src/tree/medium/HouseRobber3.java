package tree.medium;

public class HouseRobber3 {
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

    private int[] robUtil(TreeNode root) {
        if(root == null)
            return new int[]{0, 0};


        int[] val = new int[2];
        int[] left = robUtil(root.left);
        int[] right = robUtil(root.right);

        val[0] = root.val + left[1] + right[1];
        val[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return val;
    }
 
    public int rob(TreeNode root) {
        if(root == null)
            return 0;

        int[] cost = robUtil(root);
        return Math.max(cost[0], cost[1]);
    }
}
