package slidingwindow.medium;

import java.util.LinkedList;
import java.util.List;

public class FindAllAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new LinkedList<>();
        } else {
            int[] countP = new int[26];
            int[] countS = new int[26];
            List<Integer> result = new LinkedList<>();

            int m = s.length(), n = p.length();

            for (int i = 0; i < n; i++) {
                countP[p.charAt(i) - 'a']++;
                countS[s.charAt(i) - 'a']++;
            }

            if (isAnagram(countS, countP)) {
                result.add(0);
            }

            for (int i = n; i < m; i++) {
                countS[s.charAt(i - n) - 'a']--;
                countS[s.charAt(i) - 'a']++;

                if (isAnagram(countS, countP)) {
                    result.add(i - n + 1);
                }
            }

            return result;
        }
    }

    private boolean isAnagram(int[] s, int[] p) {
        for (int i = 0; i < 26; i++) {
            if (s[i] != p[i])
                return false;
        }

        return true;
    }
}
