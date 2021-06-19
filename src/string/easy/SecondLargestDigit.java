package string.easy;

public class SecondLargestDigit {
    public int secondHighest(String s) {
        boolean[] num = new boolean[10];
        boolean numSeen = false;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int val = Character.getNumericValue(s.charAt(i));
                num[val] = true;
            }
        }

        for (int i = 9; i >= 0; i--) {
            if (numSeen && num[i]) {
                return i;
            } else if (num[i]) {
                numSeen = true;
            }
        }

        return -1;
    }
}
