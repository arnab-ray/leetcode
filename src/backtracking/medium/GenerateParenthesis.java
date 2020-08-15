package backtracking.medium;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    private void generateUtil(int i, StringBuilder sb, int openingBracketNum, int closingBracketNum, int n, List<String> list) {
        if(i == n) {
            list.add(sb.toString());
        }

        if(openingBracketNum > 0) {
            sb.append('(');
            generateUtil(i + 1, sb, openingBracketNum - 1, closingBracketNum, n, list);
            sb.setLength(sb.length() - 1);
        }
        if(closingBracketNum > openingBracketNum) {
            sb.append(')');
            generateUtil(i + 1, sb, openingBracketNum, closingBracketNum - 1, n, list);
            sb.setLength(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();

        if(n == 0)
            return list;

        StringBuilder sb = new StringBuilder();
        generateUtil(0, sb, n, n, 2 * n, list);

        return list;
    }
}
