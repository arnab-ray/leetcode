package string.easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean charSeen = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                charSeen = true;
                count++;
            } else {
                if (charSeen)
                    break;
            }
        }

        return count;
    }
}
