package string.easy;

import java.util.*;

public class LongestCommonPrefix {
    private String createString(List<Character> prefixChars) {
        StringBuilder sb = new StringBuilder();
        for (Character c : prefixChars)
            sb.append(c);

        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        List<Character> prefixChars = new ArrayList<>();
        for (int j = 0; j < strs[0].length(); j++) {
            Set<Character> charsSeen = new HashSet<>();
            for (String str : strs) {
                charsSeen.add(j >= str.length() ? '#' : str.charAt(j));
            }

            if (charsSeen.size() > 1) {
                return createString(prefixChars);
            } else {
                prefixChars.add(charsSeen.iterator().next());
            }
        }

        return createString(prefixChars);
    }
}
