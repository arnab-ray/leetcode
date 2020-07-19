package bfs.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodesKDistance {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private void kDistanceDown(TreeNode node, int k, List<Integer> nodeList) {
        if(node == null || k < 0)
            return;

        if(k == 0) {
            nodeList.add(node.val);
            return;
        }

        kDistanceDown(node.left, k - 1, nodeList);
        kDistanceDown(node.right, k - 1, nodeList);
    }

    private int kDistanceNode(TreeNode root, TreeNode target, int k, List<Integer> nodeList) {
        if(root == null)
            return -1;

        if(root == target) {
            kDistanceDown(target, k, nodeList);
            return 0;
        }

        int distanceLeft = kDistanceNode(root.left, target, k, nodeList);
        if(distanceLeft != -1) {
            if(distanceLeft + 1 == k)
                nodeList.add(root.val);
            else
                kDistanceDown(root.right, k - distanceLeft - 2, nodeList);
            return distanceLeft + 1;
        }

        int distanceRight = kDistanceNode(root.right, target, k, nodeList);
        if(distanceRight != -1) {
            if(distanceRight + 1 == k)
                nodeList.add(root.val);
            else
                kDistanceDown(root.left, k - distanceRight - 2, nodeList);
            return distanceRight + 1;
        }

        return -1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root == null)
            return null;

        List<Integer> nodeList = new LinkedList<>();
        kDistanceNode(root, target, K, nodeList);

        return nodeList;
    }
}
