package tree.medium;

public class MaximumTree {
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

    private int findIndexOfMax(int[] nums, int low, int high) {
        if(low <= high) {
            int maxIndex = low;
            for (int i = low + 1; i <= high; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }

            return maxIndex;
        }
        return -1;
    }

    public TreeNode constructTreeUtil(int[] nums, int low, int high) {
        int maxIndex = findIndexOfMax(nums, low, high);
        if(maxIndex != -1) {
            TreeNode node = new TreeNode(nums[maxIndex]);
            node.left = constructTreeUtil(nums, low, maxIndex - 1);
            node.right = constructTreeUtil(nums, maxIndex + 1, high);
            return node;
        }
        return null;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;
        return constructTreeUtil(nums, 0, nums.length - 1);
    }
}
