package string.medium;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");

        for (String string : strings)
            System.out.println(string);

        for (String string : strings) {
            if (string.equals(".")) {
                continue;
            } else if (string.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    continue;
            } else if(!string.isEmpty()) {
                stack.push(string);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String string = stack.pop();
            if(!string.isEmpty()) {
                sb.insert(0, string);
                sb.insert(0, "/");
            }
        }

        return sb.toString().isEmpty() ? "/" : sb.toString();
    }
}
