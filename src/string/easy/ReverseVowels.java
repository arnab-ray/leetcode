package string.easy;

public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int start = 0, end = str.length - 1;

        while (start <= end) {
            if (isVowel(str[start]) && isVowel(str[end])) {
                char c = str[start];
                str[start] = str[end];
                str[end] = c;
                start++; end--;
            } else if (!isVowel(str[start])) {
                start++;
            } else {
                end--;
            }
        }

        return new String(str);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A'
                || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
