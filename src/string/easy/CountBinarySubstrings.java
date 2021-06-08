package string.easy;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int counter = 0;
        int[] count = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                count[i] = 1;
            } else {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    count[i] = 1;
                    counter++;
                } else {
                    count[i] = count[i - 1] + 1;
                    if (i - count[i] >= 0 && s.charAt(i) != s.charAt(i - count[i]) && count[i] <= count[i - count[i]]) {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }
}
