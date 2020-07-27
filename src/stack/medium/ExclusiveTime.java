package stack.medium;

import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] timeSpent = new int[n];

        String[] str = logs.get(0).split(":");
        stack.push(Integer.parseInt(str[0]));
        int i = 1, prev = Integer.parseInt(str[2]);

        while (i < logs.size()) {
            str = logs.get(i).split(":");
            if(str[1].equals("start")) {
                if(!stack.isEmpty()) {
                    timeSpent[stack.peek()] += Integer.parseInt(str[2]) - prev;
                }
                stack.push(Integer.parseInt(str[0]));
                prev = Integer.parseInt(str[2]);
            } else {
                timeSpent[stack.peek()] += Integer.parseInt(str[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(str[2]) + 1;
            }
            i++;
        }

        return timeSpent;
    }
}
