package tree.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BuildTree {
    public static class TreeNode {
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

    private static TreeNode buildTreeUtil(int[] preorder, Map<Integer, Integer> map, AtomicInteger index, int low, int high) {
        if (low > high)
            return null;

        TreeNode root = new TreeNode(preorder[index.getAndIncrement()]);
        int rootIndex = map.get(root.val);
        root.left = buildTreeUtil(preorder, map, index, low, rootIndex - 1);
        root.right = buildTreeUtil(preorder, map, index, rootIndex + 1, high);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }


        return buildTreeUtil(preorder, map, new AtomicInteger(0), 0, preorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
    }
}
