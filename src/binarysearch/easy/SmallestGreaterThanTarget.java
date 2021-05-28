package binarysearch.easy;

public class SmallestGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        char result = 'z';

        if (target >= letters[letters.length - 1])
            return letters[0];

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                result = letters[mid];
                high = mid - 1;
            }
        }

        return result;
    }
}
