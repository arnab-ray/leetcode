package slidingwindow.medium;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }

        if (isAnagram(countS1, countS2))
            return true;

        int m = s1.length(), n = s2.length();
        for (int i = m; i < n; i++) {
            countS2[s2.charAt(i - m) - 'a']--;
            countS2[s2.charAt(i) - 'a']++;

            if (isAnagram(countS1, countS2))
                return true;
        }

        return false;
    }

    private boolean isAnagram(int[] s, int[] p) {
        for (int i = 0; i < 26; i++) {
            if (s[i] != p[i])
                return false;
        }

        return true;
    }
}
