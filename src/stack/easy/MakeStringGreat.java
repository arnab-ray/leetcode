package stack.easy;

import java.util.Stack;

public class MakeStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (!stack.empty())  {
                boolean differingCase = (Character.isUpperCase(s.charAt(i)) && Character.isLowerCase(stack.peek())) ||
                        (Character.isLowerCase(s.charAt(i)) && Character.isUpperCase(stack.peek()));
                boolean sameChars = Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(stack.peek());

                if (differingCase && sameChars)
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
