package slidingwindow.hard;

public class MinimumWindowSubsequence {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return "";

        int start = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        while (start < s.length()) {
            int tPos = 0;

            for (int end = start; end < s.length(); end++) {
                if (s.charAt(end) == t.charAt(tPos) && tPos == 0)
                    start = end;
                if (s.charAt(end) == t.charAt(tPos))
                    tPos++;

                if (tPos == t.length()) {
                    if (end - start + 1 < minLen) {
                        minStart = start;
                        minLen = end - start + 1;
                    }
                    start++;
                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
