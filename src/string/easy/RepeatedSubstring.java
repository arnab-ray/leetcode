package string.easy;

public class RepeatedSubstring {
    // TODO: Practice with KMP
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(0, i);
            int times = s.length() / sub.length();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < times; j++)
                sb.append(sub);

            if (sb.toString().equals(s))
                return true;
        }

        return false;
    }
}
