package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class KthHappyString {
    private static void helper(StringBuilder sb, int pos, char[] chars, char ch, int n, List<String> result) {
        if (pos == n) {
            result.add(sb.toString());
            return;
        }

        for (char aChar : chars) {
            if (aChar != ch) {
                sb.append(aChar);
                helper(sb, pos + 1, chars, aChar, n, result);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public static String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = { 'a', 'b', 'c' };
        helper(sb, 0, chars, ' ', n, result);

        return result.size() >= k ? result.get(k - 1) : "";
    }

    public static void main(String[] args) {
        System.out.println(getHappyString(3, 9));
    }
}
