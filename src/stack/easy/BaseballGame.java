package stack.easy;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("D")) {
                int val = Integer.parseInt(stack.peek()) * 2;
                stack.push(String.valueOf(val));
            } else if (ops[i].equals("C")) {
                stack.pop();
            } else if (ops[i].equals("+")) {
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());
                int sum = first + second;

                stack.push(String.valueOf(second));
                stack.push(String.valueOf(first));
                stack.push(String.valueOf(sum));
            } else {
                stack.push(ops[i]);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += Integer.parseInt(stack.pop());
        }

        return sum;
    }
}
