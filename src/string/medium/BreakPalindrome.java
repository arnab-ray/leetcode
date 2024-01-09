package string.medium;

/**
 * Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase
 * English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
 * Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
 * A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ,
 * a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller
 * than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.
 */

public class BreakPalindrome {
    private boolean isPalindrome(char[] text) {
        int low = 0, high = text.length - 1;
        while (low < high) {
            if (text[low] == text[high]){
                low++;
                high--;
            } else {
                return false;
            }
        }

        return true;
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1)
            return "";

        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && chars[i] > 'a') {
                char c = chars[i];
                chars[i] = 'a';
                if (!isPalindrome(chars))
                    break;
                else
                    chars[i] = c;
            }
            else if (i == chars.length - 1) {
                chars[i] = 'b';
            }
        }

        return new String(chars);
    }
}
