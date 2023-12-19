package backtracking.medium;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    private void helper(String s, int pos, StringBuilder sb, List<String> result) {
        if (pos == s.length()) {
            result.add(sb.toString());
            return;
        }

        if (Character.isLetter(s.charAt(pos))) {
            sb.append(Character.toLowerCase(s.charAt(pos)));
            helper(s, pos + 1, sb, result);
            sb.setLength(sb.length() - 1);

            sb.append(Character.toUpperCase(s.charAt(pos)));
        } else {
            sb.append(s.charAt(pos));
        }
        helper(s, pos + 1, sb, result);
        sb.setLength(sb.length() - 1);
    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        helper(s, 0, sb, result);

        return result;
    }
}
