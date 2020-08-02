package string.medium;

import java.util.Stack;

public class ValidParenthesis {
    public boolean checkValidString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack1.push(i);
            else if(s.charAt(i) == '*')
                stack2.push(i);
            else {
                if(stack1.isEmpty() && stack2.isEmpty())
                    return false;
                else if(stack1.isEmpty())
                    stack2.pop();
                else
                    stack1.pop();
            }
        }

        if(stack1.isEmpty())
            return true;
        else {
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                if(stack1.peek() < stack2.peek()) {
                    stack1.pop();
                    stack2.pop();
                } else {
                    return false;
                }
            }

            return stack1.isEmpty();
        }
    }
}
