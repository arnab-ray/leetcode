package string.easy;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if (S != null) {
            char[] input = S.toCharArray();
            int first = 0, last = input.length - 1;
            while (first < last) {
                if (Character.isLetter(input[first]) && Character.isLetter(input[last])) {
                    char temp = input[first];
                    input[first] = input[last];
                    input[last] = temp;
                    first++; last--;
                } else if (!Character.isLetter(input[first])) {
                    first++;
                } else if (!Character.isLetter(input[last])) {
                    last--;
                }
            }

            return new String(input);
        }

        return null;
    }
}
