package string.easy;

import java.util.*;

public class LongestCommonPrefix {
    private static String createString(List<Character> prefixChars) {
        StringBuilder sb = new StringBuilder();
        for (Character c : prefixChars)
            sb.append(c);

        return sb.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        List<Character> prefixChars = new ArrayList<>();
        for (int j = 0; j < strs[0].length(); j++) {
            Set<Character> charsSeen = new HashSet<>();
            for (String str : strs) {
                charsSeen.add(j >= str.length() ? '#' : str.charAt(j));
            }

            if (charsSeen.size() > 1) {
                System.out.println("charseen: " + charsSeen.size());
                return createString(prefixChars);
            } else {
                prefixChars.add(charsSeen.iterator().next());
            }
        }

        return createString(prefixChars);
    }

    public String longestCommonPrefix2(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minVal = Integer.MAX_VALUE;

        for (String str : strs) {
            minVal = Math.min(minVal, str.length());
        }

        for (int i = 0; i < minVal; i++) {
            char start = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != start) {
                    return sb.toString();
                }
            }

            sb.append(start);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = new String[] {"flower", "flow", "flog", "floppy"};
        System.out.println(longestCommonPrefix(input));
    }
}
