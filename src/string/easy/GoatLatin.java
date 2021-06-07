package string.easy;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        int countA = 1;
        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (isVowel(words[i].charAt(0))) {
                sb.append(words[i]);
            } else {
                sb.append(words[i].substring(1));
                sb.append(words[i].charAt(0));
            }
            sb.append("ma");
            for (int j = 0; j < countA; j++)
                sb.append("a");

            if (i < words.length - 1)
                sb.append(" ");
            countA++;
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char vowel : vowels) {
            if (vowel == c)
                return true;
        }

        return false;
    }
}
