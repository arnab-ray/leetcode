package julychallenge;

import java.util.*;

public class LevelOrderTraversal2 {
    private class TreeNode {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) {
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            //Stack<String> stack = new Stack<>();
            queue1.add(root);
            result.add(0, new ArrayList<>());
            while (!queue1.isEmpty()) {
                TreeNode node;
                while (!queue1.isEmpty()) {
                    node = queue1.poll();
                    result.get(0).add(node.val);
                    //stack.push(String.valueOf(node.val));
                    if (queue1.isEmpty())
                        result.add(0, new ArrayList<>());
                        //stack.push("#");
                    if(node.left != null)
                        queue2.add(node.left);
                    if(node.right != null)
                        queue2.add(node.right);
                }

                while (!queue2.isEmpty()){
                    node = queue2.poll();
                    result.get(0).add(node.val);
                    //stack.push(String.valueOf(node.val));
                    if (queue2.isEmpty() && !queue1.isEmpty())
                        result.add(0, new ArrayList<>());
                        //stack.push("#");
                    if(node.left != null)
                        queue1.add(node.left);
                    if(node.right != null)
                        queue1.add(node.right);
                }
            }

            /*List<Integer> values = new ArrayList<>();
            while (!stack.isEmpty()) {
                if(stack.peek().equals("#")) {
                    if(!values.isEmpty())
                        result.add(values);
                    values = new ArrayList<>();
                    stack.pop();
                } else {
                    values.add(Integer.parseInt(stack.pop()));
                }
            }

            if(!values.isEmpty())
                result.add(values);*/
        }

        return result;
    }
}
