package greedy.medium;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if(num == null)
            return null;
        else if(num.length() == 0 || num.length() <= k)
            return "0";

        Stack<Character> stack = new Stack<>();
        Stack<Character> reverseStack = new Stack<>();

        for(int i = num.length() - 1; i >= 0; i--)
            stack.push(num.charAt(i));

        while (k > 0 && !stack.isEmpty()) {
            Character u = stack.pop();
            Character v = stack.peek();

            if(v == '0') {
                stack.pop();
                k--;
            } else if(Integer.valueOf(u) < Integer.valueOf(v)) {
                stack.pop();
                stack.push(u);
                k--;
            } else if(Integer.valueOf(u) > Integer.valueOf(v)) {
                k--;
            } else {
                stack.push(u);
                break;
            }
        }

        System.out.println(k);
        if(stack.isEmpty()) {
            return "0";
        } else if(k <= 0) {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty())
                sb.append(stack.pop());
            return sb.toString();
        } else {
            // copy stack to reverse stack
            System.out.println("stack contents:: ");
            while (!stack.isEmpty()) {
                Character x = stack.pop();
                System.out.print(x + " ");
                reverseStack.push(x);
            }
            System.out.println();

            // empty the reverse stack
            while (k > 0 && !reverseStack.isEmpty()) {
                Character u = reverseStack.pop();
                System.out.println("u:: " + u);
                if (!reverseStack.isEmpty()) {
                    Character v = reverseStack.peek();
                    if(Integer.valueOf(u) < Integer.valueOf(v)) {
                        reverseStack.pop();
                        reverseStack.push(u);
                    }
                }
                k--;
                System.out.println("k:: " + k);
            }

            if(reverseStack.isEmpty())
                return "0";

            StringBuilder sb = new StringBuilder();
            while (!reverseStack.isEmpty())
                sb.append(reverseStack.pop());

            return sb.reverse().toString();
        }
    }
}
