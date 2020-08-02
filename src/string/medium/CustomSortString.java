package string.medium;

public class CustomSortString {
    public String customSortString(String S, String T) {
        int[] charCount = new int[26];
        for(int i = 0; i < T.length(); i++)
            charCount[T.charAt(i) - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(T.indexOf(S.charAt(i)) > -1) {
                int index = S.charAt(i) - 'a';
                for(int j = 0; j < charCount[index]; j++) {
                    sb.append(S.charAt(i));
                }
                charCount[index] = 0;
            }
        }

        for(int i = 0; i < charCount.length; i++) {
            for(int j = 0; j < charCount[i]; j++) {
                sb.append((char)(i + 'a'));
            }
        }

        return sb.toString();
    }
}
