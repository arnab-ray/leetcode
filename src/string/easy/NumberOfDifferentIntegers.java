package string.easy;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegers {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    set.add(sb.toString().replaceFirst("^0+(?!$)", ""));
                }
                sb = new StringBuilder();
            }
        }

        if (sb.length() > 0) {
            set.add(sb.toString().replaceFirst("^0+(?!$)", ""));
        }

        return set.size();
    }
}
