package string.easy;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            for (int j = 0; j < 26; j++) {
                if (count[j] > 0) {
                    sb.append((char)(j + 'a'));
                    count[j]--;
                    i++;
                }
            }

            for (int j = 25; j >= 0; j--) {
                if (count[j] > 0) {
                    sb.append((char)(j + 'a'));
                    count[j]--;
                    i++;
                }
            }
        }

        return sb.toString();
    }
}
