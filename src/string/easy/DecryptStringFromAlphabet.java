package string.easy;

public class DecryptStringFromAlphabet {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            //System.out.println(s.charAt(i));
            if (s.charAt(i) != '#' && i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int val = Integer.parseInt(s.substring(i, i + 2));
                sb.append((char) ('a' + val - 1));
                i += 3;
            } else if (s.charAt(i) != '#') {
                int val = Character.getNumericValue(s.charAt(i));
                sb.append((char) ('a' + val - 1));
                i++;
            }
        }

        return sb.toString();
    }
}
