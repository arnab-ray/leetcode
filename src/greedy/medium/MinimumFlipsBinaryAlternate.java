package greedy.medium;

/**
 * @author arnab.ray
 * @created on 10/01/22
 */
// #1888
public class MinimumFlipsBinaryAlternate {
    public int minFlips(String s) {
        int n = s.length(), c1 = 0, c2 = 0;
        s += s;
        int minVal = n;

        for (int i = 0; i < 2 * n; i++) {
            if (s.charAt(i) - '0' == i % 2)
                c1++;
            else
                c2++;

            if (i >= n) {
                if (s.charAt(i - n) - '0' == (i - n) % 2)
                    c1--;
                else
                    c2--;

                minVal = Math.min(minVal, Math.min(c1, c2));
            }
        }

        return minVal;
    }
}
