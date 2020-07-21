package greedy.medium;

public class StringBreak {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] countChar1 = new int[26];
        int[] countChar2 = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            countChar1[s1.charAt(i) - 'a']++;
            countChar2[s2.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while(countChar1[i] > 0) {
                sb.append((char) (i + 'a'));
                countChar1[i]--;
            }
        }
        String str1 = sb.toString();

        sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while(countChar2[i] > 0) {
                sb.append((char) (i + 'a'));
                countChar2[i]--;
            }
        }
        String str2 = sb.toString();

        boolean breakA = true;
        for(int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                breakA = false;
                break;
            }
        }

        if(breakA)
            return true;
        else {
            boolean breakB = true;
            for (int i = 0; i < str1.length(); i++) {
                if (str2.charAt(i) < str1.charAt(i)) {
                    breakB = false;
                    break;
                }
            }

            return breakB;
        }
    }
}
