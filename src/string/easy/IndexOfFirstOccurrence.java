package string.easy;

public class IndexOfFirstOccurrence {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;

        int needlePos = 0;
        for (int i = 0; i < haystack.length(); i++) {
            int start = i;
            while (start < haystack.length() && needlePos < needle.length() && haystack.charAt(start) == needle.charAt(needlePos)) {
                start++;
                needlePos++;
            }

            if (needlePos == needle.length()) return start - needle.length();
            needlePos = 0;
        }

        return -1;
    }
}
