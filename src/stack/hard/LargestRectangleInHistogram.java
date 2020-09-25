package stack.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int top, maxArea = 0, areaWithTop;

        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i++);
            else {
                top = stack.pop();
                areaWithTop = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);

                if (maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }

        while (!stack.empty()) {
            top = stack.pop();
            areaWithTop = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);

            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }

        return maxArea;
    }
}
