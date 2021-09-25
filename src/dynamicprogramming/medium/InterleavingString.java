package dynamicprogramming.medium;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {
    private boolean isInterleaveUtil(String s1, String s2, String s3, Map<String, Boolean> dp) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;

        if (s3.length() == 0)
            return false;

        String key = s1 + "," + s2 + "," + s3;

        if (!dp.containsKey(key)) {
            boolean x = (s1.length() != 0 && s1.charAt(0) == s3.charAt(0)) &&
                    isInterleaveUtil(s1.substring(1), s2, s3.substring(1), dp);

            boolean y = (s2.length() != 0 && s2.charAt(0) == s3.charAt(0)) &&
                    isInterleaveUtil(s1, s2.substring(1), s3.substring(1), dp);

            dp.put(key, x | y);
        }

        return dp.get(key);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        Map<String, Boolean> dp = new HashMap<>();
        return isInterleaveUtil(s1, s2, s3, dp);
    }
}
