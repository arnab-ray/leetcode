package greedy.medium;

public class MinSwapsToMakeEqual {
    public int minimumSwap(String s1, String s2) {
        int mismatches = 0, mismatchedXs = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatches++;
                if (s1.charAt(i) == 'x')
                    mismatchedXs++;
            }
        }

        if (mismatches % 2 == 1)
            return -1;

        return (mismatchedXs % 2) + (mismatches / 2);
    }
}
