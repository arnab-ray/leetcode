package string.easy;

public class MaxRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String temp = word;
        while (true) {
            if (sequence.contains(temp)) {
                count++;
                temp += word;
            } else {
                break;
            }
        }

        return count;
    }
}
