package stack.easy;

import java.util.Stack;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../") && !stack.empty())
                stack.pop();
            else if (!logs[i].equals("./") && !logs[i].equals("../"))
                stack.push(logs[i]);
        }

        int count = 0;
        while (!stack.empty()) {
            stack.pop();
            count++;
        }

        return count;
    }
}
