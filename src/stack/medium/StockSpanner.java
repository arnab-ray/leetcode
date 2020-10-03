package stack.medium;

import java.util.Stack;

public class StockSpanner {
    static class Pair {
        int value, pos;
        public Pair(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }

    Stack<Pair> stack;
    int i;

    public StockSpanner() {
        stack = new Stack<>();
        i = 0;
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().value <= price)
            stack.pop();

        int val = stack.isEmpty() ? i + 1 : i - stack.peek().pos;
        stack.push(new Pair(price, i));
        i += 1;
        return val;
    }
}
