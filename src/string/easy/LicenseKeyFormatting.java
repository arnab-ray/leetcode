package string.easy;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        char[] key = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = key.length - 1; i >= 0; i--) {
            if (count == k) {
                sb.append("-");
                count = 0;
            }
            if (key[i] != '-') {
                sb.append(Character.toUpperCase(key[i]));
                count++;
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}
