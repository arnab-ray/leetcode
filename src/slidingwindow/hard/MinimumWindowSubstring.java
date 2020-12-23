package slidingwindow.hard;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return "";

        int[] map = new int[128];
        for (char c : t.toCharArray())
            map[c]++;

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        char[] arr = s.toCharArray();

        while (end < arr.length) {
            if (map[arr[end]] > 0)
                counter--;

            map[arr[end]]--;
            end++;

            while (counter == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }
                map[arr[start]]++;
                if (map[arr[start]] > 0)
                    counter++;

                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
