package string.easy;

public class ReplaceQuestion {
    public String modifyString(String s) {
        char[] str = s.toCharArray();
        char[] result = new char[str.length];

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '?') {
                char c = 'a';
                while (i != 0 && result[i - 1] == c || i != str.length - 1 && str[i + 1] == c) {
                    c++;
                }
                System.out.println(c);
                result[i] = c;
            } else {
                result[i] = str[i];
            }
        }

        return new String(result);
    }
}
