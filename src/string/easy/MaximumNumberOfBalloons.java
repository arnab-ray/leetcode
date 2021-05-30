package string.easy;

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++)
            count[text.charAt(i) - 'a']++;

        int min = count[1];
        min = Math.min(min, count[0]);
        min = Math.min(min, count[11] / 2);
        min = Math.min(min, count[14] / 2);
        min = Math.min(min, count[13]);

        return min;
    }
}
