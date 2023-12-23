import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    class Group {
        String groupName;
        Expression[] expressions;
    }

    class Expression {
        String name;
        String expressionType;
        String expression;
        String[] dependencies;
    }

    private static List<Character> getChars(String s) {
        List<Character> chars = new ArrayList<>();
        for(int i = 0; i < s.length() && i + 1 < s.length() && i + 2 < s.length(); i++) {
            if (s.charAt(i) == '$' && s.charAt(i + 1) == '{')
                chars.add(s.charAt(i + 2));
        }

        return chars;
    }

    public static void main(String[] args) {
        String in = "${a} + ${b} + 10";
        String[] strs = in.split(" \\+ ");
        System.out.println(strs.length);
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].startsWith("$"))
                System.out.println(strs[i].substring(2, strs[i].length() - 1));
            else {
                System.out.println(strs[i]);
            }
        }
        List<Character> chars = getChars("${a} + ${b} + 10");
        for (int i = 0; i < chars.size(); i++) {
            System.out.println(chars.get(i));
        }
    }
}
