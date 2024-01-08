package stack.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int top, maxArea = 0, areaWithTop;

        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i++);
            else {
                top = stack.pop();
                areaWithTop = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);
                System.out.println(i + " : " + areaWithTop);
                maxArea = Math.max(maxArea, areaWithTop);
            }
        }

        System.out.println("i: " + i);
        while (!stack.empty()) {
            top = stack.pop();
            areaWithTop = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);
            System.out.println(i + " : " + areaWithTop);
            maxArea = Math.max(maxArea, areaWithTop);
        }

        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int top, maxArea = 0, i;

        stack.push(-1);
        for (i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            top = stack.pop();
            maxArea = Math.max(maxArea, heights[top] * (i - stack.peek() - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[] {2, 4};
        System.out.println(largestRectangleArea(new int[] {2, 4}));
        System.out.println(largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
    }
}
