package string.easy;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) == ' ' || paragraph.charAt(i) == '!' || paragraph.charAt(i) == '?' ||
                    paragraph.charAt(i) == '\'' || paragraph.charAt(i) == ',' || paragraph.charAt(i) == ';' ||
                    paragraph.charAt(i) == '.') {
                if (sb.length() > 0) {
                    String s = sb.toString().toLowerCase();
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    sb = new StringBuilder();
                }
            } else {
                sb.append(paragraph.charAt(i));
            }
        }
        if (sb.length() > 0) {
            String s = sb.toString().toLowerCase();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int maxCount = Integer.MIN_VALUE;
        String result = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!set.contains(entry.getKey()) && maxCount < entry.getValue()) {
                result = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return result;
    }
}
