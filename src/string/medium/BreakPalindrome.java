package string.medium;

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
