package greedy.medium;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(num == null || num.isEmpty())
            return "0";

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                k--;
                stack.pop();
            }
            stack.push(num.charAt(i));
        }

        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
