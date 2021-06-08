package string.easy;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        else {
            char[] count = new char[26];
            for (int i = 0; i < ransomNote.length(); i++)
                count[ransomNote.charAt(i) - 'a']++;

            for (int i = 0; i < magazine.length(); i++) {
                int val = magazine.charAt(i) - 'a';
                if (count[val] > 0)
                    count[val]--;
            }

            for (int i = 0; i < 26; i++)
                if (count[i] > 0)
                    return false;

            return true;
        }
    }
}
