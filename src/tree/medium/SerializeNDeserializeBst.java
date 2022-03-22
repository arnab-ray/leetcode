package tree.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arnab.ray
 * @created on 22/03/22
 */
// #449 #297
public class SerializeNDeserializeBst {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        } else {
            String left = serialize(root.left);
            String right = serialize(root.right);
            return root.val + " " + left + " " + right;
        }
    }

    private TreeNode deserializeUtil(Queue<String> queue) {
        String strVal = queue.poll();
        if (strVal == null || strVal.equals("#"))
            return null;

        int val = Integer.parseInt(strVal);
        TreeNode root = new TreeNode(val);
        root.left = deserializeUtil(queue);
        root.right = deserializeUtil(queue);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(" ")));
        return deserializeUtil(queue);
    }
}
