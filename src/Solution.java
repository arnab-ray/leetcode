import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<Character> getChars(String s) {
        List<Character> chars = new ArrayList<>();
        for(int i = 0; i < s.length() && i + 1 < s.length() && i + 2 < s.length(); i++) {
            if (s.charAt(i) == '$' && s.charAt(i + 1) == '{')
                chars.add(s.charAt(i + 2));
        }

        return chars;
    }


    public static void main(String[] args) {

    }
}
