package string.easy;

public class NumberOfSegments {
    public int countSegments(String s) {
        if (s.isEmpty())
            return 0;

        boolean nonSpace = false;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && nonSpace) {
                count++;
                nonSpace = false;
            } else if (s.charAt(i) != ' ') {
                nonSpace = true;
            }
        }

        return s.charAt(s.length() - 1) == ' ' ? count : count + 1;
    }
}
