package greedy.medium;

import java.util.Stack;

public class MinimumAddParenthesis {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int counter = 0;

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(')
                stack.push(S.charAt(i));
            else {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    counter++;
            }
        }

        while (!stack.isEmpty()) {
            counter++;
            stack.pop();
        }

        return counter;
    }
}
