package arrays.medium;

import java.util.Arrays;

public class NextGreaterElementIII {

    private static boolean isReverseSorted(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i - 1] < digits[i])
                return false;
        }

        return true;
    }

    private static boolean isSorted(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i - 1] > digits[i])
                return false;
        }

        return true;
    }

    private static long createNum(int[] digits) {
        long result = 0;
        for (int digit : digits) {
            result = 10 * result + digit;
        }

        return result;
    }

    private static long nextGreaterElementUtil(int[] digits) {
        if (isReverseSorted(digits))
            return -1;
        else if (isSorted(digits)) {
            int lowIndex = -1;
            for (int i = digits.length - 1; i >= 1; i--) {
                if (digits[i - 1] < digits[i]) {
                    lowIndex = i - 1;
                    break;
                }
            }
            int temp = digits[lowIndex];
            digits[lowIndex] = digits[lowIndex + 1];
            digits[lowIndex + 1] = temp;
            return createNum(digits);
        } else {
            int lowIndex = -1;
            for (int i = digits.length - 1; i >= 1; i--) {
                if (digits[i - 1] < digits[i]) {
                    lowIndex = i - 1;
                    break;
                }
            }

            int highIndex = lowIndex + 1;
            for (int i = highIndex; i < digits.length; i++) {
                if (digits[i] > digits[lowIndex] && digits[i] < digits[highIndex]) {
                    highIndex = i;
                }
            }

            int temp = digits[lowIndex];
            digits[lowIndex] = digits[highIndex];
            digits[highIndex] = temp;

            Arrays.sort(digits, lowIndex + 1, digits.length);

            return createNum(digits);
        }
    }

    public static int nextGreaterElement(int n) {
        int[] digits = Integer.toString(n).chars().map(c -> c - '0').toArray();
        long val = nextGreaterElementUtil(digits);
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(11222333));
    }
}
