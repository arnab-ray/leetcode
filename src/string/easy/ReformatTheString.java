package string.easy;

public class ReformatTheString {
    public String reformat(String s) {
        char[] str = s.toCharArray();
        int countLetter = 0, countDigit = 0;
        for (char c : str) {
            if (c >= '0' && c <= '9') {
                countDigit++;
            } else {
                countLetter++;
            }
        }

        if (countDigit < countLetter - 1 || countLetter < countDigit - 1) {
            return "";
        } else {
            int i = 0, j = 1;
            char[] result = new char[s.length()];
            if (countDigit > countLetter) {
                for (int k = 0; k < str.length; k++) {
                    if (str[k] >= '0' && str[k] <= '9') {
                        result[i] = s.charAt(k);
                        i += 2;
                    } else {
                        result[j] = s.charAt(k);
                        j += 2;
                    }
                }
            } else {
                for (int k = 0; k < s.length(); k++) {
                    if (str[k] >= '0' && str[k] <= '9') {
                        result[j] = s.charAt(k);
                        j += 2;
                    } else {
                        result[i] = s.charAt(k);
                        i += 2;
                    }
                }
            }

            return new String(result);
        }
    }
}
