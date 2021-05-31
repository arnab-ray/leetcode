package map.easy;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[58];

        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'A']++;

        int len = 0;
        for (int i = 0; i < 58; i++) {
            if (count[i] % 2 == 1 && len % 2 == 0)
                len++;

            len += (count[i] / 2) * 2;
        }

        return len;
    }
}
