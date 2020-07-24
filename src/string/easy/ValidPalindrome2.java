package string.easy;

public class ValidPalindrome2 {

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isEvenPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else {
                return isPalindrome(s.substring(i, j)) || isPalindrome(s.substring(i + 1, j + 1));
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if(isPalindrome(s))
            return true;

        return isEvenPalindrome(s);
    }
}
