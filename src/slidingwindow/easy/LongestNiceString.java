package slidingwindow.easy;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceString {
    public String longestNiceSubstring(String s) {
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                Set<Character> set = new HashSet<>();
                for (int k = j; k < j + i + 1; k++) {
                    set.add(s.charAt(k));
                }

                boolean flag = true;
                for (int k = j; k < j + i + 1; k++) {
                    char c = s.charAt(k);
                    if (Character.isUpperCase(c)) {
                        if (!set.contains(Character.toLowerCase(c))) {
                            flag = false;
                            break;
                        }
                    } else {
                        if (!set.contains(Character.toUpperCase(c))) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag)
                    return s.substring(j, j + i + 1);
            }
        }

        return "";
    }
}
