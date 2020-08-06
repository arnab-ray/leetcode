package stack.medium;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<String> integerStack = new Stack<>();

        StringBuilder sbInt = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                sbInt.append(s.charAt(i));
            } else if(s.charAt(i) == '[') {
                if(!sb.toString().isEmpty()) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                stack.push("[");
                integerStack.push(sbInt.toString());
                sbInt = new StringBuilder();
            } else if(Character.isAlphabetic(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == ']') {
                stack.push(sb.toString());
                sb = new StringBuilder();
                int multiplier = Integer.parseInt(integerStack.pop());
                StringBuilder stringBuilder = new StringBuilder();

                while (!stack.isEmpty()) {
                    if(stack.peek().compareTo("[") == 0)
                        break;
                    String str = stack.pop();
                    stringBuilder.insert(0, str);
                }

                StringBuilder stringBuilder1 = new StringBuilder();
                for(int j = 0; j < multiplier; j++)
                    stringBuilder1.append(stringBuilder.toString());
                stack.pop();
                stack.push(stringBuilder1.toString());
            }
        }

        stack.push(sb.toString());
        sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.insert(0, stack.pop());

        return sb.toString();
    }
}
