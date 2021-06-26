package slidingwindow.easy;

public class CountGoodSubstring {
    public int countGoodSubstrings(String s) {
        int result = 0;
        int[] count = new int[26];

        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a']++ == 0)
                c++;

            if (i >= 2 && c == 3)
                result++;

            if (i >= 2) {
                if (count[s.charAt(i - 2) - 'a']-- == 1) {
                    c--;
                }
            }
        }

        return result;
    }
}
