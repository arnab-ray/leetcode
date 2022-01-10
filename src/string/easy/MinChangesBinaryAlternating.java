package string.easy;

/**
 * @author arnab.ray
 * @created on 10/01/22
 */
public class MinChangesBinaryAlternating {
    public int minOperations(String s) {
        int c1 = 0, c2 = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean even = i % 2 == 0;
            // 0 in odd place
            if ((!even && s.charAt(i) == '1') || (even && s.charAt(i) == '0'))
                c1++;

            // 0 in even place
            if ((even && s.charAt(i) == '1') || (!even && s.charAt(i) == '0'))
                c2++;
        }

        return Math.min(c1, c2);
    }
}
