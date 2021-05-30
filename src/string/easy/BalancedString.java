package string.easy;

public class BalancedString {
    public int balancedStringSplit(String s) {
        int indicator = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                indicator++;
            else
                indicator--;

            if (indicator == 0)
                count++;
        }

        return count;
    }
}
