package string.easy;

/**
 * @author arnab.ray
 * @created on 10/01/22
 */
// #344
public class ReverseString {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        char temp;
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
