package slidingwindow.medium;

public class SubstringContainingAllThreeChars {
    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            result += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }

        return result;
    }
}
