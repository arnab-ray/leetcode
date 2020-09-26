package dynamicprogramming.hard;

import java.util.Stack;

public class MaximalRectangle {
    public int largestRectangleArea(char[] row) {
        Stack<Integer> stack = new Stack<>();
        int top, maxArea = 0, areaWithTop;

        int i = 0;
        while (i < row.length) {
            if (stack.isEmpty() || row[stack.peek()] <= row[i])
                stack.push(i++);
            else {
                top = stack.pop();
                areaWithTop = (row[top] - '0') * (stack.empty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, areaWithTop);
            }
        }

        while (!stack.empty()) {
            top = stack.pop();
            areaWithTop = (row[top] - '0') * (stack.empty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, areaWithTop);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        if (matrix.length > 0) {
            int m = matrix.length;
            int n = matrix[0].length;

            maxArea = largestRectangleArea(matrix[0]);

            for (int i = 1; i < matrix.length; i++) {
                System.out.println("Row: " + i);
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '1') {
                        matrix[i][j] = (char) (matrix[i - 1][j] + 1);
                        System.out.print(matrix[i][j] + " ");
                    }
                }
                System.out.println();

                int area = largestRectangleArea(matrix[i]);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
