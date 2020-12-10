package greedy.medium;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (used[s.charAt(i) - 'a']) {
                continue;
            } else {
                while (!stack.isEmpty() && stack.peek() >= s.charAt(i) && i < lastOccurrence[stack.peek() - 'a']) {
                    used[stack.pop() - 'a'] = false;
                }
            }
            stack.push(s.charAt(i));
            used[s.charAt(i) - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}
